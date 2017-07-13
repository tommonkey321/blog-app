package com.tommonkey.common.comment.service.impl;

import com.tommonkey.common.comment.dao.ICfgCmtBasicDao;
import com.tommonkey.common.comment.dao.ICfgCmtInstSubDao;
import com.tommonkey.common.comment.entity.CfgCmtBasicEntity;
import com.tommonkey.common.comment.entity.CfgCmtInstSubEntity;
import com.tommonkey.common.comment.service.interfaces.ICfgCmtInstSubSV;
import com.tommonkey.common.comment.utils.CommentConstants;
import com.tommonkey.common.persistence.entity.Page;
import com.tommonkey.utils.common.StringUtils;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CfgCmtInstSubSVImpl implements ICfgCmtInstSubSV {
	@Autowired
	private ICfgCmtInstSubDao dao;
    @Autowired
    private ICfgCmtBasicDao cfgCmtBasicDao;

	/**
	 * 保存子评论
	 * @param paramMap
	 * @throws Exception
	 */
	@Override
	public void saveCfgCmtInstSubInfo(Map<String, Object> paramMap) throws Exception {

        List<CfgCmtInstSubEntity> saveInfo = new ArrayList<>();
		UserInfoInterface userInfoInterface = (UserInfoInterface) paramMap.get("_loginInfo_user");
		String moduleId = String.valueOf(paramMap.get("moduleId"));
		String cmtTargetId = String.valueOf(paramMap.get("cmtTargetId"));
		if(StringUtils.isBlank(moduleId) ||
				(!StringUtils.equals("1", moduleId) && !StringUtils.equals("2",moduleId))){
			throw new Exception("数据来源异常！");
		}
		if(StringUtils.isBlank(cmtTargetId)){
			throw new Exception("业务类型不能为空！");
		}
        List<Map<String,String>> cmtInfo = (List<Map<String, String>>) paramMap.get("CMT_INFO");
        if(null == cmtInfo){
            return;
        }
        for(Map<String,String> itemCmt : cmtInfo){
            CfgCmtInstSubEntity cfgCmtInstSubEntity = new CfgCmtInstSubEntity();
            String cmtInstId = String.valueOf(itemCmt.get("cmtInstId"));
            String relatItemId = String.valueOf(itemCmt.get("relatItemId"));
            String createId = String.valueOf(itemCmt.get("createId"));
            String createName = String.valueOf(itemCmt.get("createName"));
            String parentSubInstId = itemCmt.containsKey("parentSubInstId")?String.valueOf(itemCmt.get("parentSubInstId")):"-1";
            String itemVal = String.valueOf(itemCmt.get("itemVal"));
            //当前评论的操作类型，若为空则默认为新增
            String operType = itemCmt.containsKey("operType")?String.valueOf(itemCmt.get("operType")):"add";

            if(StringUtils.isBlank(parentSubInstId)){
                parentSubInstId = "-1";
            }
            if(StringUtils.equals(operType,"update")){
                //若是更新的，需要先将已有的记录置为无效
                CfgCmtInstSubEntity querySubEntity = new CfgCmtInstSubEntity();
                querySubEntity.setCmtInstId(Long.parseLong(cmtInstId));
                querySubEntity.setSubCmtTargetId(cmtTargetId);
                querySubEntity.setItemId(Long.parseLong(relatItemId));
                querySubEntity.setRelatSubCmiInstId(Long.parseLong(parentSubInstId));
                List<CfgCmtInstSubEntity> cfgCmtInstSub = dao.findByEntity(querySubEntity);
                if(null != cfgCmtInstSub && cfgCmtInstSub.size()>0){
                    for(CfgCmtInstSubEntity subItem : cfgCmtInstSub){
                        if(subItem.getCreator()==userInfoInterface.getUserId() &&
                                subItem.getCmtor()==Long.parseLong(createId)){
                            //将无效的信息放入历史表中
                            dao.deleteByEntity(subItem);
                        }
                    }
                }

            }
            CfgCmtBasicEntity cfgCmtBasicEntity = new CfgCmtBasicEntity();
            cfgCmtBasicEntity.setItemId(Long.parseLong(relatItemId));
            cfgCmtBasicEntity.setCmtTargetId(cmtTargetId);
            cfgCmtBasicEntity.setState(CommentConstants.State.STATE_NORMAL);

            List<CfgCmtBasicEntity> cfgCmtBasicResult = cfgCmtBasicDao.findByEntity(cfgCmtBasicEntity);

            if(null == cfgCmtBasicResult || cfgCmtBasicResult.size()<1){
                throw new Exception("未找到相关的评论配置信息！请检查~~");
            }
            if(!StringUtils.equals("false",itemVal)){
                cfgCmtInstSubEntity.setSubCmtTargetId(cmtTargetId);
                cfgCmtInstSubEntity.setSubCmtInstId(cfgCmtInstSubEntity.newId());
                cfgCmtInstSubEntity.setCmtInstId(Long.parseLong(cmtInstId));
                cfgCmtInstSubEntity.setItemId(Long.parseLong(relatItemId));
                cfgCmtInstSubEntity.setGroupId(cfgCmtBasicResult.get(0).getGroupId());
                cfgCmtInstSubEntity.setItemValue(itemVal);
                cfgCmtInstSubEntity.setRelatSubCmiInstId(Long.parseLong(parentSubInstId));
                cfgCmtInstSubEntity.setModuleId(Integer.parseInt(moduleId));
                cfgCmtInstSubEntity.setCreator(userInfoInterface.getUserId());
                cfgCmtInstSubEntity.setCreatorName(userInfoInterface.getNikeName());
                cfgCmtInstSubEntity.setCreateDate(new Date());
                cfgCmtInstSubEntity.setCmtor(Long.parseLong(createId));
                cfgCmtInstSubEntity.setCmtName(createName);
                cfgCmtInstSubEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
                saveInfo.add(cfgCmtInstSubEntity);
            }
        }
        if(saveInfo.size()>0){
            dao.save(saveInfo);
        }
	}

    /**
     * 查询子评论信息
     * @param requestMap
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, String>> queryCfgCmtInstSubInfo(Map<String, Object> requestMap) throws Exception {
        List<Map<String,String>> result = new ArrayList<>();
        String relatItemId = String.valueOf(requestMap.get("relatItemId"));
        String cmtInstId = String.valueOf(requestMap.get("cmtInstId"));
        String pageNo = String.valueOf(requestMap.get("pageNo"));
        String pageSize = String.valueOf(requestMap.get("pageSize"));
        String cmtTargetId = String.valueOf(requestMap.get("cmtTargetId"));
        if(StringUtils.isBlank(cmtInstId)){
            return null;
        }
        if(StringUtils.isBlank(relatItemId)){
            return null;
        }
        CfgCmtInstSubEntity cfgCmtInstSubEntity = new CfgCmtInstSubEntity();
        cfgCmtInstSubEntity.setItemId(Long.parseLong(relatItemId));
        cfgCmtInstSubEntity.setCmtInstId(Long.parseLong(cmtInstId));
        cfgCmtInstSubEntity.setSubCmtTargetId(cmtTargetId);
        Page page = new Page(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        cfgCmtInstSubEntity.setPage(page);
        cfgCmtInstSubEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
        List<CfgCmtInstSubEntity> cfgCmtInstSub = dao.findByEntity(cfgCmtInstSubEntity,"createDate");
        if(null == cfgCmtInstSub || cfgCmtInstSub.size()<1){
            return null;
        }
        for(CfgCmtInstSubEntity subItem : cfgCmtInstSub){
            Map<String,String> itemMap = new HashMap<>();
            itemMap.put("creator",String.valueOf(subItem.getCreator()));
            itemMap.put("createName",subItem.getCreatorName());
            itemMap.put("cmtName",subItem.getCmtName());
            itemMap.put("cmtor",String.valueOf(subItem.getCmtor()));
            itemMap.put("itemVal",subItem.getItemValue());
            itemMap.put("itemId",String.valueOf(subItem.getItemId()));
            itemMap.put("cmtInstId",String.valueOf(subItem.getCmtInstId()));
            itemMap.put("subInstId",String.valueOf(subItem.getSubCmtInstId()));
            result.add(itemMap);
        }
        return result;
    }

    @Override
    public boolean checkOperatorHasSubCmt(Map<String, Object> requestMap) throws Exception {
        String cmtInstId = String.valueOf(requestMap.get("CMT_INST_ID"));
        String itemId = String.valueOf(requestMap.get("ITEM_ID"));
        String cmtTargetId = String.valueOf(requestMap.get("CMT_TARGET_ID"));
        String parentCmtInstId = String.valueOf(requestMap.get("PAREENT_CMT_INST_ID"));
        if(StringUtils.isBlank(itemId)){
            return false;
        }
        if(StringUtils.isBlank(cmtInstId)){
            return false;
        }
        UserInfoInterface userInfoInterface = (UserInfoInterface) requestMap.get("_loginInfo_user");
        if(StringUtils.isBlank(cmtTargetId)||
                StringUtils.equals("null",cmtTargetId) ||
                StringUtils.equals("undefined",cmtTargetId)){
            return false;
        }
        CfgCmtInstSubEntity cfgCmtInstSubEntity = new CfgCmtInstSubEntity();
        cfgCmtInstSubEntity.setSubCmtTargetId(cmtTargetId);
        cfgCmtInstSubEntity.setItemId(Long.parseLong(itemId));
        cfgCmtInstSubEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
        cfgCmtInstSubEntity.setCmtInstId(Long.parseLong(cmtInstId));
        cfgCmtInstSubEntity.setRelatSubCmiInstId(Long.parseLong(parentCmtInstId));
        cfgCmtInstSubEntity.setCreator(userInfoInterface.getUserId());
        List<CfgCmtInstSubEntity> firstResult = dao.findByEntity(cfgCmtInstSubEntity);
        for(int i=0; null != firstResult && i < firstResult.size(); i++){
            String itemVal = firstResult.get(i).getItemValue();
            if(StringUtils.equals(itemVal,"false")){
                continue;
            }
            return true;
        }
        return false;
    }

    /**
     * 获取子评论的评论个数
     * @param requestMap
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Integer> getSubCmtItemCount(Map<String, Object> requestMap) throws Exception {
        Map<String,Integer> resultMap = new HashMap<>();
        String cmtInstId = requestMap.containsKey("cmtInstId")?String.valueOf(requestMap.get("cmtInstId")):"";
        String subCmtTargetId = requestMap.containsKey("subCmtTargetId")?String.valueOf(requestMap.get("subCmtTargetId")):"";
        String subItemId = requestMap.containsKey("itemId")?String.valueOf(requestMap.get("itemId")):"";
        if(StringUtils.isBlank(cmtInstId)){
            return null;
        }
        CfgCmtInstSubEntity cfgCmtInstSubEntity = new CfgCmtInstSubEntity();
        cfgCmtInstSubEntity.setCmtInstId(Long.parseLong(cmtInstId));
        cfgCmtInstSubEntity.setSubCmtTargetId(subCmtTargetId);
        if(StringUtils.isNotBlank(subItemId)){
            cfgCmtInstSubEntity.setItemId(Long.parseLong(subItemId));
        }
        List<Map> result = dao.getSubCmtItemCount(cfgCmtInstSubEntity);
        for(int i=0; null != result && i<result.size(); i++ ){
            Map temp = result.get(i);
            String count = String.valueOf(temp.get("count"));
            String itemId = String.valueOf(temp.get("itemId"));
            resultMap.put(itemId,Integer.parseInt(count));
        }
        return resultMap;
    }
}