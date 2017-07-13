package com.tommonkey.common.ftp.dao;

import com.tommonkey.common.ftp.entity.CfgFtpEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * Created by lury on 2015/7/21.
 */
@Dao(CfgFtpEntity.class)
public interface ICfgFtpDao extends CrudDao<CfgFtpEntity, String> {
}
