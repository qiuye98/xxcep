package com.xxcep.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/homework")
public class HomeworkController {

    @GetMapping("/student/detail")
    public String toStudentHomeworkDetail() {
        return "student/homework-detail";
    }

    @GetMapping("/teacher/homework")
    public String toStudentHome() {
        return "teacher/homework";
    }


    @GetMapping("/teacher/detail")
    public String toTeacherHomeworkDetail() {
        return "teacher/homework-detail";
    }


}

