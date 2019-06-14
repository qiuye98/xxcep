package com.xxcep.demo.service.impl;

import com.xxcep.demo.entity.Student;
import com.xxcep.demo.mapper.StudentMapper;
import com.xxcep.demo.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
