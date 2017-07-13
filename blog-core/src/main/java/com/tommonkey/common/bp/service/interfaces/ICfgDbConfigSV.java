package com.tommonkey.common.bp.service.interfaces;

import com.tommonkey.common.bp.entity.CfgDbConfigEntity;

import java.util.List;

public interface ICfgDbConfigSV {

    /**
     * 获取所有的配置
     *
     * @return
     * @throws Exception
     */
    public List<CfgDbConfigEntity> getAllCfgDbConfig() throws Exception;

    /**
     * 根据条件查询配置
     *
     * @param param
     * @return
     * @throws Exception
     */
    public List<CfgDbConfigEntity> getCfgDbConfigByCon(String param) throws Exception;
}