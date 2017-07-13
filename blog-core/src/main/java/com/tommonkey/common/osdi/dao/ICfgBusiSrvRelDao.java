package com.tommonkey.common.osdi.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.osdi.entity.CfgBusiSrvRelEntity;

@Dao(CfgBusiSrvRelEntity.class)
public interface ICfgBusiSrvRelDao extends CrudDao<CfgBusiSrvRelEntity,Long> {
}