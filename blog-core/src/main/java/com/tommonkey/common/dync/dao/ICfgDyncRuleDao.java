package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncRuleEntity;

import java.util.List;

@Dao(CfgDyncRuleEntity.class)
public interface ICfgDyncRuleDao extends CrudDao<CfgDyncRuleEntity,Long> {
    //查询规则集包含的规则
    public List<CfgDyncRuleEntity> getRuleByRulesetId(long rulesetId);
}