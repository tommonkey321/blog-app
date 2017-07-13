package com.tommonkey.common.mess.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.mess.entity.CfgMsgInfoInstHisEntity;

@Dao(CfgMsgInfoInstHisEntity.class)
public interface ICfgMsgInfoInstHisDao extends CrudDao<CfgMsgInfoInstHisEntity,Long> {
}