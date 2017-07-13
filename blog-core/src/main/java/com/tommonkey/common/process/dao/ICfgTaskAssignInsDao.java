package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgTaskAssignInsEntity;

@Dao(CfgTaskAssignInsEntity.class)
public interface ICfgTaskAssignInsDao extends CrudDao<CfgTaskAssignInsEntity,Long>{
}