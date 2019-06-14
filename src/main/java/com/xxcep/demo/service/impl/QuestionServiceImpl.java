package com.xxcep.demo.service.impl;

import com.xxcep.demo.entity.Question;
import com.xxcep.demo.mapper.QuestionMapper;
import com.xxcep.demo.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
