package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgProcessParamInsEntity;

@Dao(CfgProcessParamInsEntity.class)
public interface ICfgProcessParamInsDao extends CrudDao<CfgProcessParamInsEntity,Long> {
}