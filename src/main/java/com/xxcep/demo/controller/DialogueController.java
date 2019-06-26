package com.xxcep.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;

import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.impl.LoginServiceImp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
@Controller
public class DialogueController {
	@Autowired
	LoginServiceImp loginServiceImp;

	@GetMapping("/student/chat")
	public String schat(HttpServletRequest request) {
		return judgeUser((User) request.getSession().getAttribute("user"));
	}
	@GetMapping("/teacher/chat")
	public String tchat(HttpServletRequest request) {
		return judgeUser((User) request.getSession().getAttribute("user"));
	}
//	@GetMapping("/chat")
//	public String chat(Model model) {
//		return "student/chat";
//	}
	//根据身份分发页面
	public String judgeUser(User user) {
		if (loginServiceImp.isTeacher(user.getUserId())) {
			return "/teacher/chat";
		}else {
			return "/student/chat";
		}
	}
}

