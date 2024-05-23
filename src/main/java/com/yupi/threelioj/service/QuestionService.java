package com.yupi.threelioj.service;

import com.yupi.threelioj.model.entity.Question;

public interface QuestionService {


    int deleteByPrimaryKey(Long id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

}
