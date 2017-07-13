/**
 * $Id: ParamMappingEvent.java,v 1.0 2017/1/19 13:53 lijie Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.http.event;

import com.tommonkey.utils.http.entity.CfgBusiBase;
import com.tommonkey.utils.http.entity.CfgSrvParamMapping;
import com.tommonkey.utils.http.entity.SerParameter;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author lijie
 * @version $Id: ParamMappingEvent.java,v 1.1 2017/1/19 13:53 lijie Exp $
 * Created on 2017/1/19 13:53
 */
public class ParamMappingEvent implements com.tommonkey.utils.api.osdi.IEvent {

    @Override
    public void init() throws Exception {

    }

    @Override
    public SerParameter doEvent(SerParameter serParameter, CfgBusiBase cfgBusiBase) {
        LinkedHashMap busiParams = serParameter.getRequest().getRequestInfo().getBusiParams();
        String key = serParameter.getBusiCode();
        List<CfgSrvParamMapping> paramMappings = cfgBusiBase.getParamMap().get(key);
        if (paramMappings != null && paramMappings.size() > 0) {
            for (CfgSrvParamMapping paramMapping : paramMappings) {
                if (paramMapping.getTransitivity() == 0) {
                    String paramCode = paramMapping.getParamCode();
                    if (busiParams.containsKey(paramCode)) {
                        busiParams.put(paramMapping.getSrvParamCode(), busiParams.get(paramCode));
                    }
                }
            }
        }
        return serParameter;
    }
}
