package com.tommonkey.common.http.dao;

import com.tommonkey.common.http.entity.CfgHttpMappingEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * Created by LIUQ on 2015/7/21.
 */
@Dao(CfgHttpMappingEntity.class)
public interface ICfgHttpMappingDao extends CrudDao<CfgHttpMappingEntity, String> {
}
