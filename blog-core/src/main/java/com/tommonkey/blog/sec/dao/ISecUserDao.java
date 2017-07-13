package com.tommonkey.blog.sec.dao;

import com.tommonkey.blog.sec.entity.SecUserEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

import java.util.List;

@Dao(SecUserEntity.class)
public interface ISecUserDao extends CrudDao<SecUserEntity,Long>{
    public List<SecUserEntity> getAllSecUser()throws Exception;
}