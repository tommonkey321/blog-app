package com.tommonkey.common.bp.dao;

import com.tommonkey.common.persistence.annotation.Dao;
import com.tommonkey.common.persistence.dao.CrudDao;
import com.tommonkey.common.bp.entity.CfgBpTemplateEntity;

@Dao(CfgBpTemplateEntity.class)
public interface ICfgBpTemplateDao extends CrudDao<CfgBpTemplateEntity, Long> {
}