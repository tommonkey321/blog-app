package com.tommonkey.common.dync.service.impl;

import com.tommonkey.common.dync.dao.ICfgDyncButtonDao;
import com.tommonkey.common.dync.service.interfaces.ICfgDyncButtonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CfgDyncButtonSVImpl implements ICfgDyncButtonSV{
	@Autowired
	private ICfgDyncButtonDao dao;
}