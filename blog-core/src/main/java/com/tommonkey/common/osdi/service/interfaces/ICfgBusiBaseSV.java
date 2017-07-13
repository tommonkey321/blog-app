package com.tommonkey.common.osdi.service.interfaces;

import com.tommonkey.utils.http.entity.CfgBusiBase;

public interface ICfgBusiBaseSV{
    CfgBusiBase getBusiBase(String busiId) throws Exception;
}