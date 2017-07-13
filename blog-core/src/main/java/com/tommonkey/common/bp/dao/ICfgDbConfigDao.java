package com.tommonkey.common.bp.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.bp.entity.CfgDbConfigEntity;

@Dao(CfgDbConfigEntity.class)
public interface ICfgDbConfigDao extends CrudDao<CfgDbConfigEntity, Long> {
}