/**
 * $Id: FileType.java,v 1.0 2016/9/8 15:37 zhangrp Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.ftp.entity;

/**
 * @author zhangrp
 * @version $Id: FileType.java,v 1.1 2016/9/8 15:37 zhangrp Exp $
 *          Created on 2016/9/8 15:37
 */
public enum FileType {
    BIN(2), ASC(1);

    private int value;

    FileType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}