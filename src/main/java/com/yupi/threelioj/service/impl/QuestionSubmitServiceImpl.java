package com.yupi.threelioj.service.impl;

import com.yupi.threelioj.service.QuestionSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yupi.threelioj.mapper.QuestionSubmitMapper;
import com.yupi.threelioj.model.entity.QuestionSubmit;

@Service
public class QuestionSubmitServiceImpl implements QuestionSubmitService {

    @Resource
    private QuestionSubmitMapper questionSubmitMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return questionSubmitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(QuestionSubmit record) {
        return questionSubmitMapper.insert(record);
    }

    @Override
    public int insertSelective(QuestionSubmit record) {
        return questionSubmitMapper.insertSelective(record);
    }

    @Override
    public QuestionSubmit selectByPrimaryKey(Long id) {
        return questionSubmitMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(QuestionSubmit record) {
        return questionSubmitMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(QuestionSubmit record) {
        return questionSubmitMapper.updateByPrimaryKey(record);
    }

}
