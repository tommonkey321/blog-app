package com.tommonkey.utils.im;

import com.tommonkey.utils.bp.Constants;
import com.tommonkey.utils.common.JedisUtils;
import com.tommonkey.utils.sec.SessionManager;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.comet4j.core.CometConnection;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;

import java.util.List;

/**
 * Created by hyf on 2017/7/8.
 */
public class outLineThread implements Runnable {
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
            //如果存在下线用户
            if(i>30 && JedisUtils.exists(Constants.Sys.OUT_LINE_CONN)){
                i=31;
                List<String> connList = JedisUtils.getList(Constants.Sys.OUT_LINE_CONN);
                JedisUtils.del(Constants.Sys.OUT_LINE_CONN);
                for (int j = 0; j < connList.size(); j++) {
                    try {
                        String sessionStr = connList.get(j);
                        UserInfoInterface userInfoInterface = SessionManager.getUser(sessionStr);
                        if(userInfoInterface == null){
                            continue;
                        }
                        String connStr = userInfoInterface.getConnId();
                        JedisUtils.del(sessionStr);//强制下线的，删除session对应的连接id
                        //在此会话有推送连接时，进行退出系统消息推送
                        if(connStr != null){
                            CometConnection conn = engine.getConnection(connStr);
                            engine.sendTo(Constants.Sys.CHANNEL,conn ,connStr+"_"+Constants.Sys.SYS_EXIT);
                        }
                    }catch (Exception e){

                    }
                }
            }
        }
    }
}
