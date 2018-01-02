package com.tommonkey.blog.msg.service.impl;

import com.tommonkey.blog.msg.dao.IMessageServiceDao;
import com.tommonkey.blog.msg.service.interfaces.IMessageServiceSV;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.persistence.service.CrudServiceImpl;
import com.tommonkey.utils.bp.Constants;
import com.tommonkey.utils.common.JedisUtils;
import com.tommonkey.utils.sec.SessionManager;
import com.tommonkey.utils.sec.entity.MessageInterface;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class MessageServiceSVImpl extends CrudServiceImpl implements IMessageServiceSV {
	@Autowired
	private IMessageServiceDao dao;

	public CrudDao getDao() {
		return dao;
	}


	@Override
	public long sendMsg(Map map) throws Exception {
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
		return JedisUtils.listObjectAdd(Constants.Sys.MSG_LIST,msgInterface,0);
	}
}