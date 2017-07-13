package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgTaskInsEntity;

import java.util.List;
import java.util.Map;

@Dao(CfgTaskInsEntity.class)
public interface ICfgTaskInsDao extends CrudDao<CfgTaskInsEntity,Long> {
    public List<CfgTaskInsEntity> getExpireTask(Map params) throws Exception;

    public List<Map> queryUserTask(Map params) throws Exception;
}