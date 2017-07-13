package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncRuleExpEntity;

@Dao(CfgDyncRuleExpEntity.class)
public interface ICfgDyncRuleExpDao extends CrudDao<CfgDyncRuleExpEntity,Long> {
}