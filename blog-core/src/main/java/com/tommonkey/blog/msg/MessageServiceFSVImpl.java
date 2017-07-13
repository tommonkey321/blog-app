package com.tommonkey.blog.msg;

import com.alibaba.dubbo.config.annotation.Service;
import com.tommonkey.blog.api.msg.IMessageServiceFSV;
import com.tommonkey.utils.bp.Constants;
import com.tommonkey.utils.common.JedisUtils;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.response.Response;
import com.tommonkey.utils.sec.SessionManager;
import com.tommonkey.utils.sec.entity.MessageInterface;
import com.tommonkey.utils.sec.entity.UserInfoInterface;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hyf on 2017/7/7.
 */
@Service
public class MessageServiceFSVImpl implements IMessageServiceFSV {

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
            MessageInterface msgInterface = new MessageInterface();
            String receiveSessionId = (String) map.get("receiveSessionId");
            Integer msgType = Integer.parseInt(map.get("msgType").toString());
            Integer sendType = Integer.parseInt(map.get("sendType").toString());
            String msgTitle = (String) map.get("msgTitle");
            Integer msgShowTime = Integer.parseInt(map.get("msgShowTime").toString());
            String msgContent = (String) map.get("msgContent");
            String msgShowType = (String) map.get("msgShowType");
            String showPosition = (String) map.get("showPosition");

            UserInfoInterface sendUser = SessionManager.getUser();
            UserInfoInterface receUser = SessionManager.getUser(receiveSessionId);
            if(sendUser == null || receUser == null){
                throw new Exception("连接中断，请重新登陆后再试");
            }
            msgInterface.setSendUser(sendUser);
            msgInterface.setReceiveUser(receUser);
            msgInterface.setSendDate(new Date());
            msgInterface.setEffTime(60*60*24);//暂定24小时
            msgInterface.setMsgType(msgType);
            msgInterface.setSendType(sendType);
            msgInterface.setMsgState(0);
            msgInterface.setMsgTitle(msgTitle);
            msgInterface.setMsgContent(msgContent);
            msgInterface.setMsgShowTime(msgShowTime);
            msgInterface.setMsgShowType(msgShowType);
            msgInterface.setShowPosition(showPosition);

            //将消息放入队列
            result = JedisUtils.listObjectAdd(Constants.Sys.MSG_LIST,msgInterface,0);
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
