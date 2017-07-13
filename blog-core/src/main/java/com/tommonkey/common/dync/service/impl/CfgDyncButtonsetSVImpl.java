package com.tommonkey.common.dync.service.impl;

import com.tommonkey.common.dync.dao.ICfgDyncButtonsetDao;
import com.tommonkey.common.dync.service.interfaces.ICfgDyncButtonsetSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CfgDyncButtonsetSVImpl implements ICfgDyncButtonsetSV {
	@Autowired
	private ICfgDyncButtonsetDao dao;
}