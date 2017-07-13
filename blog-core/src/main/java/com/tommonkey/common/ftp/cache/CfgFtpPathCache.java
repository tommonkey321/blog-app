package com.tommonkey.common.ftp.cache;

import com.tommonkey.common.cache.DefaultCache;
import com.tommonkey.common.ftp.entity.CfgFtpPathEntity;
import com.tommonkey.common.ftp.service.interfaces.ICfgFtpPathSV;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.common.SpringContextHolder;
import com.tommonkey.utils.ftp.entity.CfgFtpPath;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lury on 2015/7/21.
 */
public class CfgFtpPathCache extends DefaultCache {
    public HashMap getData() throws Exception {
        HashMap<String, CfgFtpPath> retMap = new HashMap<String, CfgFtpPath>();
        ICfgFtpPathSV cfgFtpPathSV = SpringContextHolder.getBean(ICfgFtpPathSV.class);
        List<CfgFtpPathEntity> list = cfgFtpPathSV.getAllCfgFtpPath();
        if (list != null && list.size() > 0) {
            for (CfgFtpPathEntity cfgFtpPathEntity : list) {
                CfgFtpPath cfgFtpPath = JsonUtil.json2Object(JsonUtil.object2Json(cfgFtpPathEntity), CfgFtpPath.class);
                retMap.put(cfgFtpPath.getFtpPathCode(), cfgFtpPath);
            }
        }
        return retMap;
    }
}
