package com.tommonkey.common.osdi.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.osdi.entity.CfgEventDefEntity;

@Dao(CfgEventDefEntity.class)
public interface ICfgEventDefDao extends CrudDao<CfgEventDefEntity,Long> {
}