package com.tommonkey.common.comment.dao;

import com.tommonkey.common.comment.entity.CfgCmtInstEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

import java.util.List;
import java.util.Map;

@Dao(CfgCmtInstEntity.class)
public interface ICfgCmtInstDao extends CrudDao<CfgCmtInstEntity,Long> {
    List<Map> getCmtItemCount(CfgCmtInstEntity cfgCmtInstEntity)throws Exception;
}