package com.tommonkey.utils.sec.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfoInterface implements Serializable {
    private String sessionId; //用户登录sessionId
    private Long userId;//操作员编号
    private String userName;//用户名
    private String password;//密码
    private String nikeName;//昵称
    private String realName;//真实姓名
    private String billid;//手机号
    private String email;//EMAIL
    private String qq;//QQ
    private String blogAddress;//博客地址
    private String sayHello;//介绍短语
    private String state;//状态
    private String headImage;//头像
    private Date loginDate;//登陆时间
    private Date lastBusiDate;//最后业务操作时间
    private String connId;//连接id

    public void setConnId(String connId) {
        this.connId = connId;
    }

    public String getConnId() {
        return connId;
    }

    private Integer int_3;//null

    private Integer int_2;//null

    private Integer int_1;//null

    private String str_5;//null

    private String str_4;//null

    private String str_3;//null

    private String str_2;//null

    private String str_1;//null





    public String getSessionId() {
        return sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getNikeName() {
        return nikeName;
    }

    public String getRealName() {
        return realName;
    }

    public String getBillid() {
        return billid;
    }

    public String getEmail() {
        return email;
    }

    public String getQq() {
        return qq;
    }

    public String getBlogAddress() {
        return blogAddress;
    }

    public String getSayHello() {
        return sayHello;
    }

    public String getState() {
        return state;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    public void setSayHello(String sayHello) {
        this.sayHello = sayHello;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public Integer getInt_3() {
        return int_3;
    }

    public Integer getInt_2() {
        return int_2;
    }

    public Integer getInt_1() {
        return int_1;
    }

    public String getStr_5() {
        return str_5;
    }

    public String getStr_4() {
        return str_4;
    }

    public String getStr_3() {
        return str_3;
    }

    public String getStr_2() {
        return str_2;
    }

    public String getStr_1() {
        return str_1;
    }

    public void setInt_3(Integer int_3) {
        this.int_3 = int_3;
    }

    public void setInt_2(Integer int_2) {
        this.int_2 = int_2;
    }

    public void setInt_1(Integer int_1) {
        this.int_1 = int_1;
    }

    public void setStr_5(String str_5) {
        this.str_5 = str_5;
    }

    public void setStr_4(String str_4) {
        this.str_4 = str_4;
    }

    public void setStr_3(String str_3) {
        this.str_3 = str_3;
    }

    public void setStr_2(String str_2) {
        this.str_2 = str_2;
    }

    public void setStr_1(String str_1) {
        this.str_1 = str_1;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public void setLastBusiDate(Date lastBusiDate) {
        this.lastBusiDate = lastBusiDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public Date getLastBusiDate() {
        return lastBusiDate;
    }
}
