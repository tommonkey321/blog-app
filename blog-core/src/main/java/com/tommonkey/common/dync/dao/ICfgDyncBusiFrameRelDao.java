package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncBusiFrameRelEntity;
import com.tommonkey.common.persistence.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Dao(CfgDyncBusiFrameRelEntity.class)
public interface ICfgDyncBusiFrameRelDao extends CrudDao<CfgDyncBusiFrameRelEntity,Long> {
    public List<Map<String, Object>> queryCfgDyncBusiData(@Param("param") Map<String, Object> param, @Param("page") Page page);

}