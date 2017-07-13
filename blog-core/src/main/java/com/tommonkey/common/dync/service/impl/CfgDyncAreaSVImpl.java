package com.tommonkey.common.dync.service.impl;

import com.tommonkey.common.dync.dao.ICfgDyncAreaDao;
import com.tommonkey.common.dync.service.interfaces.ICfgDyncAreaSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CfgDyncAreaSVImpl implements ICfgDyncAreaSV{
	@Autowired
	private ICfgDyncAreaDao dao;
}