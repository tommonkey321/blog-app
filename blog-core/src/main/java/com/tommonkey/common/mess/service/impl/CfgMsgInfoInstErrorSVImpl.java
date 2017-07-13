package com.tommonkey.common.mess.service.impl;

import com.tommonkey.common.mess.dao.ICfgMsgInfoInstErrorDao;
import com.tommonkey.common.mess.entity.CfgMsgInfoInstErrorEntity;
import com.tommonkey.common.mess.service.interfaces.ICfgMsgInfoInstErrorSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CfgMsgInfoInstErrorSVImpl implements ICfgMsgInfoInstErrorSV{
	@Autowired
	private ICfgMsgInfoInstErrorDao dao;

	/**
	 * 保存数据
	 * */
	public void saveEntity(List<CfgMsgInfoInstErrorEntity> msgInfoInstErrorEntityList) throws Exception{
		dao.save(msgInfoInstErrorEntityList);
	}
}