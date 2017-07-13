package com.tommonkey.common.bp.service.impl;

import com.tommonkey.common.bp.dao.ICfgBpTemplateDao;
import com.tommonkey.common.bp.entity.CfgBpTemplateEntity;
import com.tommonkey.common.bp.service.interfaces.ICfgBpTemplateSV;
import com.tommonkey.common.utils.CommConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CfgBpTemplateSVImpl implements ICfgBpTemplateSV {
    @Autowired
    private ICfgBpTemplateDao cfgBpTemplateDao;

    /**
     * 查询BP配置数据
     *
     * @param cfgBpTemplateEntity
     * @return
     * @throws Exception
     */
    @Override
    public List<CfgBpTemplateEntity> queryCfgBpTemplate(CfgBpTemplateEntity cfgBpTemplateEntity) throws Exception {
        cfgBpTemplateEntity.setState(CommConstants.State.STATE_NORMAL);
        return cfgBpTemplateDao.findByEntity(cfgBpTemplateEntity);
    }

}