package com.tommonkey.common.osdi.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.osdi.entity.CfgEventRelEntity;

@Dao(CfgEventRelEntity.class)
public interface ICfgEventRelDao extends CrudDao<CfgEventRelEntity,Long> {
}