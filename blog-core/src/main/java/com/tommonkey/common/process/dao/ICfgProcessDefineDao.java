package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgProcessDefineEntity;

import java.util.List;
import java.util.Map;

@Dao(CfgProcessDefineEntity.class)
public interface ICfgProcessDefineDao extends CrudDao<CfgProcessDefineEntity,Long>{
    public List<CfgProcessDefineEntity> queryProcessInfo(Map params) throws Exception;
    public List<CfgProcessDefineEntity> queryValidProcessInfo(Map params) throws Exception;
}