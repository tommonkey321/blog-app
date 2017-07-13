/**
 * $Id: ICfgCmtInstSubFSV.java,v 1.0 2016/9/18 14:58 RaoXb Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.api.comment;

/**
 * 对文字评论的子评论操作类
 * @author RaoXb
 * @version $Id: ICfgCmtInstSubFSV.java,v 1.1 2016/9/18 14:58 RaoXb Exp $
 * Created on 2016/9/18 14:58
 */
public interface ICfgCmtInstSubFSV {

    /**
     * 保存子评论的操作
     * @param requestJson
     * @return
     */
    public String saveCfgCmtInstSubInfo(String requestJson);

    /**
     * 查询子评论的详情
     * @param requestJson
     * @return
     */
    public String queryCfgCmtInstSubInfo(String requestJson);

    /**
     * 校验当前登录者是否打分评论了
     * @param requestJson
     * @return
     */
    public String checkOperatorHasSubCmt(String requestJson);

    /**
     * 统计评论的个数
     * @param requestJson
     * @return
     */
    public String getCmtSubItemCount(String requestJson);


}