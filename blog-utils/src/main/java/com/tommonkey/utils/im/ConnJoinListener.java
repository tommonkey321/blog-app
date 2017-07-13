package com.tommonkey.utils.im;

import com.tommonkey.utils.sec.SessionManager;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.comet4j.core.CometConnection;
import org.comet4j.core.event.ConnectEvent;
import org.comet4j.core.listener.ConnectListener;

/**
 * Created by hyf on 2017/7/8.
 */
public class ConnJoinListener extends ConnectListener {
    @Override
    public boolean handleEvent(ConnectEvent connectEvent) {
        CometConnection conn = connectEvent.getConn();
        String sessionId = conn.getRequest().getRequestedSessionId();
        //将连接加入到redis中
        try {
            if(sessionId != null){
                UserInfoInterface userInfoInterface = SessionManager.getUser(sessionId);
                if(userInfoInterface != null){
                    userInfoInterface.setConnId(conn.getId());
                    SessionManager.setUser(userInfoInterface);
                }
            }
        } catch (Exception e) {

        }
        return false;
    }

}
