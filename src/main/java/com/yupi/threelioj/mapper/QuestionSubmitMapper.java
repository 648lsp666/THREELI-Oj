package com.yupi.threelioj.mapper;

import com.yupi.threelioj.model.entity.QuestionSubmit;

public interface QuestionSubmitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionSubmit record);

    int insertSelective(QuestionSubmit record);

    QuestionSubmit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionSubmit record);

    int updateByPrimaryKey(QuestionSubmit record);
}