package com.hateapple.quartz;

import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzTest01 {
    public static void main(String[] args) throws SchedulerException {
        /*ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_quartz.xml");*/

        /*ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_quartz02.xml");*/

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_quartz03.xml");
        QuartzManager quartzManager =
                (QuartzManager)applicationContext.getBean("quartzManager");
        //quartzManager.addJob(QuartzJob01.class, "jobName01", "groupName01");
        quartzManager.deleteJob("jobName01", "groupName01");
    }
}
