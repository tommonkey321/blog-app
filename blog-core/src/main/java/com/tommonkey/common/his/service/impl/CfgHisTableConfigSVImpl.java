package com.tommonkey.common.his.service.impl;

import com.tommonkey.common.his.dao.ICfgHisTableConfigDao;
import com.tommonkey.common.his.entity.CfgHisTableConfigEntity;
import com.tommonkey.common.his.service.interfaces.ICfgHisTableConfigSV;
import com.tommonkey.common.utils.CommConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dizl on 2015/7/17.
 */
@Service
public class CfgHisTableConfigSVImpl implements ICfgHisTableConfigSV {
    @Autowired
    private ICfgHisTableConfigDao cfgHisTableConfigDao;

    public List<CfgHisTableConfigEntity> getAllEntity() throws Exception {
        CfgHisTableConfigEntity cfgHisTableConfigEntity = new CfgHisTableConfigEntity();
        cfgHisTableConfigEntity.setState(CommConstants.State.STATE_NORMAL);
        return cfgHisTableConfigDao.findByEntity(cfgHisTableConfigEntity);
    }

    public CfgHisTableConfigEntity getByTableName(String tableName) throws Exception {
        CfgHisTableConfigEntity cfgHisTableConfigEntity = new CfgHisTableConfigEntity();
        cfgHisTableConfigEntity.setState(CommConstants.State.STATE_NORMAL);
        cfgHisTableConfigEntity.setTableName(tableName);
        List<CfgHisTableConfigEntity> lists = cfgHisTableConfigDao.findByEntity(cfgHisTableConfigEntity);
        if (lists != null && lists.size() > 0) {
            return lists.get(0);
        }
        return null;
    }
}
