package com.xxcep.demo.service.impl;

import com.xxcep.demo.entity.Courseware;
import com.xxcep.demo.mapper.CoursewareMapper;
import com.xxcep.demo.service.CoursewareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
@Service
public class CoursewareServiceImpl extends ServiceImpl<CoursewareMapper, Courseware> implements CoursewareService {

	@Autowired
	CoursewareMapper coursewareMapper;
	
	public String uploadCourseware(Courseware courseware) {
		coursewareMapper.insert(courseware);
		return "上传成功";
	}

	public String downloadCourseware() {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteCoursewareById() {
		// TODO Auto-generated method stub
		return null;
	}

	public String listCourseware() {
		// TODO Auto-generated method stub
		return null;
	}

}
