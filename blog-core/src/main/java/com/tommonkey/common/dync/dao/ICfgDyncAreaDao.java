package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncAreaEntity;
import org.apache.ibatis.annotations.Param;

@Dao(CfgDyncAreaEntity.class)
public interface ICfgDyncAreaDao extends CrudDao<CfgDyncAreaEntity, Long> {
    public int deleteByPageId(@Param("pageId") Long pageId);
}