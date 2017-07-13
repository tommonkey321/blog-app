package com.tommonkey.common.dync.service.impl;

import com.tommonkey.common.dync.dao.ICfgDyncPageDao;
import com.tommonkey.common.dync.service.interfaces.ICfgDyncPageSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CfgDyncPageSVImpl implements ICfgDyncPageSV {
	@Autowired
	private ICfgDyncPageDao dao;
}