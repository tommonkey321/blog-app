package com.tommonkey.common.dync.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.dync.entity.CfgDyncPageTemplateEntity;

@Dao(CfgDyncPageTemplateEntity.class)
public interface ICfgDyncPageTemplateDao extends CrudDao<CfgDyncPageTemplateEntity,Long> {
}