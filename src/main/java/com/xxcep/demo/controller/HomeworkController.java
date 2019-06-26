package com.xxcep.demo.controller;


import com.xxcep.demo.entity.Homework;
import com.xxcep.demo.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Enumeration;

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

    @Autowired
    private HomeworkService homeworkService;

	@GetMapping("/student/homework")
    public String toStudentHomework() {
        return "student/homework";
    }
	
    @GetMapping("/student/detail")
    public String toStudentHomeworkDetail() {
        return "student/homework-detail";
    }

    @GetMapping("/teacher/homework")
    public String toStudentHome(Model model) {
	    model.addAttribute("homeworkList", homeworkService.list());
        return "teacher/homework";
    }


    @GetMapping("/teacher/detail")
    public String toTeacherHomeworkDetail() {
        return "teacher/homework-detail";
    }

    @PostMapping("/teacher/homework/add")
    public String addHomework(Model model, HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        Homework homework = new Homework();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        homework.setTitle(request.getParameter("title"));
        homework.setContent(request.getParameter("content"));
        homework.setBeginDate(LocalDate.parse("2018-02-28"));
        homework.setEndDate(LocalDate.parse("2018-02-28"));
        homework.setHomeworkId(homeworkService.count() + 1);
        homeworkService.save(homework);
        return "redirect:/teacher/homework";
    }
}

