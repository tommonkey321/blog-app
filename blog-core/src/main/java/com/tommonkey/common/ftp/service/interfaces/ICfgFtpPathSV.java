package com.tommonkey.common.ftp.service.interfaces;

import com.tommonkey.common.ftp.entity.CfgFtpPathEntity;

import java.util.List;

/**
 * Created by lury on 2015/7/21.
 */
public interface ICfgFtpPathSV {
    public List<CfgFtpPathEntity> getAllCfgFtpPath() throws Exception;
}
