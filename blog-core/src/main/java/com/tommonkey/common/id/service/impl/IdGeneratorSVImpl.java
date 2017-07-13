package com.tommonkey.common.id.service.impl;

import com.tommonkey.common.id.dao.IIdGeneratorDao;
import com.tommonkey.common.id.entity.IdGeneratorEntity;
import com.tommonkey.common.id.service.interfaces.IIdGeneratorSV;
import com.tommonkey.common.utils.CommConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dizl on 2015/6/4.
 * 主键生成类
 */
@Service
public class IdGeneratorSVImpl implements IIdGeneratorSV {
    @Autowired
    private IIdGeneratorDao idGeneratorDao;

    @Transactional(readOnly = true)
    public List<IdGeneratorEntity> getAllIdGeneratorEntity() throws Exception {
        IdGeneratorEntity entity = new IdGeneratorEntity();
        entity.setState(CommConstants.State.STATE_NORMAL);
        return idGeneratorDao.findByEntity(entity);
    }

    @Transactional(readOnly = true)
    public IdGeneratorEntity getIdGeneratorEntityByTableName(String tableName) throws Exception {
        return idGeneratorDao.findById(tableName);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateEntity(IdGeneratorEntity entity) throws Exception {
        idGeneratorDao.updateById(entity);
    }
}
