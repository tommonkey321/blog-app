package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncButtonsetButtonEntity;

@Dao(CfgDyncButtonsetButtonEntity.class)
public interface ICfgDyncButtonsetButtonDao extends CrudDao<CfgDyncButtonsetButtonEntity,Long> {
}