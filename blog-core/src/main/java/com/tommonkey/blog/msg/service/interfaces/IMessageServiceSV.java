package com.tommonkey.blog.msg.service.interfaces;

import com.tommonkey.common.persistence.service.CrudService;

import java.util.Map;


public interface IMessageServiceSV extends CrudService{
    public long sendMsg(Map map) throws Exception;
}