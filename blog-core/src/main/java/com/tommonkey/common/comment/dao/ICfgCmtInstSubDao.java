package com.tommonkey.common.comment.dao;

import com.tommonkey.common.comment.entity.CfgCmtInstSubEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

import java.util.List;
import java.util.Map;

@Dao(CfgCmtInstSubEntity.class)
public interface ICfgCmtInstSubDao extends CrudDao<CfgCmtInstSubEntity,Long> {

    List<Map> getSubCmtItemCount(CfgCmtInstSubEntity cfgCmtInstEntity)throws Exception;
}