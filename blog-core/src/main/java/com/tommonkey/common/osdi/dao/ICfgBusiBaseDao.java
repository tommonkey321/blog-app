package com.tommonkey.common.osdi.dao;

import com.tommonkey.common.osdi.entity.CfgBusiBaseEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.utils.http.entity.CfgBusiBase;
import com.tommonkey.utils.http.entity.CfgBusiEventRel;
import com.tommonkey.utils.http.entity.CfgBusiSrvRel;
import com.tommonkey.utils.http.entity.CfgSrvParamMapping;

import java.util.List;
import java.util.Map;

@Dao(CfgBusiBaseEntity.class)
public interface ICfgBusiBaseDao extends CrudDao<CfgBusiBaseEntity,Long>{
    List<CfgBusiBase> getBusiBaseEntity(Map param);
    List<CfgBusiSrvRel> getSrvListByBusiId(Map param);
    List<CfgBusiEventRel> getEventListByBusiId(Map param);
    List<CfgSrvParamMapping> getSrvParamMappingByBusiId(Map param);
}