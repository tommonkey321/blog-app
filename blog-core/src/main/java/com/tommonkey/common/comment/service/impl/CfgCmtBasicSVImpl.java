package com.tommonkey.common.comment.service.impl;

import com.tommonkey.common.comment.dao.ICfgCmtBasicDao;
import com.tommonkey.common.comment.entity.CfgCmtBasicEntity;
import com.tommonkey.common.comment.entity.CfgCmtBasicTreeEntity;
import com.tommonkey.common.comment.service.interfaces.ICfgCmtBasicSV;
import com.tommonkey.utils.common.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CfgCmtBasicSVImpl implements ICfgCmtBasicSV {
	@Autowired
	private ICfgCmtBasicDao dao;

    /**
     * 业务场景匹配评论类型
     * @param cmtTargetId 业务场景编号
     * @param moduleId 数据来源 1 PC 2 APP
     * @return
     * @throws Exception
     * @author RaoXb
     * @date 2016/09/08
     */
    @Override
    public List<CfgCmtBasicTreeEntity> getCfgCmtBasicInfo(String cmtTargetId, int moduleId) throws Exception {
        CfgCmtBasicEntity cmtBasicEntity = new CfgCmtBasicEntity();
        //评论对象的编号
        cmtBasicEntity.setCmtTargetId(cmtTargetId);
        cmtBasicEntity.setModuleId(moduleId);
        //有效状态
        cmtBasicEntity.setState(1);
        //根显示顺序排序
        List<CfgCmtBasicEntity> cmtBasicInfo = dao.findByEntity(cmtBasicEntity, "showOrder");
        List<CfgCmtBasicTreeEntity> result = new ArrayList<>();
        if( null != cmtBasicInfo && cmtBasicInfo.size()>0 ){
            for(CfgCmtBasicEntity basicEntity: cmtBasicInfo){
                CfgCmtBasicTreeEntity basicTreeEntity = new CfgCmtBasicTreeEntity();
                BeanUtils.copyProperties(basicTreeEntity,basicEntity);
                if(basicEntity.getCmtAble() == 1 && !StringUtils.isBlank(basicEntity.getExt2())){
                    //可评论，并且评论的评论项不为空
                    String[] relatCmtIds = basicEntity.getExt2().split("_");
                    List<CfgCmtBasicEntity> children = new ArrayList<>();
                    for(int i = 0; null != relatCmtIds && i<relatCmtIds.length; i++){
                        CfgCmtBasicEntity child = dao.findById(Long.parseLong(relatCmtIds[i]));
                        if(null != child){
                            children.add(child);
                        }
                    }
                    basicTreeEntity.setChildren(children);
                }
                result.add(basicTreeEntity);
            }
            return result;
        }
        return null;
    }
}