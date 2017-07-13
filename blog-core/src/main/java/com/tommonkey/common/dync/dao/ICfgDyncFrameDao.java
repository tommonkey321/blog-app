package com.tommonkey.common.dync.dao;

import com.tommonkey.common.dync.entity.CfgDyncFrameEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Dao(CfgDyncFrameEntity.class)
public interface ICfgDyncFrameDao extends CrudDao<CfgDyncFrameEntity, Long> {
    public int startBusi(@Param("entity") CfgDyncFrameEntity cfgDyncFrameEntity);

    public List<Map<String, Object>> queryPageFrameRelation(@Param("param") Map<String, Object> param);

    public List<CfgDyncFrameEntity> queryCfgDyncFrame(@Param("entity") CfgDyncFrameEntity cfgDyncFrameEntity);
}