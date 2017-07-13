package com.tommonkey.common.ws.dao;


import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.ws.entity.CfgWsClientEntity;

/**
 * Created by LIUQ on 2015/7/17.
 */
@Dao(CfgWsClientEntity.class)
public interface IWsClientDAO extends CrudDao<CfgWsClientEntity, String> {
}
