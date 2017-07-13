package com.tommonkey.common.his.dao;

import com.tommonkey.common.his.entity.CfgHisTableConfigEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * Created by dizl on 2015/7/17.
 */
@Dao(CfgHisTableConfigEntity.class)
public interface ICfgHisTableConfigDao extends CrudDao<CfgHisTableConfigEntity, String> {
}
