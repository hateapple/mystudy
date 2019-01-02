package com.hateapple.controller;

import com.alibaba.fastjson.JSONObject;
import com.hateapple.dao.PersonMapper;
import com.hateapple.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class MyController {
    @Autowired
    private MyBean myBean;
    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/sayHello")
    @ResponseBody
    public void sayHello(){
        myBean.setBeanName("myBean");
    }

    @RequestMapping("/countPersonByAge")
    @ResponseBody
    public String countPersonByAge(){
        Map<String,String> param = new HashMap<String, String>();
        param.put("add", "1");

        List<Map> list = personMapper.countPersonByAge(param);
        return JSONObject.toJSONString(list);
    }

    @RequestMapping("/person")
    @ResponseBody
    public String person(){

        Person person = personMapper.selectByPrimaryKey(1);
        return JSONObject.toJSONString(person);
    }
}
