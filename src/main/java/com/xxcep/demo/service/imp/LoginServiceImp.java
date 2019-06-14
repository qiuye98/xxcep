package com.xxcep.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.LoginService;

@Service
public class LoginServiceImp implements LoginService {
	
	

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
