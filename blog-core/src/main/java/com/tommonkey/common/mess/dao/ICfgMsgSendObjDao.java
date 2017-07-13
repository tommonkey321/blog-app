package com.tommonkey.common.mess.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.mess.entity.CfgMsgSendObjEntity;

@Dao(CfgMsgSendObjEntity.class)
public interface ICfgMsgSendObjDao extends CrudDao<CfgMsgSendObjEntity,Long>{
}