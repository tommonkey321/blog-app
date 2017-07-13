/**
 * $Id: CfgChannelCache.java,v 1.0 2016/1/25 15:24 Qiaoy Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.osdi.cache;

import com.tommonkey.common.cache.DefaultCache;
import com.tommonkey.common.osdi.dao.ICfgChannelDao;
import com.tommonkey.common.osdi.entity.CfgChannelEntity;
import com.tommonkey.utils.common.SpringContextHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qiaoy
 * @version $Id: CfgChannelCache.java,v 1.1 2016/1/25 15:24 Qiaoy Exp $
 *          Created on 2016/1/25 15:24
 */
public class CfgChannelCache extends DefaultCache {

    @Override
    protected Map getData() throws Exception {
        HashMap<String, Object> retMap = new HashMap<String, Object>();
        ICfgChannelDao cfgChannelDao = SpringContextHolder.getBean(ICfgChannelDao.class);
        List<CfgChannelEntity> cfgChannelEntities = cfgChannelDao.findByEntity(new CfgChannelEntity());
        for (CfgChannelEntity cfgChannelEntity : cfgChannelEntities) {
            if (cfgChannelEntity.getBusiCode() != null) {
                retMap.put(cfgChannelEntity.getBusiCode() + "_" + cfgChannelEntity.getInterfaceId(), cfgChannelEntity);
            }
        }
        return retMap;
    }
}
