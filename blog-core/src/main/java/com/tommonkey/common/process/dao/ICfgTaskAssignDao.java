package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgTaskAssignEntity;

@Dao(CfgTaskAssignEntity.class)
public interface ICfgTaskAssignDao extends CrudDao<CfgTaskAssignEntity,Long> {
}