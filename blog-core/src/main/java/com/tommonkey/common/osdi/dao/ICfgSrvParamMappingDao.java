package com.tommonkey.common.osdi.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.osdi.entity.CfgSrvParamMappingEntity;

@Dao(CfgSrvParamMappingEntity.class)
public interface ICfgSrvParamMappingDao extends CrudDao<CfgSrvParamMappingEntity,Long> {
}