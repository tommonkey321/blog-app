package com.tommonkey.common.bp.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.bp.entity.EsBpDataRowEntity;

@Dao(EsBpDataRowEntity.class)
public interface IEsBpDataRowDao extends CrudDao<EsBpDataRowEntity, Long> {
}