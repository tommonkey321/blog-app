/**
 * $Id: CommentConstants.java,v 1.0 2016/9/8 16:23 RaoXb Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.comment.utils;

/**
 * @author RaoXb
 * @version $Id: CommentConstants.java,v 1.1 2016/9/8 16:23 RaoXb Exp $
 * Created on 2016/9/8 16:23
 */
public class CommentConstants {
    /**
     * 评论类型分组编号
     */
    public class GroupId{
        /**
         * 点赞组
         */
        public static final String CMT_GROUP_ID_1 = "1";
        /**
         * 五星评论组
         */
        public static final String CMT_GROUP_ID_2 = "2";
        /**
         * 评论组
         */
        public static final String CMT_GROUP_ID_3 = "3";
    }

    public class State {
        public static final String Y = "Y";//是
        public static final String N = "N";//否
        public static final String E = "E";//无效状态
        public static final String U = "U";//有效状态
        public static final String I = "I";
        public static final int STATE_NORMAL = 1;//有效状态
        public static final long STATE_NORMAL_L = 1L;//有效状态
        public static final int STATE_ABNORMAL = 0;//无效状态
        public static final long STATE_ABNORMAL_L = 0L;//无效状态
    }
}