package com.tommonkey.common.comment.service.impl;

import com.tommonkey.common.comment.dao.ICfgCmtBasicDao;
import com.tommonkey.common.comment.dao.ICfgCmtInstDao;
import com.tommonkey.common.comment.dao.ICfgCmtInstSubDao;
import com.tommonkey.common.comment.entity.CfgCmtBasicEntity;
import com.tommonkey.common.comment.entity.CfgCmtInstEntity;
import com.tommonkey.common.comment.service.interfaces.ICfgCmtInstSV;
import com.tommonkey.common.comment.utils.CommentConstants;
import com.tommonkey.common.persistence.entity.Page;
import com.tommonkey.common.utils.DateUtils;
import com.tommonkey.utils.common.StringUtils;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CfgCmtInstSVImpl implements ICfgCmtInstSV {
	@Autowired
	private ICfgCmtInstDao dao;
    @Autowired
    private ICfgCmtBasicDao cfgCmtBasicDao;
    @Autowired
    private ICfgCmtInstSubDao cfgCmtInstSubDao;

	/**
	 * 保存评论信息
	 * @param paramMap
	 * @throws Exception
	 */
	@Override
	public void commitCMTCxtInst(Map<String, Object> paramMap) throws Exception {
        UserInfoInterface userInfoInterface = (UserInfoInterface) paramMap.get("_loginInfo_user");
        String moduleId = String.valueOf(paramMap.get("moduleId"));
        String cmtTargetId = String.valueOf(paramMap.get("cmtTargetId"));
        String outNbrId = paramMap.containsKey("out_nbr_id") ? String.valueOf(paramMap.get("out_nbr_id")) : "-1";
        if(StringUtils.isBlank(moduleId) ||
                (!StringUtils.equals("1",moduleId) && !StringUtils.equals("2",moduleId))){
            throw new Exception("数据来源异常！");
        }
        if(StringUtils.isBlank(cmtTargetId) ||
                StringUtils.equals("null",cmtTargetId) ||
                StringUtils.equals("undefined",cmtTargetId)){
            throw new Exception("业务类型不能为空！");
        }
        //用于区别是同一组的数据
        //todo
        String ext2 = DateUtils.getDate()+""+userInfoInterface.getUserId();
        List<Map<String,String>> cmtInfo = (List<Map<String, String>>) paramMap.get("CMT_INFO");
        List<CfgCmtInstEntity> saveInfo = new ArrayList<>();
        if(null != cmtInfo){
            for(Map<String,String> itemInfo : cmtInfo){
                CfgCmtInstEntity cfgCmtInstEntity = new CfgCmtInstEntity();
                String itemVal = String.valueOf(itemInfo.get("value"));
                String itemId = String.valueOf(itemInfo.get("itemId"));
                String groupId = String.valueOf(itemInfo.get("groupId"));
                String subCMT = itemInfo.containsKey("subCmt") ? String.valueOf(itemInfo.get("subCmt")) : "";
                //校验是否存在当前的配置信息
                CfgCmtBasicEntity cfgCmtBasicEntity = new CfgCmtBasicEntity();
                cfgCmtBasicEntity.setItemId(Long.parseLong(itemId));
                if(StringUtils.equals("SUBCMT",subCMT)){
                    cfgCmtBasicEntity.setCmtTargetId("SUBCMT_"+cmtTargetId);
                }else{
                    cfgCmtBasicEntity.setCmtTargetId(cmtTargetId);
                }

                cfgCmtBasicEntity.setState(CommentConstants.State.STATE_NORMAL);
                List<CfgCmtBasicEntity> cfgInfo = cfgCmtBasicDao.findByEntity(cfgCmtBasicEntity);
                if(null == cfgInfo || cfgInfo.size() < 1){
                    throw new Exception("未找到当前有效的评论配置信息，请联系管理员！");
                }
                //操作类型
                String operType = itemInfo.get("operType");
                if(!StringUtils.isBlank(operType) && StringUtils.equals("update",operType)){
                    //若是更新操作，则需要先置已有的记录为无效
                    CfgCmtInstEntity queryEntity = new CfgCmtInstEntity();
                    queryEntity.setItemId(Long.parseLong(itemId));
                    queryEntity.setCmtTargetId(cmtTargetId);
                    queryEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
                    queryEntity.setOutNbrId(Long.parseLong(outNbrId));
                    List<CfgCmtInstEntity>curResult = dao.findByEntity(queryEntity);
                    if(null != curResult){
                        for(CfgCmtInstEntity cmtEntity : curResult){
                            if(cmtEntity.getCreator().equals(userInfoInterface.getUserId())){
                                dao.deleteByEntity(cmtEntity);
                            }
                        }
                    }
                    //再判断是否是互斥组的记录，若是互斥组的记录则需要把互斥的item的值也删除
                    int itemGroupId = cfgInfo.get(0).getGroupId();
                    if(itemGroupId == 1){
                        //先找到所有的同组的item
                        CfgCmtBasicEntity cfgCmtBasicEntity1 = new CfgCmtBasicEntity();
                        cfgCmtBasicEntity1.setCmtTargetId(cmtTargetId);
                        cfgCmtBasicEntity1.setState(CommentConstants.State.STATE_NORMAL);
                        List<CfgCmtBasicEntity> cfgInfoItem = cfgCmtBasicDao.findByEntity(cfgCmtBasicEntity1);
                        if(null != cfgInfoItem){
                            for(CfgCmtBasicEntity cmtBasicEntity : cfgInfoItem){
                                if(cmtBasicEntity.getGroupId()!=1){
                                    continue;
                                }
                                //若是当前的item则不要再删除已有的记录
                                if(String.valueOf(cmtBasicEntity.getItemId()).equals(itemId)){
                                    continue;
                                }
                                CfgCmtInstEntity queryEntity1 = new CfgCmtInstEntity();
                                queryEntity1.setItemId(cmtBasicEntity.getItemId());
                                queryEntity1.setCmtTargetId(cmtTargetId);
                                queryEntity1.setCmtState(CommentConstants.State.STATE_NORMAL);
                                queryEntity1.setOutNbrId(Long.parseLong(outNbrId));
                                List<CfgCmtInstEntity> curResult1 = dao.findByEntity(queryEntity1);
                                if(null == curResult1){
                                    continue;
                                }
                                for(CfgCmtInstEntity cmtEntity : curResult1){
                                    if(cmtEntity.getCreator().equals(userInfoInterface.getUserId())){
                                        dao.deleteByEntity(cmtEntity);
                                    }
                                }
                            }
                        }

                    }
                }
                if(!StringUtils.equals("false",itemVal)){
                    //如果是点赞的取消点赞，则不需要再记录评论信息
                    cfgCmtInstEntity.setCmtInstId(cfgCmtInstEntity.newId());
                    cfgCmtInstEntity.setCmtTargetId(cmtTargetId);
                    cfgCmtInstEntity.setItemId(Long.parseLong(itemId));
                    cfgCmtInstEntity.setItemValue(itemVal);
                    cfgCmtInstEntity.setItemText(itemVal);
                    cfgCmtInstEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
                    cfgCmtInstEntity.setModuleId(Integer.parseInt(moduleId));
                    cfgCmtInstEntity.setCreator(userInfoInterface.getUserId());
                    cfgCmtInstEntity.setCreatorName(userInfoInterface.getNikeName());
                    cfgCmtInstEntity.setCreateDate(new Date());
                    cfgCmtInstEntity.setGroupId(Integer.parseInt(groupId));
                    cfgCmtInstEntity.setOutNbrId(Long.parseLong(outNbrId));
                    cfgCmtInstEntity.setExt2(ext2);
                    saveInfo.add(cfgCmtInstEntity);
                }
            }

        }
        if(null != saveInfo && saveInfo.size()>0){
            dao.save(saveInfo);
        }
	}

    /**
     * 查询文字评论历史记录
     * @param paramMap {page:"",pageSize:"",itemIds:"1_2",cmtTargetId:""}
     * @return List<Map>
     *     [{itemId1:itemVal1,itemId2:itemVal2,cmtTargetId:"",creator:"",creatorName:"",createDate:""},<br/>{}]
     * @throws Exception
     */
    @Override
    public List<Map<String, String>> queryCMTCxtInst4CXT(Map<String, Object> paramMap) throws Exception {
        List<Map<String,String>> resultQuery = new ArrayList<>();
        String currPage = String.valueOf(paramMap.get("page"));
        String pageSize = String.valueOf(paramMap.get("pageSize"));
        String itemIds = String.valueOf(paramMap.get("itemIds"));
        String cmtTargetId = String.valueOf(paramMap.get("cmtTargetId"));
        String outNbrId = paramMap.containsKey("out_nbr_id")?String.valueOf(paramMap.get("out_nbr_id")):"-1";
        if(StringUtils.isBlank(itemIds)){
            return null;
        }
        String[] itemIdArr = itemIds.split("_");
        if(itemIdArr.length>0){
            CfgCmtInstEntity firstCmtInstEntity = new CfgCmtInstEntity();
            firstCmtInstEntity.setCmtTargetId(cmtTargetId);
            //1、先已一个itemId为基础分页查找
            firstCmtInstEntity.setItemId(Long.parseLong(itemIdArr[0]));
            firstCmtInstEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
            firstCmtInstEntity.setOutNbrId(Long.parseLong(outNbrId));
            Page page = new Page(Integer.parseInt(currPage),Integer.parseInt(pageSize));
            firstCmtInstEntity.setPage(page);
            List<CfgCmtInstEntity> firstResult = dao.findByEntity(firstCmtInstEntity,"createDate");
            if(null == firstResult) {
                return null;
            }
            for(CfgCmtInstEntity firstItem : firstResult){
                Map<String,String> itemMap = new HashMap<>();
                String itemId = String.valueOf(firstItem.getItemId());
                String itemVal = firstItem.getItemValue();
                String cmtTarget = firstItem.getCmtTargetId();
                String creator = String.valueOf(firstItem.getCreator());
                String CreatorName = firstItem.getCreatorName();
                String createDate = DateUtils.formatDate(firstItem.getCreateDate(), "yyyy/MM/dd HH:mm");
                String ext2 = firstItem.getExt2();
                itemMap.put(itemId,itemVal);
                itemMap.put("cmtTargetId",cmtTarget);
                itemMap.put("creator",creator);
                itemMap.put("creatorName",CreatorName);
                itemMap.put("createDate", createDate);
                itemMap.put("id",firstItem.getCmtInstId()+"");
                if(itemIdArr.length>1){
                    for(int i=1; i<itemIdArr.length; i++){
                        //2、再查同一批记录的记录
                        CfgCmtInstEntity secondCmtInstEntity = new CfgCmtInstEntity();
                        secondCmtInstEntity.setCmtTargetId(cmtTargetId);
                        secondCmtInstEntity.setItemId(Long.parseLong(itemIdArr[i]));
                        secondCmtInstEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
                        secondCmtInstEntity.setOutNbrId(Long.parseLong(outNbrId));
                        secondCmtInstEntity.setExt2(ext2);
                        List<CfgCmtInstEntity> secondResult = dao.findByEntity(secondCmtInstEntity);
                        if(null == secondResult){
                            continue;
                        }
                        for(CfgCmtInstEntity secondItem : secondResult){
                            itemMap.put(String.valueOf(secondItem.getItemId()),secondItem.getItemValue());
                        }
                    }
                }
                resultQuery.add(itemMap);
            }
        }
        return resultQuery;
    }

    /**
     * 校验当前登录者是否打分评论了
     * @param requestMap
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkOperatorHasCmt(Map<String, Object> requestMap) throws Exception {
        String itemId = String.valueOf(requestMap.get("itemId"));
        String cmtTargetId = String.valueOf(requestMap.get("cmtTargetId"));
        String outNbrId = requestMap.containsKey("out_nbr_id")?String.valueOf(requestMap.get("out_nbr_id")):"-1";
        if(StringUtils.isBlank(itemId)){
            return false;
        }
        UserInfoInterface userInfoInterface = (UserInfoInterface) requestMap.get("_loginInfo_user");
        if(StringUtils.isBlank(cmtTargetId)||
                StringUtils.equals("null",cmtTargetId) ||
                StringUtils.equals("undefined",cmtTargetId)){
            return false;
        }
        CfgCmtInstEntity firstCmtInstEntity = new CfgCmtInstEntity();
        firstCmtInstEntity.setCmtTargetId(cmtTargetId);
        firstCmtInstEntity.setItemId(Long.parseLong(itemId));
        firstCmtInstEntity.setCmtState(CommentConstants.State.STATE_NORMAL);
        firstCmtInstEntity.setOutNbrId(Long.parseLong(outNbrId));
        firstCmtInstEntity.setCreator(userInfoInterface.getUserId());
        List<CfgCmtInstEntity> firstResult = dao.findByEntity(firstCmtInstEntity);
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
     * 统计评论的个数
     *
     * @param requestMap
     * @return [key:itemId value:count]
     */
    @Override
    public Map<String, Integer> getCmtItemCount(Map<String, Object> requestMap) throws Exception {
        Map<String,Integer> resultMap = new HashMap<>();
        String cmtTargetId = requestMap.containsKey("cmtTargetId")?String.valueOf(requestMap.get("cmtTargetId")):"";
        String outNbrId = requestMap.containsKey("outNbrId")?String.valueOf(requestMap.get("outNbrId")):"";
        String itemId = requestMap.containsKey("itemId")?String.valueOf(requestMap.get("itemId")):"";
        if(StringUtils.isBlank(cmtTargetId) ||
                StringUtils.isBlank(outNbrId)){
            return null;
        }
        CfgCmtInstEntity cfgCmtInstEntity = new CfgCmtInstEntity();
        cfgCmtInstEntity.setCmtTargetId(cmtTargetId);
        cfgCmtInstEntity.setOutNbrId(Long.parseLong(outNbrId));
        if(StringUtils.isNoneBlank(itemId)){
            cfgCmtInstEntity.setItemId(Long.parseLong(itemId));
        }
        List<Map> result = dao.getCmtItemCount(cfgCmtInstEntity);
        for(int i=0; null != result && i<result.size(); i++ ){
            Map temp = result.get(i);
            String count = String.valueOf(temp.get("count"));
            String tmpItemId = String.valueOf(temp.get("itemId"));
            resultMap.put(tmpItemId,Integer.parseInt(count));
        }
        return resultMap;
    }
}