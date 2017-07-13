package com.tommonkey.common.id.dao;

import com.tommonkey.common.id.entity.IdGeneratorEntity;
import com.tommonkey.common.persistence.dao.CrudDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tommonkey.common.persistence.annotation.Dao;

/**
 * Created by dizl on 2015/6/4.
 */
@Dao(IdGeneratorEntity.class)
public interface IIdGeneratorDao extends CrudDao<IdGeneratorEntity, String> {
    @Select("select ${value}.nextval from dual")
    public long getNewId(@Param("value") String sequenceName) throws Exception;
}
