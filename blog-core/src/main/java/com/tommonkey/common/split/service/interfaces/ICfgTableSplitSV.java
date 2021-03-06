package com.tommonkey.common.split.service.interfaces;

import com.tommonkey.common.split.entity.CfgTableSplitEntity;

import java.util.List;

/**
 * Created by dizl on 2015/6/2.
 */
public interface ICfgTableSplitSV {
    public CfgTableSplitEntity getCfgTableSplitByTableName(String tableName) throws Exception;

    public List<CfgTableSplitEntity> getAllCfgTableSplits() throws Exception;
}
