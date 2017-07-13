package com.tommonkey.common.split.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.split.entity.CfgTableSplitEntity;

/**
 * Created by dizl on 2015/6/2.
 */
@Dao(CfgTableSplitEntity.class)
public interface ICfgTableSplitDao extends CrudDao<CfgTableSplitEntity, String> {

}
