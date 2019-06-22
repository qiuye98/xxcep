package com.xxcep.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	
	@GetMapping("/login")
	public String login(Model model, String account, String password) {
		return "student/homework";
	}

	@GetMapping(value = "/homeworkDetail")
	public String toHomeworkDetail(Model model, String account, String password) {
		return "student/homework-detail";
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

}