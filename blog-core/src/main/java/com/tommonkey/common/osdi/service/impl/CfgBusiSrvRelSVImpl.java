package com.tommonkey.common.osdi.service.impl;

import com.tommonkey.common.osdi.dao.ICfgBusiSrvRelDao;
import com.tommonkey.common.osdi.service.interfaces.ICfgBusiSrvRelSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CfgBusiSrvRelSVImpl implements ICfgBusiSrvRelSV {
	@Autowired
	private ICfgBusiSrvRelDao dao;

}