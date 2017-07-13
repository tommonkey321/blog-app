package com.tommonkey.common.elec.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.elec.entity.ElecInstEntity;

@Dao(ElecInstEntity.class)
public interface IElecInstDao extends CrudDao<ElecInstEntity, Long> {
}