package com.tommonkey.common.mess.service.impl;

import com.tommonkey.common.mess.dao.ICfgMsgSendObjDao;
import com.tommonkey.common.mess.entity.CfgMsgSendObjEntity;
import com.tommonkey.common.mess.service.interfaces.ICfgMsgSendObjSV;
import com.tommonkey.common.utils.CommConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CfgMsgSendObjSVImpl implements ICfgMsgSendObjSV {
	@Autowired
	private ICfgMsgSendObjDao dao;

	@Override
	public List<CfgMsgSendObjEntity> getSendObjEntityByBusiMsgId(Long busiMsgId) throws Exception {
		CfgMsgSendObjEntity entity = new CfgMsgSendObjEntity();
		entity.setBusiMsgId(busiMsgId);
		entity.setState(CommConstants.State.STATE_NORMAL);
		return dao.findByEntity(entity);
	}
}