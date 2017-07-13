/**
 * $Id: Constants.java,v 1.0 17/2/23 下午2:25 zhangruiping Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.bp;

/**
 * @author zhangruiping
 * @version $Id: Constants.java,v 1.1 17/2/23 下午2:25 zhangruiping Exp $
 *          Created on 17/2/23 下午2:25
 */
public class Constants {

    public class FileType {
        public static final int TXT = 0;
        public static final int CVS = 1;
        public static final int EXCEL = 2;
        public static final int EXCEL_XLS = 3;
        public static final int EXCEL_XLSX = 4;
    }

    public class RowType {
        public static final int HEADER = 0;//文件头
        public static final int CONTENT = 1;//文件内容
    }

    public class Sys{
        public static final String CHANNEL = "msg";
        public static final String IN_LINE_USER = "IN_LINE_USER";//redis中在线用户列表key
        public static final String OUT_LINE_CONN = "OUT_LINE_CONN";//redis中强制下线列表key
        public static final String CONN_ = "CONN_";//用户session和通讯连接对应关系
        public static final String MSG_LIST = "_MSG_LIST";
        public static final String SYS_EXIT = "/SYS_FUU_EXIT/";
    }

    public class Msg{
        public static final int ALL_USER = 1;//发送消息给所有人
    }



}