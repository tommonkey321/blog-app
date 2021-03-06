package com.tommonkey.common.split.service.impl;

import com.tommonkey.common.split.service.interfaces.ISplitTableConvertSV;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dizl on 2015/6/3.
 * 按照年进行分表
 */
public class YYYYConvertSVImpl implements ISplitTableConvertSV {

    @Override
    public String convert(Object value) throws Exception {
        String rtn = null;
        if (value != null && value instanceof Date) {
            DateFormat objDateFormat = new SimpleDateFormat("yyyy");
            rtn = objDateFormat.format(value);
        }
        return rtn;
    }
}
