package com.tommonkey.common.process.job;

import com.tommonkey.common.process.service.interfaces.ICfgTaskInsSV;
import com.tommonkey.common.quartz.DefaultQuartzJob;
import com.tommonkey.utils.common.SpringContextHolder;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by dizl on 2017/2/20.
 */
public class ProcessTaskJob extends DefaultQuartzJob {
    private final Logger logger = Logger.getLogger(ProcessTaskJob.class);
    @Override
    protected void doJob(JobExecutionContext jobContext) throws JobExecutionException {
        try {
            ICfgTaskInsSV taskInsSV = (ICfgTaskInsSV)SpringContextHolder.getBean(ICfgTaskInsSV.class);
            //处理已完成的任务
            taskInsSV.dealCompleteTask();
            //处理已过期的任务
            taskInsSV.dealExpireTask();
        }catch (Exception e){
            logger.error(e);
            throw new JobExecutionException(e.getMessage());
        }
    }
}
