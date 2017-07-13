package com.tommonkey.common.process.service.impl;

import com.tommonkey.common.process.dao.ICfgProcessParamDao;
import com.tommonkey.common.process.entity.CfgProcessParamEntity;
import com.tommonkey.common.process.service.interfaces.ICfgProcessParamSV;
import com.tommonkey.common.utils.CommConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CfgProcessParamSVImpl implements ICfgProcessParamSV {
	@Autowired
	private ICfgProcessParamDao dao;

	@Override
	public List<CfgProcessParamEntity> getParamEntityByProcessId(long processId) throws Exception {
		CfgProcessParamEntity entity = new CfgProcessParamEntity();
		entity.setProcessId(processId);
		entity.setState(CommConstants.State.STATE_NORMAL);
		return dao.findByEntity(entity);
	}

	/**
	 * 保存流程参数
	 *
	 * @param paramEntityList
	 */
	@Override
	public void saveEntity(List<CfgProcessParamEntity> paramEntityList) throws Exception {
		dao.save(paramEntityList);
	}

	/**
	 * 根据流程编号删除数据
	 *
	 * @param processId
	 */
	@Override
	public void deleteByProcessId(long processId) throws Exception {
		CfgProcessParamEntity entity = new CfgProcessParamEntity();
		entity.setProcessId(processId);
		dao.deleteByEntity(entity);
	}
}