package com.tommonkey.common.mess.service.impl;

import com.tommonkey.common.mess.dao.ICfgMsgInfoDao;
import com.tommonkey.common.mess.entity.CfgMsgInfoEntity;
import com.tommonkey.common.mess.service.interfaces.ICfgMsgInfoSV;
import com.tommonkey.common.utils.CommConstants;
import com.tommonkey.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CfgMsgInfoSVImpl implements ICfgMsgInfoSV{
	@Autowired
	private ICfgMsgInfoDao dao;

	@Override
	public List<CfgMsgInfoEntity> getCfgMsgInfoBySendLevel(String sendLevel) throws Exception {
		CfgMsgInfoEntity entity = new CfgMsgInfoEntity();
		entity.setState(CommConstants.State.STATE_NORMAL);
		entity.setSendLevel(sendLevel);
		entity.setEffectiveDate(DateUtils.getCurrentDate());
		entity.setExpireDate(DateUtils.getCurrentDate());
		return dao.findLike(entity);
	}
}