package com.tommonkey.common.split.service.impl;

import com.tommonkey.common.split.service.interfaces.ISplitTableConvertSV;

/**
 * Created by dizl on 2015/6/3.
 */
public class StringConvertSVImpl implements ISplitTableConvertSV {

    @Override
    public String convert(Object value) throws Exception {
        String retValue = null;
        if (value != null) {
            retValue = value.toString();
        }
        return retValue;
    }
}
