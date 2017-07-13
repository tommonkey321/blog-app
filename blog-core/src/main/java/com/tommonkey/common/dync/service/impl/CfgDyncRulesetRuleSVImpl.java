package com.tommonkey.common.dync.service.impl;

import com.tommonkey.common.dync.dao.ICfgDyncRulesetRuleDao;
import com.tommonkey.common.dync.service.interfaces.ICfgDyncRulesetRuleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CfgDyncRulesetRuleSVImpl implements ICfgDyncRulesetRuleSV{
	@Autowired
	private ICfgDyncRulesetRuleDao dao;
}