package com.tommonkey.common.mess.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.mess.entity.CfgMsgInfoInstEntity;

import java.util.List;
import java.util.Map;

@Dao(CfgMsgInfoInstEntity.class)
public interface ICfgMsgInfoInstDao extends CrudDao<CfgMsgInfoInstEntity,Long> {
    public List<CfgMsgInfoInstEntity> getSendMsg() throws Exception;
    public List<CfgMsgInfoInstEntity> getWebInfoList(Map params) throws Exception;
    public Integer getWebInfoCount(Map params) throws Exception;
    public List<CfgMsgInfoInstEntity> getAppInfoList(Map params) throws Exception;
    public Integer getAppInfoCount(Map params) throws Exception;
}