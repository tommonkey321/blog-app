package com.tommonkey.utils.im;

import com.tommonkey.utils.bp.Constants;
import com.tommonkey.utils.common.JedisUtils;
import com.tommonkey.utils.sec.SessionManager;
import com.tommonkey.utils.sec.entity.MessageInterface;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.comet4j.core.CometConnection;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;

import java.util.List;

/**
 * Created by hyf on 2017/7/8.
 */
public class SendMsgThread implements Runnable {
    private static Object obj = new Object();
    @Override
    public void run() {
        int i=0;
        while (true) {
            i++;
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            CometEngine engine = CometContext.getInstance().getEngine();
            //如果存在待发送的消息
            System.out.println("***********************准备判断是否存在消息");
            if(i>30 && JedisUtils.exists(Constants.Sys.MSG_LIST)){
                i=31;
                List msgList = null;
                //去redis取数据的时候，对所有消息处理线程加锁，防止一段时间内的消息被多个线程取到
                synchronized (obj){
                    if(JedisUtils.exists(Constants.Sys.MSG_LIST)){//再次判断是否还有未发送的数据
                        msgList = JedisUtils.getObjectList(Constants.Sys.MSG_LIST);
                        JedisUtils.del(Constants.Sys.MSG_LIST);
                    }
                }
                for (int j = 0; msgList != null && j < msgList.size(); j++) {
                    try {
                        MessageInterface msgInter = null;
                        try {
                            msgInter  = (MessageInterface) msgList.get(j);
                        }catch (Exception e){
                            continue;
                        }
                        String resultJson ="";
                        //判断此消息是否是全局消息，发送给所有人
                        if(msgInter.getSendType()== Constants.Msg.ALL_USER){
                            msgInter.setSendUser(null);
                            msgInter.setReceiveUser(null);
                            resultJson = com.tommonkey.utils.common.JsonUtil.object2Json(msgInter);
                            engine.sendToAll(Constants.Sys.CHANNEL, resultJson);
                            continue;
                        }
                        UserInfoInterface userInfoInterface = SessionManager.getUser(msgInter.getReceiveUser().getSessionId());
                        if(userInfoInterface == null){
                            continue;
                        }
                        String connStr = userInfoInterface.getConnId();
                        //在此会话有推送连接时，进行退出系统消息推送
                        if(connStr != null){
                            CometConnection conn = engine.getConnection(connStr);
                            //压缩对象大小，将不需要的信息移除
                            msgInter.setSendUser(null);
                            msgInter.setReceiveUser(null);
                            resultJson = com.tommonkey.utils.common.JsonUtil.object2Json(msgInter);
                            engine.sendTo(Constants.Sys.CHANNEL,conn ,resultJson);
                        }
                    }catch (Exception e){

                    }

                }
            }
        }
    }
}
