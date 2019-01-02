package com.hateapple.dao;

import com.hateapple.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Map> countPersonByAge(Map<String, String> param);
}