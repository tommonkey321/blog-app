package com.tommonkey.common.ftp.dao;

import com.tommonkey.common.ftp.entity.CfgFtpPathEntity;
import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;

/**
 * Created by lury on 2015/7/21.
 */
@Dao(CfgFtpPathEntity.class)
public interface ICfgFtpPathDao extends CrudDao<CfgFtpPathEntity, String> {
}
