package com.tommonkey.common.staticdata.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.staticdata.entity.CfgStaticDataEntity;

/**
 * Created by dizl on 2015/6/12.
 */
@Dao(CfgStaticDataEntity.class)
public interface ICfgStaticDataDao extends CrudDao<CfgStaticDataEntity, String> {
}
