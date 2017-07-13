package com.tommonkey.common.ftp.service.impl;

import com.tommonkey.common.ftp.dao.ICfgFtpDao;
import com.tommonkey.common.ftp.entity.CfgFtpEntity;
import com.tommonkey.common.ftp.service.interfaces.ICfgFtpSV;
import com.tommonkey.common.utils.CommConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lury on 2015/7/21.
 */
@Service
public class CfgFtpSVImpl implements ICfgFtpSV {
    @Autowired
    private ICfgFtpDao cfgFtpDao;

    public List<CfgFtpEntity> getAllCfgFtp() throws Exception {
        CfgFtpEntity entity = new CfgFtpEntity();
        entity.setState(CommConstants.State.STATE_NORMAL);
        return cfgFtpDao.findByEntity(entity);
    }
}
