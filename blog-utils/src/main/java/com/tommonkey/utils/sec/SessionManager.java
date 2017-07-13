package com.tommonkey.utils.sec;

import com.alibaba.dubbo.rpc.RpcContext;
import com.tommonkey.utils.bp.Constants;
import com.tommonkey.utils.common.JedisUtils;
import com.tommonkey.utils.config.Global;
import com.tommonkey.utils.sec.entity.UserInfoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 已登录用户
 */
public class SessionManager {
    public final static String SESSION_KEY = "SESSION_ID";

    /**
     * SESSION 超时时间
     */
    public static int timeout = 30 * 60;

    static {
        String sessionTimeout = Global.getConfig("session.sessionTimeout");
        if (sessionTimeout != null && !sessionTimeout.equals("")) {
            timeout = Integer.valueOf(sessionTimeout);
        }
    }

    public static UserInfoInterface getUser() throws Exception {
        String sessionId = RpcContext.getContext().getAttachment(SessionManager.SESSION_KEY);
        return getUser(sessionId);
    }

    public static UserInfoInterface getUser(String sessionId) throws Exception {
        UserInfoInterface userInfoEntity = null;
        if (com.tommonkey.utils.common.JedisUtils.exists(sessionId)) {
            userInfoEntity = (UserInfoInterface) com.tommonkey.utils.common.JedisUtils.getObject(sessionId, timeout);
        }
        return userInfoEntity;
    }

    public static void checkLogin(String sessionId) throws Exception {
        UserInfoInterface userInfoInterface = SessionManager.getUser(sessionId);
        if (userInfoInterface == null) {
            throw new Exception("用户未登陆！");
        } else {
            RpcContext.getContext().setAttachment(SessionManager.SESSION_KEY, sessionId);
        }
    }

    public static void setUser(UserInfoInterface user) throws Exception {
        if (com.tommonkey.utils.common.JedisUtils.existsObject(user.getSessionId())) {
            com.tommonkey.utils.common.JedisUtils.delObject(user.getSessionId());
        }
        com.tommonkey.utils.common.JedisUtils.setObject(user.getSessionId(), user, timeout);
    }

    /**
     * 添加当前用户到在线列表中
     * @param sessionId
     * @throws Exception
     */
    public static void addInLine(String sessionId) throws Exception{
        com.tommonkey.utils.common.JedisUtils.listAdd(Constants.Sys.IN_LINE_USER,sessionId);
    }

    /**
     * 获取当前登陆用户列表
     * @return
     * @throws Exception
     */
    public static List<UserInfoInterface> getInLine() throws Exception{
        List<UserInfoInterface> listUser = null;
        List<String> sessionList = com.tommonkey.utils.common.JedisUtils.getList(Constants.Sys.IN_LINE_USER);
        if(sessionList != null && sessionList.size()>0){
            listUser = new ArrayList<>();
            for (int i = 0; i < sessionList.size(); i++) {
                UserInfoInterface userinfo = getUser(sessionList.get(i));
                if(userinfo != null){
                    listUser.add(userinfo);
                }
            }
            sortUserInfoList(listUser);
        }
        return listUser;
    }


    /**
     *  根据sessionId剔除用户
     * @param sessionId
     * @param OPType
     * OPType:0,只剔除用户下线，1.剔除并关闭用户浏览的页面，2.剔除并关闭用户浏览页面并加黑此用户
     * @param cased
     * 是否级联剔除此用户的所有登陆会话,0否，1是
     * @throws Exception
     */
    public static void outLine(String sessionId,int OPType,int cased) throws Exception{
        UserInfoInterface userInfoInterface = null;
        if (com.tommonkey.utils.common.JedisUtils.existsObject(sessionId) && OPType == 0) {
            userInfoInterface = (UserInfoInterface) com.tommonkey.utils.common.JedisUtils.getObject(sessionId);
            List<String> sessionList = com.tommonkey.utils.common.JedisUtils.getList(Constants.Sys.IN_LINE_USER);
            sessionList.remove(sessionId);
            if(sessionList.size() != 0){
                JedisUtils.setList(Constants.Sys.IN_LINE_USER,sessionList,0);
            }else{
                JedisUtils.del(Constants.Sys.IN_LINE_USER);
            }
            JedisUtils.listAdd(Constants.Sys.OUT_LINE_CONN,sessionId);
        }
        //todo 1关闭页面标识
//        if(OPType == 1 || OPType == 2){
//            com.tommonkey.utils.common.JedisUtils.set(sessionId+"_STATUS","0");//关闭会话标识
//            if(cased == 1){
//                com.tommonkey.utils.common.JedisUtils.set(userInfoInterface.getUserId()+"_STATUS","0");//关闭用户所有会话标识
//            }
//        }
        //todo 2锁定此用户

    }


    public static void sortUserInfoList(List list) {
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                UserInfoInterface s1 = (UserInfoInterface) o1;
                UserInfoInterface s2 = (UserInfoInterface) o2;
                if (s1.getLastBusiDate().getTime() > s2.getLastBusiDate().getTime()) {
                    return 1;
                } else if (s1.getLastBusiDate().getTime() == s2.getLastBusiDate().getTime()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }


    }
