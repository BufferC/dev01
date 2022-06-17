package com.fc.controller;


import com.fc.service.FileService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping("uploadImg")
    public ResultVo upload(MultipartFile file){
        return fileService.upload(file);
    }

}
