package com.tommonkey.common.mess.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.mess.entity.CfgMsgCollectDateEntity;

@Dao(CfgMsgCollectDateEntity.class)
public interface ICfgMsgCollectDateDao extends CrudDao<CfgMsgCollectDateEntity,Long> {
}