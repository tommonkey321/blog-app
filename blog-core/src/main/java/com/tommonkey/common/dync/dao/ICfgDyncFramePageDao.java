package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncFramePageEntity;

@Dao(CfgDyncFramePageEntity.class)
public interface ICfgDyncFramePageDao extends CrudDao<CfgDyncFramePageEntity,Long>{
}