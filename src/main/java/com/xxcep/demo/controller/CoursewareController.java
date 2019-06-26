package com.xxcep.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xxcep.demo.entity.Courseware;
import com.xxcep.demo.entity.User;
import com.xxcep.demo.service.impl.CoursewareServiceImpl;
import com.xxcep.demo.service.impl.LoginServiceImp;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	String Location = "D:/work/webadv/xxcep/";
	
	@Autowired
	CoursewareServiceImpl coursewareServiceImpl;
	
	@Autowired
	LoginServiceImp loginServiceImp;
	
	
	//删除文件
	@RequestMapping(value = "/courseware/delete/{courseId}", method = RequestMethod.GET)
	public String deleteCourseware(@PathVariable("courseId") String courseId,Model model,HttpServletRequest request) {
		coursewareServiceImpl.deleteCoursewareById(Integer.parseInt(courseId));
		System.out.println(courseId);
		return index(model, request);
	}
	
	//下载文件
	@RequestMapping(value = "/courseware/download/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadCourseware(@PathVariable("courseId") int courseId,Model model,HttpServletRequest request) throws Exception {
		System.out.println(courseId);
		//指定要下载的文件所在路径
		String path = Location+coursewareServiceImpl.getDownloadCoursewarePathById(courseId);
		//创建该文件对象
		File file = new File(path);
		//对文件名编码，防止中文文件乱码
		String name  = this.getFilename(request, coursewareServiceImpl.getById(courseId).getName());
		//设置响应头
		HttpHeaders headers = new HttpHeaders();
		//通知浏览器以下载的方式打开文件
		headers.setContentDispositionFormData("attachment",name);
		//定义以流的形式下载返回文件数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//使用Spring MVC框架的ResponseEntity对象封装返回下载数据
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
	}
	//上传文件
	@RequestMapping(value = "/courseware-upload", method = RequestMethod.POST)
    public String handleCourseUpload(@RequestParam("coursewareFile") MultipartFile coursewareFile ,Model model, HttpServletRequest request) {
		if (!coursewareFile.isEmpty()) {
			//设置上传文件的保存地址目录
//			String dirPath = request.getServletContext().getRealPath("/upload/");
			String dirPath = "savedFile/courseware/";
			coursewareServiceImpl.uploadCoursewareFile(dirPath,coursewareFile);
		}
		return index(model, request);
    }
	
	
	//根据身份分发页面
	public String index(Model model,HttpServletRequest request) {
		List<Courseware> coursewares = coursewareServiceImpl.list();
		model.addAttribute("coursewares",coursewares);
		if (loginServiceImp.isTeacher(((User)request.getSession().getAttribute("user")).getUserId())) {
			return "/teacher/courseware";
		}else {
			return "/student/courseware";
		}
	}
	
	
	@GetMapping("/teacher/courseware")
	public String courseware(Model model,HttpServletRequest request) {
		return index(model, request);
	}
	
	@GetMapping("/student/courseware")
	public String coursewareOfStudent(Model model,HttpServletRequest request) {
		return index(model, request);
	}
	
	//处理浏览器字节编码
	public String getFilename(HttpServletRequest request,String filename) throws Exception {
        //IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE","Trident","Edge"};
        //获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for(String keyWord : IEBrowserKeyWords) {
            if(userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示
                return URLEncoder.encode(filename,"UTF-8");
            }
        }
        //火狐等其他浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
    }
//	private void readTxt(MultipartFile coursewareFile) {
//		try {
//			InputStreamReader reader = new InputStreamReader(coursewareFile.getInputStream(),"UTF-8");
//			BufferedReader br = new BufferedReader(reader);
//			
//			String line = null;
//			while((line=br.readLine() )!= null) {
//				System.out.println(line);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}

