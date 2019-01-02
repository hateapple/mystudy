package com.hateapple.quartz;

import org.quartz.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class QuartzManager implements BeanFactoryAware {

    private  Scheduler scheduler;
    public void addJob(Class jobClass, String jobName, String groupName) throws SchedulerException {
        JobDetail jobDetail =
                JobBuilder.newJob(jobClass).withIdentity(jobName, groupName).
                withDescription("增加调度任务").build();

        CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, groupName).
                startNow().withSchedule(builder).build();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public void deleteJob(String jobName, String groupName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, groupName);
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);
        scheduler.unscheduleJob(triggerKey);
        scheduler.deleteJob(jobKey);

    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        scheduler = (Scheduler)beanFactory.getBean("scheduler");
    }
}
