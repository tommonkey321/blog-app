/**
 * $Id: CfgCmtInstSubFSVImpl.java,v 1.0 2016/9/18 14:59 RaoXb Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.api.comment;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.tommonkey.common.comment.service.interfaces.ICfgCmtInstSubSV;
import com.tommonkey.utils.api.comment.ICfgCmtInstSubFSV;
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
 * @version $Id: CfgCmtInstSubFSVImpl.java,v 1.1 2016/9/18 14:59 RaoXb Exp $
 * Created on 2016/9/18 14:59
 */
@Service
public class CfgCmtInstSubFSVImpl implements ICfgCmtInstSubFSV {

    private static final Logger logger = LoggerFactory.getLogger(CfgCmtInstSubFSVImpl.class);

    @Autowired
    private ICfgCmtInstSubSV cfgCmtInstSubSV;


    /**
     * 保存子评论的操作
     * @param requestJson
     * @return
     */
    @Override
    public String saveCfgCmtInstSubInfo(String requestJson) {
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
            requestMap.put("_loginInfo_user", userInfo);
            cfgCmtInstSubSV.saveCfgCmtInstSubInfo(requestMap);

            response.setCode(Response.SUCCESS);
            response.setMessage("查询成功！");
        }catch (Exception e){
            response.setCode(Response.ERROR);
            response.setMessage(e.getMessage());
            logger.error("查询失败"+e);
        }
        return response.toString();
    }

    /**
     * 查询子评论的详情
     * @param requestJson
     * @return
     */
    @Override
    public String queryCfgCmtInstSubInfo(String requestJson){
        Response response = new Response();
        try {
            Map<String, Object> requestMap = JsonUtil.json2Map(requestJson);
            List<Map<String,String>> result = cfgCmtInstSubSV.queryCfgCmtInstSubInfo(requestMap);
            Map responseMap = new HashMap();
            responseMap.put("data", result);
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
    public String checkOperatorHasSubCmt(String requestJson) {
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
            boolean resultFlag = cfgCmtInstSubSV.checkOperatorHasSubCmt(requestMap);
            Map responseMap = new HashMap();
            responseMap.put("data", resultFlag);
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
    @Override
    public String getCmtSubItemCount(String requestJson) {
        Response response = new Response();
        try {
            Map<String, Object> requestMap = JsonUtil.json2Map(requestJson);
            Map<String,Integer> result = cfgCmtInstSubSV.getSubCmtItemCount(requestMap);
            Map responseMap = new HashMap();
            responseMap.put("data", result);
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