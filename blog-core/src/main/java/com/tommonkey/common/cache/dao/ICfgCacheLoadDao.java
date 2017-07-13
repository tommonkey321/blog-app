package com.tommonkey.common.cache.dao;

import com.tommonkey.common.cache.entity.CfgCacheLoadEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * Created by dizl on 2015/6/5.
 */
@Dao(CfgCacheLoadEntity.class)
public interface ICfgCacheLoadDao extends CrudDao<CfgCacheLoadEntity, String> {
}
