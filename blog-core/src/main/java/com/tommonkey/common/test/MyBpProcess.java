/**
 * $Id: MyBpProcess.java,v 1.0 17/2/17 下午12:25 zhangruiping Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.test;

import com.tommonkey.common.bp.BpProcess;
import com.tommonkey.common.bp.entity.EsBpDataColEntity;
import com.tommonkey.common.bp.entity.EsBpDataEntity;
import com.tommonkey.common.bp.entity.EsBpDataRowEntity;

/**
 * @author zhangruiping
 * @version $Id: MyBpProcess.java,v 1.1 17/2/17 下午12:25 zhangruiping Exp $
 *          Created on 17/2/17 下午12:25
 */
public class MyBpProcess implements BpProcess {

    @Override
    public void processData(EsBpDataEntity esBpDataEntity, EsBpDataRowEntity esBpDataRowEntity) throws Exception {

        StringBuilder info = new StringBuilder("");
        info.append(esBpDataRowEntity.getDataId() + "-" + esBpDataRowEntity.getRowId() + "===");

        for (EsBpDataColEntity esBpDataColEntity : esBpDataRowEntity.getEsBpDataColEntityList()) {
            info.append(esBpDataColEntity.getColNum() + ":" + esBpDataColEntity.getColValue() + ",");
        }
        System.out.println(info);
        if (Math.random() > 0.5) {
            throw new Exception("错误！");
        }
    }
}