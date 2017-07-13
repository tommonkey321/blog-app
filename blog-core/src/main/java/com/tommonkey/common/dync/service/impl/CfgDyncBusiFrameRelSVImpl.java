package com.tommonkey.common.dync.service.impl;

import com.tommonkey.common.dync.dao.ICfgDyncBusiFrameRelDao;
import com.tommonkey.common.dync.service.interfaces.ICfgDyncBusiFrameRelSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CfgDyncBusiFrameRelSVImpl implements ICfgDyncBusiFrameRelSV {
	@Autowired
	private ICfgDyncBusiFrameRelDao dao;
}