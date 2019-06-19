package com.xxcep.demo.service.imp;

import static org.hamcrest.CoreMatchers.nullValue;

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
		User user = null;
//		user = userMapper.validUser(account, password);
		return user;
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
