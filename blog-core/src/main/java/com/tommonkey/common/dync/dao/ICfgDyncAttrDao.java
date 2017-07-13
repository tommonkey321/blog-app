package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncAttrEntity;
import org.apache.ibatis.annotations.Param;

@Dao(CfgDyncAttrEntity.class)
public interface ICfgDyncAttrDao extends CrudDao<CfgDyncAttrEntity, Long> {
    public int deleteByPageId(@Param("pageId") Long pageId);
}