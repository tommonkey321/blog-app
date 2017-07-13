/**
 * $Id: BpProcessJob.java,v 1.0 2016/9/29 9:48 haomeng Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.bp.job;

import com.tommonkey.common.bp.Constants;
import com.tommonkey.common.bp.entity.EsBpDataEntity;
import com.tommonkey.common.bp.service.interfaces.IEsBpDataSV;
import com.tommonkey.common.persistence.entity.Rank;
import com.tommonkey.common.quartz.DefaultQuartzJob;
import com.tommonkey.common.utils.CommConstants;
import com.tommonkey.utils.common.SpringContextHolder;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author haomeng
 * @version $Id: BpProcessJob.java,v 1.1 2016/9/29 9:48 haomeng Exp $
 *          Created on 2016/9/29 9:48
 *          bp后台任务，扫描待处理的bp入库数据
 */
public class BpProcessJob extends DefaultQuartzJob {

    private static final Logger logger = LoggerFactory.getLogger(BpProcessJob.class);

    @Override
    protected void doJob(JobExecutionContext jobContext) throws JobExecutionException {
        try {
            IEsBpDataSV esBpDataSV = SpringContextHolder.getBean(IEsBpDataSV.class);

            EsBpDataEntity esBpDataEntityQuery = new EsBpDataEntity();
            esBpDataEntityQuery.setState(Constants.FileState.WAIT_BUSINESS);
            Rank[] ranks = new Rank[2];
            ranks[0] = new Rank("priority");
            ranks[0].setRankType(CommConstants.OrderType.DESC);
            ranks[1] = new Rank("createDate");
            esBpDataEntityQuery.setRanks(ranks);
            List<EsBpDataEntity> esBpDataEntityList = esBpDataSV.queryEsBpData(esBpDataEntityQuery);
            esBpDataSV.processFiles(esBpDataEntityList);
        } catch (Exception e) {
            logger.error("批量业务，业务处理，任务处理失败！", e);
            throw new JobExecutionException(e);
        }
    }

}