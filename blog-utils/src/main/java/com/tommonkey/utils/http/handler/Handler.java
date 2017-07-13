/**
 * $Id: Handler.java,v 1.0 2016/8/25 16:27 zhangrp Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.http.handler;

import com.tommonkey.utils.http.client.request.HttpRequest;
import com.tommonkey.utils.http.client.response.HttpResponse;
import com.tommonkey.utils.http.entity.CfgHttpClient;
import com.tommonkey.utils.http.entity.CfgWsClient;
import com.tommonkey.utils.response.Response;

import java.util.Map;

/**
 * @author zhangrp
 * @version $Id: Handler.java,v 1.1 2016/8/25 16:27 zhangrp Exp $
 *          Created on 2016/8/25 16:27
 */
public interface Handler {

    /**
     * 调用HTTP接口前，需要执行该方法
     * */
    public HttpRequest before(CfgHttpClient cfgHttpClientEntity, Map<String, Object> busiParam) throws Exception;

    /***
     * 调用HTTP接口后，需要执行该方法
     * */
    public Response after(HttpResponse httpResponse) throws Exception;

    /**
     * 调用WS接口前，需要执行该方法
     * */
    public HttpRequest before(CfgWsClient cfgWsClient, Map<String, Object> busiParam) throws Exception;

    /**
     * 调用WS接口后，需要执行该方法
     * */
    public Response after(Object obj) throws Exception;
}
