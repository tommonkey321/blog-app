package com.tommonkey.common.bp.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.bp.entity.EsBpDataColEntity;

@Dao(EsBpDataColEntity.class)
public interface IEsBpDataColDao extends CrudDao<EsBpDataColEntity, Long> {
}