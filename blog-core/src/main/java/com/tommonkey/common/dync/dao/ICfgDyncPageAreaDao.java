package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncPageAreaEntity;
import org.apache.ibatis.annotations.Param;

@Dao(CfgDyncPageAreaEntity.class)
public interface ICfgDyncPageAreaDao extends CrudDao<CfgDyncPageAreaEntity, Long> {
    public int deleteByPageId(@Param("pageId") Long pageId);
}