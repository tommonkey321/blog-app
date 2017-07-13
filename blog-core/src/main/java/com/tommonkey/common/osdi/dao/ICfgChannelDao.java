package com.tommonkey.common.osdi.dao;

import com.tommonkey.common.osdi.entity.CfgChannelEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

@Dao(CfgChannelEntity.class)
public interface ICfgChannelDao extends CrudDao<CfgChannelEntity, Long> {
}