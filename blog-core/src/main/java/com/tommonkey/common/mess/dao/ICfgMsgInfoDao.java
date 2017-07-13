package com.tommonkey.common.mess.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.mess.entity.CfgMsgInfoEntity;

@Dao(CfgMsgInfoEntity.class)
public interface ICfgMsgInfoDao extends CrudDao<CfgMsgInfoEntity,Long>{
}