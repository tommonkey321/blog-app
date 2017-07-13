package com.tommonkey.common.mess.service.interfaces;

import com.tommonkey.common.mess.entity.CfgMsgInfoEntity;

import java.util.List;

public interface ICfgMsgInfoSV{
    /**
     * 根据发送级别获取满足条件的数据
     * */
    public List<CfgMsgInfoEntity> getCfgMsgInfoBySendLevel(String sendLevel) throws Exception;
}