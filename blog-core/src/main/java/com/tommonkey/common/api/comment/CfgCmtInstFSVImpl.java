/**
 * $Id: CfgCmtInstFSVImpl.java,v 1.0 2016/9/8 11:19 RaoXb Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.api.comment;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.tommonkey.common.comment.service.interfaces.ICfgCmtInstSV;
import com.tommonkey.utils.api.comment.ICfgCmtInstFSV;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.response.Response;
import com.tommonkey.utils.sec.SessionManager;
import com.tommonkey.utils.sec.entity.UserInfoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RaoXb
 * @version $Id: CfgCmtInstFSVImpl.java,v 1.1 2016/9/8 11:19 RaoXb Exp $
 * Created on 2016/9/8 11:19
 */
@Service
public class CfgCmtInstFSVImpl implements ICfgCmtInstFSV {

    private static final Logger logger = LoggerFactory.getLogger(CfgCmtInstFSVImpl.class);

    @Autowired
    private ICfgCmtInstSV cfgCmtInstSV;

    @Override
    public String getCfgCmtInstInfo(String requestJson) {

        return null;
    }

    /**
     * 保存评论内容
     * @param requestJson
     * @return
     */
    @Override
    public String commitCMTCxtInst(String requestJson){
        Response response = new Response();
        try {
            Map<String, Object> requestMap = JsonUtil.json2Map(requestJson);
            String sessionId = RpcContext.getContext().getAttachment(SessionManager.SESSION_KEY);
            UserInfoInterface userInfo = SessionManager.getUser(sessionId);
            if(null == userInfo){
                userInfo = new UserInfoInterface();
                userInfo.setUserId(-1L);
                userInfo.setNikeName("游客");
            }
            if(userInfo.getUserId()<1){
                throw new Exception("未获取到有效的登录信息！");
            }
            requestMap.put("_loginInfo_user",userInfo);
            cfgCmtInstSV.commitCMTCxtInst(requestMap);
            Map responseMap = new HashMap();
            response.setCode(Response.SUCCESS);
            response.setMessage("查询成功！");
            response.setData(responseMap);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
            logger.error("保存评论信息异常"+e);
        }
        return response.toString();
    }

    /**
     * 查询评论内容
     * @param requestJson
     * @return
     */
    @Override
    public String queryCMTCxtInst4CXT(String requestJson){
        Response response = new Response();
        try {
            Map<String, Object> requestMap = JsonUtil.json2Map(requestJson);
            List<Map<String,String>> result = cfgCmtInstSV.queryCMTCxtInst4CXT(requestMap);
            Map responseMap = new HashMap();
            responseMap.put("data", result);
            response.setData(responseMap);
            response.setCode(Response.SUCCESS);
            response.setMessage("查询成功！");
            response.setData(responseMap);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
            logger.error("查询失败"+e);
        }
        return response.toString();
    }

    /**
     * 校验当前登录者是否打分评论了
     * @param requestJson
     * @return
     */
    @Override
    public String checkOperatorHasCmt(String requestJson) {

        Response response = new Response();
        try {
            Map<String, Object> requestMap = JsonUtil.json2Map(requestJson);
            String sessionId = RpcContext.getContext().getAttachment(SessionManager.SESSION_KEY);
            UserInfoInterface userInfo = SessionManager.getUser(sessionId);
            if(null == userInfo){
                userInfo = new UserInfoInterface();
                userInfo.setUserId(-1L);
                userInfo.setNikeName("游客");
            }
            if(userInfo.getUserId()<1){
                throw new Exception("未获取到有效的登录信息！");
            }
            requestMap.put("_loginInfo_user",userInfo);
            boolean resultFlag = cfgCmtInstSV.checkOperatorHasCmt(requestMap);
            Map responseMap = new HashMap();
            responseMap.put("data", resultFlag);
            response.setData(responseMap);
            response.setCode(Response.SUCCESS);
            response.setMessage("查询成功！");
            response.setData(responseMap);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
            logger.error("查询失败"+e);
        }
        return response.toString();
    }

    /**
     * 统计评论的个数
     * @param requestJson
     * @return
     */
    //todo 准备做这个
    @Override
    public String getCmtItemCount(String requestJson) {
        Response response = new Response();
        try {
            Map<String, Object> requestMap = JsonUtil.json2Map(requestJson);
            Map<String,Integer> result = cfgCmtInstSV.getCmtItemCount(requestMap);
            Map responseMap = new HashMap();
            responseMap.put("data", result);
            response.setData(responseMap);
            response.setCode(Response.SUCCESS);
            response.setMessage("查询成功！");
            response.setData(responseMap);
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
            logger.error("查询失败"+e);
        }
        return response.toString();
    }
}