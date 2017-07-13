package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgProcessParamEntity;

@Dao(CfgProcessParamEntity.class)
public interface ICfgProcessParamDao extends CrudDao<CfgProcessParamEntity,Long>{
}