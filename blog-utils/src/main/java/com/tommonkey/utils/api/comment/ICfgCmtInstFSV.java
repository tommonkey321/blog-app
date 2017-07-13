/**
 * $Id: ICfgCmtInstFSV.java,v 1.0 2016/9/8 11:18 RaoXb Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.api.comment;

/**
 * @author RaoXb
 * @version $Id: ICfgCmtInstFSV.java,v 1.1 2016/9/8 11:18 RaoXb Exp $
 * Created on 2016/9/8 11:18
 */
public interface ICfgCmtInstFSV {

    /**
     * 获取评论详情，包括平均得分、评论详情以及当前操作员的评论
     * @param requestJson
     * @return
     */
    public String getCfgCmtInstInfo(String requestJson);

    /**
     * 保存评论内容
     * @param requestJson
     * @return
     */
    public String commitCMTCxtInst(String requestJson);

    /**
     * 查询评论的历史记录
     * @param requestJson
     * @return
     */
    public String queryCMTCxtInst4CXT(String requestJson);

    /**
     * 校验当前登录者是否打分评论了
     * @param requestJson
     * @return
     */
    public String checkOperatorHasCmt(String requestJson);

    /**
     * 统计评论的个数
     * @param requestJson
     * @return
     */
    public String getCmtItemCount(String requestJson);
}