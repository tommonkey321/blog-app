package com.tommonkey.blog.sec.service.interfaces;

import com.tommonkey.blog.sec.entity.SecUserEntity;
import com.tommonkey.common.persistence.service.CrudService;

import java.util.List;

public interface ISecUserSV extends CrudService{
    public List<SecUserEntity> getAllSecUser()throws Exception;
}