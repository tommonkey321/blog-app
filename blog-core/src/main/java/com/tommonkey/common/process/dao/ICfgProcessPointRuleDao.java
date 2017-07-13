package com.tommonkey.common.process.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.process.entity.CfgProcessPointRuleEntity;

@Dao(CfgProcessPointRuleEntity.class)
public interface ICfgProcessPointRuleDao extends CrudDao<CfgProcessPointRuleEntity,Long>{
}