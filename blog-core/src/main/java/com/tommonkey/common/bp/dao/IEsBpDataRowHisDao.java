package com.tommonkey.common.bp.dao;

import com.tommonkey.common.bp.entity.EsBpDataRowHisEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

@Dao(EsBpDataRowHisEntity.class)
public interface IEsBpDataRowHisDao extends CrudDao<EsBpDataRowHisEntity, Long> {
}