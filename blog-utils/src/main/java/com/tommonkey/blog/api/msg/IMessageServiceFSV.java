package com.tommonkey.blog.api.msg;

import com.tommonkey.utils.sec.entity.MessageInterface;

/**
 * 消息发送服务
 * Created by hyf on 2017/7/7.
 */
public interface IMessageServiceFSV {

    /**
     * 发送消息
     * @param param
     * @return
     * @throws Exception
     */
    public String sendMsg(String param) throws Exception;

    public MessageInterface getMsg(String param) throws Exception;
}
