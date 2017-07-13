package com.tommonkey.blog.api.sec;

import java.util.Map;

/**
 * Created by hyf on 2017/6/30.
 */
public interface ISecUserFSV {
    /**
     * 登陆校验
     * @param param
     * @return
     * @throws Exception
     */
    public String login(Map param) throws Exception;

    /**
     * 初始化首页数据()
     * @return
     * @throws Exception
     */
    public String initIndexData(String param) throws Exception;

    /**
     * 校验用户状态
     * @param param
     * @return
     * @throws Exception
     */
    public String checkStatus(String param) throws Exception;


    /**
     * 查看当前登陆的用户
     * @param param
     * @return
     * @throws Exception
     */
    public String getInLineUser(String param) throws Exception;


    /**
     * 根据sessionId剔除用户
     * @param param
     * @return
     * @throws Exception
     */
    public String outLineUserBySessionId(String param) throws Exception;

    /**
     * 根据条件剔除用户下线并关闭页面或锁定用户
     * @param param
     * @return
     * @throws Exception
     */
    public String outLineByConn(String param) throws Exception;

}
