package com.yupi.threelioj.service.impl;

import com.yupi.threelioj.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yupi.threelioj.mapper.QuestionMapper;
import com.yupi.threelioj.model.entity.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Question record) {
        return questionMapper.insert(record);
    }

    @Override
    public int insertSelective(Question record) {
        return questionMapper.insertSelective(record);
    }

    @Override
    public Question selectByPrimaryKey(Long id) {
        return questionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Question record) {
        return questionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Question record) {
        return questionMapper.updateByPrimaryKey(record);
    }

}
