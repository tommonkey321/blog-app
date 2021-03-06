package com.tommonkey.common.dync.service.impl;

import com.tommonkey.common.dync.dao.ICfgDyncAttrDao;
import com.tommonkey.common.dync.service.interfaces.ICfgDyncAttrSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CfgDyncAttrSVImpl implements ICfgDyncAttrSV{
	@Autowired
	private ICfgDyncAttrDao dao;
}