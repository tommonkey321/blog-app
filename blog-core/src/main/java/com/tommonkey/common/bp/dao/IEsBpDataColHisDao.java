package com.tommonkey.common.bp.dao;

import com.tommonkey.common.bp.entity.EsBpDataColHisEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

@Dao(EsBpDataColHisEntity.class)
public interface IEsBpDataColHisDao extends CrudDao<EsBpDataColHisEntity, Long> {
}