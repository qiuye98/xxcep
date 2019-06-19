package com.xxcep.demo.service;

import java.util.List;

import com.xxcep.demo.entity.User;

public interface LoginService {
	
	public User ValidateUser(String account, String password) ;
	
	public boolean isTeacher(int userId);
	
	public List<User> findUsers() ;
}