/**
 * $Id: IHttpServerFSV.java,v 1.0 2016/8/26 10:02 zhangrp Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.api.osdi;

import com.tommonkey.utils.response.Response;

import java.util.LinkedHashMap;

/**
 * @author zhangrp
 * @version $Id: IHttpServerFSV.java,v 1.1 2016/8/26 10:02 zhangrp Exp $
 *          Created on 2016/8/26 10:02
 */
public interface IHttpServerFSV {

    public Response callServer(String busiCode, LinkedHashMap<String, Object> busiParam) throws Exception;
}
