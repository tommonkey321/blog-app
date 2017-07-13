package com.tommonkey.common.osdi.service.impl;

import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.osdi.dao.ICfgEventRelDao;
import com.tommonkey.common.osdi.service.interfaces.ICfgEventRelSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CfgEventRelSVImpl implements ICfgEventRelSV{
	@Autowired
	private ICfgEventRelDao dao;

	public CrudDao getDao() {
		return dao;
	}
}