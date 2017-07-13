package com.tommonkey.common.log.service.interfaces;

import com.tommonkey.common.log.entity.SysBusiLogEntity;

import java.util.List;

/**
 * Created by xt on 2016/2/22.
 */
public interface ISysBusiLogSV {

    public void saveLogs(List<SysBusiLogEntity> entityList) throws Exception;
}
