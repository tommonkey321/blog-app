package com.tommonkey.common.ws.service.impl;

import com.tommonkey.common.utils.CommConstants;
import com.tommonkey.common.ws.dao.IWsClientDAO;
import com.tommonkey.common.ws.entity.CfgWsClientEntity;
import com.tommonkey.common.ws.service.interfaces.IWsSV;
import com.tommonkey.utils.common.SpringContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LIUQ on 2015/7/17.
 */
@Service
public class WsSvImpl implements IWsSV {

    @Override
    public CfgWsClientEntity[] getAllCfgWsClient() throws Exception {
        IWsClientDAO wsClientDAO = (IWsClientDAO) SpringContextHolder.getBean(IWsClientDAO.class);
        CfgWsClientEntity cfgWsClientBean = new CfgWsClientEntity();
        cfgWsClientBean.setState(CommConstants.State.STATE_NORMAL);
        List<CfgWsClientEntity> cfgWsMethods = wsClientDAO.findByEntity(cfgWsClientBean);
        if (cfgWsMethods == null || cfgWsMethods.size() == 0)
            return new CfgWsClientEntity[0];
        return (CfgWsClientEntity[]) cfgWsMethods.toArray(new CfgWsClientEntity[0]);
    }
}
