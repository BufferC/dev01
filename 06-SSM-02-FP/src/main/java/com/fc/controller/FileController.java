package com.fc.controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("")
public class FileController {
    @RequestMapping("uploadImg")
    public void upload(MultipartFile upload){
        // 准备路径
        String path = "http://localhost:8081/upload/";
        File file = new File(path);
        // 路径不存在
        if (!file.exists()) {
            file.mkdirs();
        }
        // 获取文件名
        String filename = upload.getOriginalFilename();
        System.out.println(filename);
        //获取后缀名
        String suffix = filename.substring(filename.lastIndexOf("."));
        //格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String s = format.format(new Date());
        // 拼接成一个新的文件名
        filename = s + suffix;

        Client client = Client.create();
        //连接服务器
        WebResource resource = client.resource(path + filename);

        try {
            // 推送文件到服务器上
            resource.put(upload.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
