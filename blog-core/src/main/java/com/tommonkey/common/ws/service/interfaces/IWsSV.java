package com.tommonkey.common.ws.service.interfaces;


import com.tommonkey.common.ws.entity.CfgWsClientEntity;

/**
 * Created by LIUQ on 2015/7/17.
 */
public interface IWsSV {

    public CfgWsClientEntity[] getAllCfgWsClient() throws Exception;
}
