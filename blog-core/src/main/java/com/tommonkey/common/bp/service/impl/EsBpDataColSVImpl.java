package com.tommonkey.common.bp.service.impl;

import com.tommonkey.common.bp.dao.IEsBpDataColDao;
import com.tommonkey.common.bp.entity.EsBpDataColEntity;
import com.tommonkey.common.bp.service.interfaces.IEsBpDataColSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsBpDataColSVImpl implements IEsBpDataColSV {
    @Autowired
    private IEsBpDataColDao esBpDataColDao;

    @Override
    public List<EsBpDataColEntity> queryEsBpDataCol(EsBpDataColEntity esBpDataColEntity) throws Exception {
        return esBpDataColDao.findByEntity(esBpDataColEntity);
    }

    @Override
    public void saveEsBpDataCol(EsBpDataColEntity esBpDataColEntity) throws Exception {
        esBpDataColDao.save(esBpDataColEntity);
    }

    @Override
    public void saveEsBpDataCol(List<EsBpDataColEntity> esBpDataColEntityList) throws Exception {
        for (EsBpDataColEntity esBpDataColEntity : esBpDataColEntityList) {
            esBpDataColDao.save(esBpDataColEntity);
        }
    }
}