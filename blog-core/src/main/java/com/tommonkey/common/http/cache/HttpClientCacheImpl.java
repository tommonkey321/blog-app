package com.tommonkey.common.http.cache;

import com.tommonkey.common.cache.DefaultCache;
import com.tommonkey.common.http.entity.CfgHttpClientEntity;
import com.tommonkey.common.http.service.interfaces.IHttpSV;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.common.SpringContextHolder;
import com.tommonkey.utils.common.StringUtils;
import com.tommonkey.utils.http.entity.CfgHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LIUQ on 2015/7/21.
 */
public class HttpClientCacheImpl extends DefaultCache {

    @Override
    protected Map getData() throws Exception {
        Map<String, CfgHttpClient> map = new HashMap<String, CfgHttpClient>();
        IHttpSV iHttpSV = SpringContextHolder.getBean(IHttpSV.class);
        CfgHttpClientEntity[] cfgHttpClients = iHttpSV.getAllCfgHttpClient();
        if (cfgHttpClients != null && cfgHttpClients.length > 0) {
            for (int i = 0; i < cfgHttpClients.length; i++) {
                String busiCode = cfgHttpClients[i].getBusiCode();
                if (StringUtils.isNotBlank(busiCode)) {
                    CfgHttpClient cfgHttpClientEntity = JsonUtil.json2Object(JsonUtil.beanToJsonString(cfgHttpClients[i]), CfgHttpClient.class);
                    map.put(busiCode, cfgHttpClientEntity);
                }
            }
        }
        return map;
    }

}
