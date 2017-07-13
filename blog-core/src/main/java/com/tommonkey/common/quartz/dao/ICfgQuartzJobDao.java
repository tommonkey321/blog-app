package com.tommonkey.common.quartz.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.quartz.entity.CfgQuartzJobEntity;

@Dao(CfgQuartzJobEntity.class)
public interface ICfgQuartzJobDao extends CrudDao<CfgQuartzJobEntity, Long> {
}