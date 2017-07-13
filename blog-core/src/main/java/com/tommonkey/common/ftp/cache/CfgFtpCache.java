package com.tommonkey.common.ftp.cache;

import com.tommonkey.common.cache.DefaultCache;
import com.tommonkey.common.ftp.entity.CfgFtpEntity;
import com.tommonkey.common.ftp.service.interfaces.ICfgFtpSV;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.common.SpringContextHolder;
import com.tommonkey.utils.ftp.entity.CfgFtp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lury on 2015/7/21.
 */
public class CfgFtpCache extends DefaultCache {

    public HashMap getData() throws Exception {
        HashMap<String, CfgFtp> retMap = new HashMap<String, CfgFtp>();
        ICfgFtpSV cfgFtpSV = SpringContextHolder.getBean(ICfgFtpSV.class);
        List<CfgFtpEntity> list = cfgFtpSV.getAllCfgFtp();
        if (list != null && list.size() > 0) {
            for (CfgFtpEntity cfgFtpEntity : list) {
                CfgFtp cfgFtp = JsonUtil.json2Object(JsonUtil.object2Json(cfgFtpEntity), CfgFtp.class);
                retMap.put(cfgFtp.getFtpCode(), cfgFtp);
            }
        }
        return retMap;
    }
}
