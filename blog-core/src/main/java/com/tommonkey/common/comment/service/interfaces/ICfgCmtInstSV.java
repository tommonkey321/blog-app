package com.tommonkey.common.comment.service.interfaces;

import java.util.List;
import java.util.Map;

public interface ICfgCmtInstSV{

    /**
     * 保存评论信息
     * @param paramMap
     * @throws Exception
     */
    public void commitCMTCxtInst(Map<String, Object> paramMap)throws Exception;

    /**
     * 查询文字评论历史记录
     * @param paramMap {page:"",pageSize:"",itemIds:"1_2",cmtTargetId:""}
     * @return List<Map>
     *     [{itemId1:itemVal1,itemId2:itemVal2,cmtTargetId:"",creator:"",creatorName:"",createDate:""},<br/>{}]
     * @throws Exception
     */
    public List<Map<String,String>> queryCMTCxtInst4CXT(Map<String, Object> paramMap)throws Exception;

    /**
     * 校验当前登录者是否打分评论了
     * @param requestMap
     * @return
     * @throws Exception
     */
    boolean checkOperatorHasCmt(Map<String, Object> requestMap)throws Exception;

    /**
     * 统计评论的个数
     *  [key:itemId value:count]
     * @param requestMap
     * @return
     */
    Map<String,Integer> getCmtItemCount(Map<String, Object> requestMap)throws Exception;
}