package com.tommonkey.common.comment.service.interfaces;

import java.util.List;
import java.util.Map;

public interface ICfgCmtInstSubSV{

    /**
     * 保存子评论
     * @param param
     * @throws Exception
     */
    public void saveCfgCmtInstSubInfo(Map<String, Object> param)throws Exception;

    /**
     * 查询子评论信息
     * @param requestMap
     * @return
     * @throws Exception
     */
    List<Map<String,String>> queryCfgCmtInstSubInfo(Map<String, Object> requestMap)throws Exception;

    /**
     * 校验当前登录者是否打分评论了
     * @param requestMap
     * @return
     * @throws Exception
     */
    boolean checkOperatorHasSubCmt(Map<String, Object> requestMap)throws Exception;

    /**
     * 获取子评论的评论个数
     * @param requestMap
     * @return
     * @throws Exception
     */
    Map<String,Integer> getSubCmtItemCount(Map<String, Object> requestMap)throws Exception;
}