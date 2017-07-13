package com.tommonkey.common.quartz.service.impl;

import com.tommonkey.common.quartz.dao.IQuartzJobLogDao;
import com.tommonkey.common.quartz.entity.CfgQuartzJobLogEntity;
import com.tommonkey.common.quartz.service.interfaces.IQuartzJobLogSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dizl on 2015/6/15.
 */
@Service
public class QuartzJobLogSVImpl implements IQuartzJobLogSV {
    @Autowired
    private IQuartzJobLogDao quartzJobLogDao;

    @Override
    public void saveQuartzJobLog(CfgQuartzJobLogEntity entity) throws Exception {
        if (entity != null) {
            quartzJobLogDao.save(entity);
        }
    }
}
