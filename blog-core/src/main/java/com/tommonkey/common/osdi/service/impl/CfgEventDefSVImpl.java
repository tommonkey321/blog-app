package com.tommonkey.common.osdi.service.impl;

import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.osdi.dao.ICfgEventDefDao;
import com.tommonkey.common.osdi.service.interfaces.ICfgEventDefSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CfgEventDefSVImpl implements ICfgEventDefSV {
	@Autowired
	private ICfgEventDefDao dao;

	public CrudDao getDao() {
		return dao;
	}
}