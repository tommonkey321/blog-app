package com.tommonkey.common.comment.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.comment.entity.CfgCmtBasicEntity;

@Dao(CfgCmtBasicEntity.class)
public interface ICfgCmtBasicDao extends CrudDao<CfgCmtBasicEntity,Long>{
}