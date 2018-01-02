package com.tommonkey.blog.msg;

import com.alibaba.dubbo.config.annotation.Service;
import com.tommonkey.blog.api.msg.IMessageServiceFSV;
import com.tommonkey.blog.msg.service.interfaces.IMessageServiceSV;
import com.tommonkey.utils.bp.Constants;
import com.tommonkey.utils.common.JedisUtils;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.response.Response;
import com.tommonkey.utils.sec.entity.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by hyf on 2017/7/7.
 */
@Service
public class MessageServiceFSVImpl implements IMessageServiceFSV {

    @Autowired
    private IMessageServiceSV iMessageServiceSV;
    /**
     * 发送消息服务
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public String sendMsg(String param) throws Exception {
        Response response = new Response();
        long result = 0 ;
        Map<String, Object> map = JsonUtil.json2Map(param);
        try {
            result = iMessageServiceSV.sendMsg(map);
            if(result == 0){
                throw new Exception("消息发送失败");
            }
            response.setMessage("消息发送成功");
            response.setCode(Response.SUCCESS);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
        }
        return response.toString();
    }

    /**
     * 获取消息服务
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public MessageInterface getMsg(String param) throws Exception {
        //如果存在消息
        if(JedisUtils.exists(Constants.Sys.MSG_LIST)){
            List  msgList = JedisUtils.getObjectList(Constants.Sys.MSG_LIST);

        }
        return null;
    }
}
