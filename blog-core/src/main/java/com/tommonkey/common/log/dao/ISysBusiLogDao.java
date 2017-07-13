package com.tommonkey.common.log.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.log.entity.SysBusiLogEntity;

@Dao(SysBusiLogEntity.class)
public interface ISysBusiLogDao extends CrudDao<SysBusiLogEntity, Long> {
}