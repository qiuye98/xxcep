package com.xxcep.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.imp.LoginServiceImp;


@Controller
public class HomeController {

	@Autowired
	LoginServiceImp loginServiceImp;
	
	@GetMapping("/login")
	public String login() {
		return "/";
	}
	
	@PostMapping("/login")
	public String login(Model model, String account, String password,HttpServletRequest request) {
		System.out.println(account+password);
		
		User user = null;
		user = loginServiceImp.ValidateUser(account, password);
		if (user == null) {
			return "index";
		}
		else {
			model.addAttribute("user",user);
			request.getSession(true).setAttribute("user",user);
			if (loginServiceImp.isTeacher(user.getUserId())) {
				return "redirect:/teacher/student-info";
			}else {
				return "student/homework";
			}
		}
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	

}