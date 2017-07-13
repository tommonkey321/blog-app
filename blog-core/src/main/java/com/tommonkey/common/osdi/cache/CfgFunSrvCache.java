/**
 * $Id: CfgFunSrvCache.java,v 1.0 2015/11/6 16:26 09:55:18 zhangrp Exp $
 * <p/>
 * Copyright 2015 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.osdi.cache;

import com.tommonkey.common.cache.DefaultCache;
import com.tommonkey.common.osdi.dao.CfgFunSrvDao;
import com.tommonkey.common.osdi.entity.CfgFunSrv;
import com.tommonkey.utils.common.SpringContextHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangrp
 * @version $Id: CfgFunSrvCache.java,v 1.1 2015/11/6 16:26 zhangrp Exp $
 *          Created on 2015/11/6 16:26
 */
public class CfgFunSrvCache extends DefaultCache {

    private static String _CFG_FUN_SRV = "cfgFunSrv_";

    @Override
    protected Map getData() throws Exception {
        HashMap<String, List<Long>> retMap = new HashMap<String, List<Long>>();
        CfgFunSrvDao cfgFunSrvDao = SpringContextHolder.getBean(CfgFunSrvDao.class);
        List<CfgFunSrv> cfgFunSrvList = cfgFunSrvDao.findByEntity(new CfgFunSrv());
        for (CfgFunSrv cfgFunSrv : cfgFunSrvList) {
            if (cfgFunSrv.getSrvId() != null && cfgFunSrv.getFunId() != null) {
                if (retMap.get(_CFG_FUN_SRV + cfgFunSrv.getSrvId()) == null) {
                    retMap.put(_CFG_FUN_SRV + cfgFunSrv.getSrvId(), new ArrayList<Long>());
                }
                retMap.get(_CFG_FUN_SRV + cfgFunSrv.getSrvId()).add(cfgFunSrv.getFunId());
            }
        }
        return retMap;
    }
}
