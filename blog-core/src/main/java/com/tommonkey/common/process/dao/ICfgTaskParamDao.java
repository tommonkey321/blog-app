package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgTaskParamEntity;

@Dao(CfgTaskParamEntity.class)
public interface ICfgTaskParamDao extends CrudDao<CfgTaskParamEntity,Long>{
}