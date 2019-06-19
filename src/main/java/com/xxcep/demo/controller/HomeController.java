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
		model.addAttribute("users",users);
		User user = null;
//		user = loginServiceImp.ValidateUser(account, password);
		user = users.get(1);
		if (user == null) {
			return "index";
		}
		else {
			model.addAttribute("user",user);
			if (loginServiceImp.isTeacher(user.getUserId())) {
				return "teacher/student_info";
			}else {
				return "student/homework";
			}
		}
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/class_file")
	public String class_file(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "teacher/class_file_info";
	}

}