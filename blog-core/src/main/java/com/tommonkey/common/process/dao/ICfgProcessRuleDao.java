package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgProcessRuleEntity;

@Dao(CfgProcessRuleEntity.class)
public interface ICfgProcessRuleDao extends CrudDao<CfgProcessRuleEntity,Long> {
}