package com.fc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUploadUtil {
    public static String fileUpload(MultipartFile file) {
        // 准备路径
        String path = "D:\\server\\apache-tomcat-8.5.37\\webapps\\upload";

        File locationFile = new File(path);

        // 路径不存在就创建一个
        if (!locationFile.exists()) {
            locationFile.mkdirs();
        }

        String filename = file.getOriginalFilename();

        // 获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        String prefix = formatter.format(new Date());

        filename = prefix + suffix;

        try {
            file.transferTo(new File(locationFile, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "http://localhost:8081/upload/" + filename;
    }
}
