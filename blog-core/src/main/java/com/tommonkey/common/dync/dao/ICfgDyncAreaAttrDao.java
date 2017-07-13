package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncAreaAttrEntity;
import org.apache.ibatis.annotations.Param;

@Dao(CfgDyncAreaAttrEntity.class)
public interface ICfgDyncAreaAttrDao extends CrudDao<CfgDyncAreaAttrEntity, Long> {
    public int deleteByPageId(@Param("pageId") Long pageId);
}