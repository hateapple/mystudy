package com.hateapple.quartz;

import org.quartz.*;
import org.quartz.impl.DirectSchedulerFactory;

import java.text.ParseException;

public class QuartzTest00 {
    public static void main(String[] args) throws SchedulerException, ParseException {
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob01.class).//设置业务实现类
                storeDurably(true).//是否持久化
                withDescription("任务描述").//任务描述
                requestRecovery(true).//是否可恢复执行
                withIdentity("myJobDetail","myJobDetail").//任务name,所在组,构建唯一主键
                build();

        //执行计划，多久执行一次，执行多少次。。。
        //SimpleScheduleBuilder / CronScheduleBuilder 二选一
        SimpleScheduleBuilder simpleScheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().
                        withIntervalInSeconds(10).
                        repeatForever();
        CronScheduleBuilder cronScheduleBuilder =
                CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");

        Trigger trigger = TriggerBuilder.newTrigger().
                withSchedule(simpleScheduleBuilder).//设置触发器的时间计划
                withDescription("trigger的简单描述").//触发器的描述
                withIdentity("myTrigger", "myTriggerGroup").//触发器唯一标识
                forJob(jobDetail).//绑定要触发的job
                startNow().
                build();

        DirectSchedulerFactory  schedulerFactory = DirectSchedulerFactory.getInstance();
        schedulerFactory.createVolatileScheduler(10);
        Scheduler scheduler = schedulerFactory.getScheduler();//调度器工厂生成调度器
        scheduler.scheduleJob(jobDetail, trigger);//将任务、触发器交给调度器,调度器将其绑定
        scheduler.start();
    }
}
