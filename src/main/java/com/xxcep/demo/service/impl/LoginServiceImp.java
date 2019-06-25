package com.xxcep.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxcep.demo.entity.Teacher;
import com.xxcep.demo.entity.User;
import com.xxcep.demo.mapper.TeacherMapper;
import com.xxcep.demo.mapper.UserMapper;
import com.xxcep.demo.service.LoginService;

@Service
public class LoginServiceImp implements LoginService {
	
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Override
	public List<User> findUsers() {
		return userMapper.findAll();
	}
	
	@Override
	public User ValidateUser(String account, String password) {
		System.out.println(account+password);
		return userMapper.validUser(account, password);
	}
	
	

	@Override
	public boolean isTeacher(int userId) {
		Teacher teacher = null;
		teacher = teacherMapper.selectById(userId);
		
		if(teacher == null) {
			return false;
		}else {
			return true;
		}
		
	}
}
