package com.yupi.threelioj.service;

import com.yupi.threelioj.model.entity.QuestionSubmit;

public interface QuestionSubmitService {


    int deleteByPrimaryKey(Long id);

    int insert(QuestionSubmit record);

    int insertSelective(QuestionSubmit record);

    QuestionSubmit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionSubmit record);

    int updateByPrimaryKey(QuestionSubmit record);

}
