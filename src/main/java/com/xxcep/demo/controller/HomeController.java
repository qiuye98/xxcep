package com.xxcep.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.imp.LoginServiceImp;


@Controller
public class HomeController {

	@Autowired
	LoginServiceImp loginServiceImp;
	
	
	@GetMapping("/login")
	public String login(Model model, String account, String password) {
		
		List<User> users= loginServiceImp.findUsers();
		
		for (User user : users) {
			
			System.out.println(user.toString());
		}
		model.addAttribute("user",users.get(3));
		
//		return "student/homework";
		return "teacher/student_info";
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

}