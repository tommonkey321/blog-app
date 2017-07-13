package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgProcessPointEntity;

@Dao(CfgProcessPointEntity.class)
public interface ICfgProcessPointDao extends CrudDao<CfgProcessPointEntity,Long>{
}