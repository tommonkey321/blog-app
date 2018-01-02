package com.tommonkey.blog.msg.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.utils.sec.entity.MessageInterface;

@Dao(MessageInterface.class)
public interface IMessageServiceDao extends CrudDao<MessageInterface,Long>{
}