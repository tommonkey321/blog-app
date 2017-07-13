package com.tommonkey.common.dync.dao;

import com.tommonkey.common.dync.entity.CfgDyncButtonEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

import java.util.List;

@Dao(CfgDyncButtonEntity.class)
public interface ICfgDyncButtonDao extends CrudDao<CfgDyncButtonEntity,Long>{
    //查询按钮组包含的按钮
    public List<CfgDyncButtonEntity> getButtonByButtonsetId(long buttonsetId);
}