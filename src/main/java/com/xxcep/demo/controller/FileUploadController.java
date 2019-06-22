package com.xxcep.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FileUploadController {
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("filename") List<MultipartFile> uploadfiles
            , HttpServletRequest httpServletRequest) {

        if (!uploadfiles.isEmpty() && uploadfiles.size() > 0) {
            for (MultipartFile uploadfile : uploadfiles) {
                String originFilename = uploadfile.getOriginalFilename();
                String dirPath = httpServletRequest.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                String newFilename = "_"
                        + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                        + "_" + originFilename;
                try {
                    uploadfile.transferTo(new File(dirPath + newFilename));
                    System.out.println(dirPath + newFilename);
                } catch (IOException e) {
                    e.printStackTrace();
                    //跳转到失败页面
                    return "student/homework";
                }
            }
            //跳转到成功页面
            return "student/homework-detail";
        }
        //跳转到失败页面
        return "student/homework";
    }

    @RequestMapping(value = "markdownImgUpload", method = RequestMethod.POST)
    public void hello(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "text/html");
//            response.setCharacterEncoding("UTF-8");
            String rootPath = request.getSession().getServletContext().getRealPath("/statics/upload/");
            /**
             * 文件路径不存在则需要创建文件路径
             */
            File filePath = new File(rootPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            //最终文件名
            File realFile = new File(rootPath + File.separator + attach.getOriginalFilename());
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.getWriter().write("{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/statics/upload/" + attach.getOriginalFilename() + "\"}");
        } catch (Exception e) {
            try {
                response.getWriter().write("{\"success\":0}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
