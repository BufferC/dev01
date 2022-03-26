package com.fc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    public ModelAndView upload(MultipartFile upload, ModelAndView mv) {
        // 准备路径
        String path = "http://localhost:8081/upload/";

        // 获取文件名
        String filename = upload.getOriginalFilename();

        // 获取后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        String format = formatter.format(new Date());

        // 拼接成一个新的文件名
        filename = format + suffix;

        Client client = Client.create();

        // 连接服务器
        WebResource resource = client.resource(path + filename);

        try {
            // 推送文件到服务器上
            resource.put(upload.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        mv.addObject("img", "http://localhost:8081/upload/" + filename);

        mv.setViewName("/success.jsp");

        return mv;
    }
}
