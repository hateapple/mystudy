package com.hateapple.controller;

import java.lang.reflect.Field;

public class TestInnerClass {
    private String name="jack";

    TestInnerClass(){
        System.out.println("我被初始化啦");
    }
    public void sayHello(){
        System.out.println("hello");
    }
     class InnerClass{
        public void innerSayHello(){
            System.out.println("inner hello");
        }
    }

    public static void main(String[] args) {
        TestInnerClass.InnerClass innerClass =
                new TestInnerClass().new InnerClass();
        TestInnerClass testInnerClass = new TestInnerClass();
        testInnerClass.new InnerClass();
/*
        InnerClass innerClass = new InnerClass();
*/
        Field[] fields = innerClass.getClass().getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName() + "-----------" + field.getType());
        }
    }
}
