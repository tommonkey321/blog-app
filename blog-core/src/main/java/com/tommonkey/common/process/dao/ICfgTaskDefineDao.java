package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgTaskDefineEntity;

@Dao(CfgTaskDefineEntity.class)
public interface ICfgTaskDefineDao extends CrudDao<CfgTaskDefineEntity,Long>{
}