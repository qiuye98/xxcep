package com.xxcep.demo.controller;

import com.xxcep.demo.exception.StorageFileNotFoundException;
import com.xxcep.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;



@Controller
public class GFileUploadController {

    private final StorageService storageService;

    @Autowired
    public GFileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/GFile")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(
                path -> {

                    return MvcUriComponentsBuilder.fromMethodName(GFileUploadController.class,
                            "serveFile", path.getFileName().toString()).build().toString();})
                .collect(Collectors.toList()));

        return "teacher/display";
    }

    @GetMapping("/student/file")
    public String listUploadedFilesStudent(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(
                path -> {
                    return MvcUriComponentsBuilder.fromMethodName(GFileUploadController.class,
                            "serveFile", path.getFileName().toString()).build().toString();})
                .collect(Collectors.toList()));

        return "student/display";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/files/delete")
    public String deleteFile() {
        storageService.deleteAll();
        return "redirect:/";
    }

    @PostMapping("/GFile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "上传文件成功： " + file.getOriginalFilename() + "!");

        return "redirect:/GFile";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}