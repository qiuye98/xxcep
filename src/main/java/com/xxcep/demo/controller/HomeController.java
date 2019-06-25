package com.xxcep.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.impl.LoginServiceImp;


@Controller
public class HomeController {

	@Autowired
	LoginServiceImp loginServiceImp;
	
	@GetMapping("/login")//进入登录页面
	public String login(HttpServletRequest request) {
		User user =(User) request.getSession().getAttribute("user");
		if(user != null) {
			return judgeUser(user);
		}
		return "index";
	}
	
	@PostMapping("/login")//登录分发
	public String login(HttpServletRequest request,Model model, String account, String password) {
		System.out.println(account+password);
		
		User user = loginServiceImp.ValidateUser(account, password);
		if (user != null) {
			request.getSession(true).setAttribute("user", user);
			return judgeUser(user);
		}
		return "index";
	}
	
	@GetMapping("/logout")//登出
	public String logout(HttpServletRequest request) {
		request.getSession(true).removeAttribute("user");
		return "/";
	}

	@GetMapping("/")//默认连接
	public String index(HttpServletRequest request) {
		User user =(User) request.getSession().getAttribute("user");
		if(user != null) {
			return judgeUser(user);
		}else {
			return "index";
		}
	}
	
	public String judgeUser(User user) {
		if (loginServiceImp.isTeacher(user.getUserId())) {
			return "redirect:/teacher/student-info";
		}else {
			return "redirect:/student/homework";
		}
	}
	
}