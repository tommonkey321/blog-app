package com.tommonkey.common.quartz.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.quartz.entity.CfgQuartzJobLogEntity;

/**
 * Created by dizl on 2015/6/15.
 */
@Dao(CfgQuartzJobLogEntity.class)
public interface IQuartzJobLogDao extends CrudDao<CfgQuartzJobLogEntity, String> {
}
