package com.tommonkey.common.bp.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.bp.entity.EsBpDataEntity;
import com.tommonkey.common.persistence.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Dao(EsBpDataEntity.class)
public interface IEsBpDataDao extends CrudDao<EsBpDataEntity, Long> {
    public List<Map<String, Object>> queryEsBpData(@Param("param") Map<String, Object> param, @Param("page") Page page);
}

