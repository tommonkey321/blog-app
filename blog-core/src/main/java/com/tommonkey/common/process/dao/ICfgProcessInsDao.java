package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgProcessInsEntity;

@Dao(CfgProcessInsEntity.class)
public interface ICfgProcessInsDao extends CrudDao<CfgProcessInsEntity,Long> {
}