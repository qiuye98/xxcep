package com.xxcep.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxcep.demo.entity.User;
import com.xxcep.demo.mapper.UserMapper;
import com.xxcep.demo.service.LoginService;

@Service
public class LoginServiceImp implements LoginService {
	
	
	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> findUsers() {
		return userMapper.findAll();
	}
	
	@Override
	public User ValidateUser(String account, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public boolean isTeacher(int userId) {
		// TODO Auto-generated method stub
		return false;
	}
}
