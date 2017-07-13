package com.tommonkey.common.cache.dao;

import com.tommonkey.common.cache.entity.CfgCacheLoadLogEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * Created by dizl on 2015/6/5.
 */
@Dao(CfgCacheLoadLogEntity.class)
public interface ICfgCacheLoadLogDao extends CrudDao<CfgCacheLoadLogEntity, Long> {
}
