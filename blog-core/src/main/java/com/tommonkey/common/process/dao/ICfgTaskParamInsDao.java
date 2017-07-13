package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgTaskParamInsEntity;

@Dao(CfgTaskParamInsEntity.class)
public interface ICfgTaskParamInsDao extends CrudDao<CfgTaskParamInsEntity,Long>{
}