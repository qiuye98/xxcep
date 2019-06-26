package com.xxcep.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xxcep.demo.entity.Courseware;
import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.impl.CoursewareServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

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
public class CoursewareController {
	
	@Autowired
	CoursewareServiceImpl coursewareServiceImpl;
	
	@GetMapping("/teacher/courseware")
	public String courseware(Model model,HttpServletRequest request) {
		return "teacher/courseware";
	}
	@GetMapping("/student/courseware")
	public String coursewareOfStudent(Model model,HttpServletRequest request) {
		return "student/courseware";
	}
	
	
	@RequestMapping(value = "/courseware-upload", method = RequestMethod.POST)
    public String handleCourseUpload(@RequestParam("coursewareFile") MultipartFile coursewareFile , HttpServletRequest httpServletRequest) {
		if (!coursewareFile.isEmpty()) {
			String name = coursewareFile.getOriginalFilename();
			if(name.contains(".txt"))
				readTxt(coursewareFile);
			long size = coursewareFile.getSize();
			System.out.println("   "+name+ "文件大小为："+ size + "byte.");
			try {
				Courseware courseware = new Courseware();
				courseware.setName(name);
				
				Blob blob = new SerialBlob(coursewareFile.getBytes());
				
				courseware.setFile(blob);
				
//				coursewareServiceImpl.uploadCourseware(courseware);
				System.out.println(coursewareServiceImpl.uploadCourseware(courseware));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		return "/teacher/courseware";
    }
	
	
	private void readTxt(MultipartFile coursewareFile) {
		try {
			InputStreamReader reader = new InputStreamReader(coursewareFile.getInputStream(),"UTF-8");
			BufferedReader br = new BufferedReader(reader);
			
			String line = null;
			while((line=br.readLine() )!= null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

