package com.tommonkey.common.cache.service.interfaces;

import com.tommonkey.common.cache.entity.CfgCacheLoadLogEntity;

/**
 * Created by dizl on 2015/6/5.
 */
public interface ICfgCacheLoadLogSV {
    public void saveEntity(CfgCacheLoadLogEntity entity) throws Exception;
}
