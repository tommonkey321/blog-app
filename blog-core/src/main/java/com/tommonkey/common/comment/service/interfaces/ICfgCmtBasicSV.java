package com.tommonkey.common.comment.service.interfaces;


import com.tommonkey.common.comment.entity.CfgCmtBasicTreeEntity;

import java.util.List;

public interface ICfgCmtBasicSV{
    /**
     * 业务场景匹配评论类型
     * @param cmtTargetId 业务场景编号
     * @param moduleId 数据来源 1 PC 2 APP
     * @return List<CfgCmtBasicEntity>
     * @throws Exception
     * @author RaoXb
     * @date 2016/09/08
     */
    public List<CfgCmtBasicTreeEntity> getCfgCmtBasicInfo(String cmtTargetId, int moduleId)throws Exception;
}