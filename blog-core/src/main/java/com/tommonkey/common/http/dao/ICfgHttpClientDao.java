package com.tommonkey.common.http.dao;

import com.tommonkey.common.http.entity.CfgHttpClientEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * Created by LIUQ on 2015/7/21.
 */
@Dao(CfgHttpClientEntity.class)
public interface ICfgHttpClientDao extends CrudDao<CfgHttpClientEntity, String> {
}
