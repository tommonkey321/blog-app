package com.tommonkey.common.osdi.service.impl;

import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.osdi.dao.ICfgSrvParamMappingDao;
import com.tommonkey.common.osdi.service.interfaces.ICfgSrvParamMappingSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CfgSrvParamMappingSVImpl implements ICfgSrvParamMappingSV {
	@Autowired
	private ICfgSrvParamMappingDao dao;

	public CrudDao getDao() {
		return dao;
	}
}