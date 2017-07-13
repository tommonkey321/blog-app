/**
 * $Id: ICfgCmtBasicFSV.java,v 1.0 2016/9/8 11:05 RaoXb Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.api.comment;

/**
 * @author RaoXb
 * @version $Id: ICfgCmtBasicFSV.java,v 1.1 2016/9/8 11:05 RaoXb Exp $
 * Created on 2016/9/8 11:05
 */
public interface ICfgCmtBasicFSV {

    /**
     * 展示前台的评论界面信息
     * @param requestJson 报文信息
     * @return 返回报文 {errorInfo:{code:,message:},data:{}}
     */
    public String getCmtItemInfo(String requestJson);
}