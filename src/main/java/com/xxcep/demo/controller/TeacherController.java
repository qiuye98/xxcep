package com.xxcep.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.impl.LoginServiceImp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TeacherController {
	@Autowired
	LoginServiceImp loginServiceImp;
	
	
	@GetMapping("/teacher")
	public String teacher(Model model,HttpServletRequest request) {
		return index(model, request);
	}
	
	@GetMapping("/teacher/student-info")
	public String index(Model model,HttpServletRequest request) {
		List<User> users= loginServiceImp.findUsers();
		model.addAttribute("users",users);
//		for (User user : users) {
//			System.out.println(user.toString());
//		}
		
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("user",user);
		return "teacher/student-info";
	}

}

