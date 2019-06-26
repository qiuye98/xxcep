package com.xxcep.demo.service.impl;

import com.xxcep.demo.entity.Courseware;
import com.xxcep.demo.mapper.CoursewareMapper;
import com.xxcep.demo.service.CoursewareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public String uploadCoursewareFile(String dirPath,MultipartFile coursewareFile) {
		//获得文件名
		String name = coursewareFile.getOriginalFilename(); 
		
		System.out.println(dirPath +" --  "+name);
		//目的文件目录
        File dir = new File(dirPath);
        //获得文件，没有就新建一个
        String path = dirPath+name;
		File toFile = new File(path);
//		System.out.println(toFile.getPath());
		//本地项目路径
		File location = new File("D:/work/webadv/xxcep");   
		
		//设置路径为本地项目下
        if (!toFile.isAbsolute()) {
        	toFile = new File(location, toFile.getPath());
        }
		try {
			//如果保存文件的地址目录不存在，就先创建
			if(!dir.exists()) {
				dir.mkdirs();
	        }
			if (!toFile.exists()) {
				toFile.createNewFile();
			}
			coursewareFile.transferTo(toFile);;
			this.insertNewCourseInfo(name,path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传成功";
	}

	public String getDownloadCoursewarePathById(int id) {
		return coursewareMapper.selectById(id).getCoursewarePath();
	}

	public void deleteCoursewareById(int id) {
		coursewareMapper.deleteById(id);
	}

	public List<Courseware> listCourseware() {
		
		return null;
	}
	//插入课件名和相对项目的路径
	public void insertNewCourseInfo(String name, String path) {
		coursewareMapper.insert(new Courseware(coursewareMapper.findMaxId()+1,name,path));
		System.out.println(coursewareMapper.findMaxId());
	}

}
