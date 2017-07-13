package com.tommonkey.common.elec.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.elec.entity.CfgElecEntity;

@Dao(CfgElecEntity.class)
public interface ICfgElecDao extends CrudDao<CfgElecEntity, Long> {
}