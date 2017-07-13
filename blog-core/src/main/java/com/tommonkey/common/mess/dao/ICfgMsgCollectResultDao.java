package com.tommonkey.common.mess.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.mess.entity.CfgMsgCollectResultEntity;

@Dao(CfgMsgCollectResultEntity.class)
public interface ICfgMsgCollectResultDao extends CrudDao<CfgMsgCollectResultEntity,Long>{
}