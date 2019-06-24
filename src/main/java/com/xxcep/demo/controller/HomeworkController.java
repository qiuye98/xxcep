package com.xxcep.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
@Controller
public class HomeworkController {
	
	
	@GetMapping(value = "/student/homeworkDetail")
	public String toHomeworkDetail(Model model, String account, String password) {
		return "student/homework-detail";
	}
}

