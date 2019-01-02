package com.hateapple.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class QuartzJob01 implements  Job{
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(this.getClass().getSimpleName() + "开始执行！" + new Date());
    }

    public void executeJob(){
        System.out.println(this.getClass().getSimpleName() + "开始执行！");
    }
}
