/**
 * $Id: CfgCmtBasicFSVImpl.java,v 1.0 2016/9/8 11:08 RaoXb Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.api.comment;

import com.alibaba.dubbo.config.annotation.Service;
import com.tommonkey.common.comment.entity.CfgCmtBasicTreeEntity;
import com.tommonkey.common.comment.service.interfaces.ICfgCmtBasicSV;
import com.tommonkey.utils.api.comment.ICfgCmtBasicFSV;
import com.tommonkey.utils.common.JsonUtil;
import com.tommonkey.utils.common.StringUtils;
import com.tommonkey.utils.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RaoXb
 * @version $Id: CfgCmtBasicFSVImpl.java,v 1.1 2016/9/8 11:08 RaoXb Exp $
 * Created on 2016/9/8 11:08
 */
@Service
public class CfgCmtBasicFSVImpl implements ICfgCmtBasicFSV{

    private static final Logger logger = LoggerFactory.getLogger(CfgCmtBasicFSVImpl.class);

    @Autowired
    private ICfgCmtBasicSV cfgCmtBasicSV;

    /**
     * 展示前台的评论界面信息
     * @param requestJson 报文信息
     * @return 返回报文 {errorInfo:{code:,message:},data:{}}
     */
    public String getCmtItemInfo(String requestJson){
        Response response = new Response();
        try {
            Map<String, Object> requestMap = JsonUtil.json2Map(requestJson);
            //数据来源 1 PC 2 APP
            String moduleIdStr = requestMap.get("MODULE_ID")==null?"":String.valueOf(requestMap.get("MODULE_ID"));
            if (StringUtils.isBlank(moduleIdStr)){
                throw new Exception("未获取到数据来源信息！");
            }
            if(!StringUtils.equals("1",moduleIdStr)&&!StringUtils.equals("2",moduleIdStr)){
                throw new Exception("数据来源信息异常！");
            }
            //评论对象编号
            String cmtTargetId = requestMap.get("CMT_TARGET_ID")==null?"":String.valueOf(requestMap.get("CMT_TARGET_ID"));
            if(StringUtils.isBlank(cmtTargetId)){
                throw new Exception("参数【评论对象编号】异常！");
            }
            List<CfgCmtBasicTreeEntity> cmtBasicInfoList = cfgCmtBasicSV.getCfgCmtBasicInfo(cmtTargetId,Integer.parseInt(moduleIdStr));
            if(null == cmtBasicInfoList || cmtBasicInfoList.size() < 1){
                throw new Exception("没有需要评论的内容。");
            }
            //防止组合号乱序，重新排个序号
            Map<String,List<CfgCmtBasicTreeEntity>> orderResult = new HashMap<>();
            for(CfgCmtBasicTreeEntity basicEntity : cmtBasicInfoList){
                if(orderResult.containsKey(String.valueOf(basicEntity.getGroupId()))){
                    //若存在
                    List<CfgCmtBasicTreeEntity> tempList = orderResult.get(String.valueOf(basicEntity.getGroupId()));
                    tempList.add(basicEntity);
                }else{
                    //若不存在则需要要新增
                    List<CfgCmtBasicTreeEntity> tempList = new ArrayList<>();
                    tempList.add(basicEntity);
                    orderResult.put(String.valueOf(basicEntity.getGroupId()),tempList);
                }
            }
            Map responseMap = new HashMap();
            responseMap.put("data", orderResult);
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