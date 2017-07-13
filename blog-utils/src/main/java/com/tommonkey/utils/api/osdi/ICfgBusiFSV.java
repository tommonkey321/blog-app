/**
 * $Id: ICfgBusiFSV.java,v 1.0 2017/1/16 9:51 lijie Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.api.osdi;

import java.util.List;

/**
 * @author lijie
 * @version $Id: ICfgBusiFSV.java,v 1.1 2017/1/16 9:51 lijie Exp $
 * Created on 2017/1/16 9:51
 */
public interface ICfgBusiFSV {
    public com.tommonkey.utils.http.entity.CfgBusiBase getBusi(String busiId);

    public List<com.tommonkey.utils.http.entity.CfgBusiBase> getAllBusi();
}

