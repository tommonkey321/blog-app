/*
 * $Id: Request.java,v 1.0 2015年7月23日 下午4:57:30 zhangrp Exp $
 *
 * Copyright 2015 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.request;


import com.tommonkey.utils.common.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author zhangrp
 * @version $Id: Request.java v 1.0 Exp $
 *          Created on 2015年7月23日 下午4:57:30
 */
public class Request implements Serializable {

    protected static final Logger logger = LoggerFactory.getLogger(Request.class);

    private PubInfo pubInfo;
    private com.tommonkey.utils.request.RequestInfo requestInfo;

    public Request() {
    }

    public Request(PubInfo pubInfo, com.tommonkey.utils.request.RequestInfo requestInfo) {
        this.pubInfo = pubInfo;
        this.requestInfo = requestInfo;
    }

    public static Request getRequest(String json) throws Exception {

        return JsonUtil.json2Object(json, Request.class);
    }

    public String toString() {
        try {
            return JsonUtil.object2Json(this);
        } catch (IOException e) {
            logger.error("", e);
        }
        return "";
    }

    public com.tommonkey.utils.request.RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(com.tommonkey.utils.request.RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public PubInfo getPubInfo() {
        return pubInfo;
    }

    public void setPubInfo(PubInfo pubInfo) {
        this.pubInfo = pubInfo;
    }

    public static void main(String args[]) {
        Request request = new Request();
        request.setPubInfo(new PubInfo());
        request.setRequestInfo(new com.tommonkey.utils.request.RequestInfo());
        System.out.println(request.toString());
    }
}
