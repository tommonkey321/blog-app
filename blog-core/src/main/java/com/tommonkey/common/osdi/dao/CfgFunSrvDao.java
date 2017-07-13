/**
 * $Id: CfgFunSrvDao.java,v 1.0 2015/11/6 16:25 09:55:18 zhangrp Exp $
 * <p/>
 * Copyright 2015 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.osdi.dao;

import com.tommonkey.common.osdi.entity.CfgFunSrv;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * @author zhangrp
 * @version $Id: CfgFunSrvDao.java,v 1.1 2015/11/6 16:25 zhangrp Exp $
 *          Created on 2015/11/6 16:25
 */
@Dao(CfgFunSrv.class)
public interface CfgFunSrvDao extends CrudDao<CfgFunSrv, String> {

}