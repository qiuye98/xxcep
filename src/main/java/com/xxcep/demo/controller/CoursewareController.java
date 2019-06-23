package com.xxcep.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;

import com.xxcep.demo.entity.User;

import javax.servlet.http.HttpServletRequest;

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
public class CoursewareController {
	
	@GetMapping("/teacher/course-ware")
	public String class_file(Model model,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("user",user);
		return "teacher/course-ware";
	}
}

