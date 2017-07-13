package com.tommonkey.utils.sec.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息实体类
 * Created by hyf on 2017/7/7.
 */
public class MessageInterface implements Serializable {
    private UserInfoInterface sendUser;//发送者用户信息
    private UserInfoInterface receiveUser;//接收者用户信息
    private Date sendDate;//发送时间
    private Integer effTime;//有效期
    private Integer msgType;//消息类型：1.系统消息，2.普通消息
    private Integer sendType;//发送类型：1.所有人，2.在线用户，3.单个用户
    private Integer msgState;//消息状态
    private String msgTitle;//消息标题
    private Integer msgShowTime;//消息显示时间（S）
    private String msgShowType;//显示类型，错误、警告、通知，等
    private String msgContent;//消息内容
    private String remark;//备注
    private String showPosition;//显示位置

    public void setShowPosition(String showPosition) {
        this.showPosition = showPosition;
    }

    public String getShowPosition() {
        return showPosition;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public void setMsgShowTime(Integer msgShowTime) {
        this.msgShowTime = msgShowTime;
    }

    public void setMsgShowType(String msgShowType) {
        this.msgShowType = msgShowType;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public Integer getMsgShowTime() {
        return msgShowTime;
    }

    public String getMsgShowType() {
        return msgShowType;
    }

    public void setSendUser(UserInfoInterface sendUser) {
        this.sendUser = sendUser;
    }

    public void setReceiveUser(UserInfoInterface receiveUser) {
        this.receiveUser = receiveUser;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public void setEffTime(Integer effTime) {
        this.effTime = effTime;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public void setMsgState(Integer msgState) {
        this.msgState = msgState;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UserInfoInterface getSendUser() {
        return sendUser;
    }

    public UserInfoInterface getReceiveUser() {
        return receiveUser;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public Integer getEffTime() {
        return effTime;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public Integer getMsgState() {
        return msgState;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public String getRemark() {
        return remark;
    }
}
