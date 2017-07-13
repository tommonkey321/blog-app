package com.tommonkey.common.bp.service.impl;

import com.tommonkey.common.bp.dao.IEsBpDataRowDao;
import com.tommonkey.common.bp.entity.EsBpDataRowEntity;
import com.tommonkey.common.bp.service.interfaces.IEsBpDataRowSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsBpDataRowSVImpl implements IEsBpDataRowSV {
    @Autowired
    private IEsBpDataRowDao esBpDataRowDao;

    @Override
    public List<EsBpDataRowEntity> queryEsBpDataRow(EsBpDataRowEntity esBpDataRowEntity) throws Exception {
        return esBpDataRowDao.findByEntity(esBpDataRowEntity);
    }

    @Override
    public void saveEsBpDataRow(EsBpDataRowEntity esBpDataRowEntity) throws Exception {
        esBpDataRowDao.save(esBpDataRowEntity);
    }

    @Override
    public void saveEsBpDataRow(List<EsBpDataRowEntity> esBpDataRowEntityList) throws Exception {
        for (EsBpDataRowEntity esBpDataRowEntity : esBpDataRowEntityList) {
            esBpDataRowDao.save(esBpDataRowEntity);
        }
    }
}