package com.tommonkey.blog.sec.service.impl;

import com.tommonkey.blog.sec.dao.ISecUserDao;
import com.tommonkey.blog.sec.entity.SecUserEntity;
import com.tommonkey.blog.sec.service.interfaces.ISecUserSV;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.persistence.service.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecUserSVImpl extends CrudServiceImpl implements ISecUserSV{
	@Autowired
	private ISecUserDao dao;

	public CrudDao getDao() {
		return dao;
	}

	@Override
	public List<SecUserEntity> getAllSecUser() throws Exception {
		return dao.getAllSecUser();
	}
}