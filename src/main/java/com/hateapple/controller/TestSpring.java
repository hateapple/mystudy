package com.hateapple.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("E:\\STUDY\\workspace\\mystudy\\src\\main\\webapp\\WEB-INF\\application.xml");
        MyBean bean = (MyBean)context.getBean("myBean");
        System.out.println(bean);
    }
}
