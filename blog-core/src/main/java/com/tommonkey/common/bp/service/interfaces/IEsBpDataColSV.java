package com.tommonkey.common.bp.service.interfaces;

import com.tommonkey.common.bp.entity.EsBpDataColEntity;

import java.util.List;

public interface IEsBpDataColSV {
    public List<EsBpDataColEntity> queryEsBpDataCol(EsBpDataColEntity esBpDataColEntity) throws Exception;

    public void saveEsBpDataCol(EsBpDataColEntity esBpDataColEntity) throws Exception;

    public void saveEsBpDataCol(List<EsBpDataColEntity> esBpDataColEntityList) throws Exception;
}