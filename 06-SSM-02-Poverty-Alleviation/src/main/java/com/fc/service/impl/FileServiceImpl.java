package com.fc.service.impl;

import com.fc.service.FileService;
import com.fc.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public ResultVO fileUpload(MultipartFile file, String type) {
        // 上传的路径
        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload/Poverty-Alleviation/" + type;

        File pathFile = new File(path);

        // 如果指定的路径不存在
        if (!pathFile.exists()) {
            // 创建多级路径
            pathFile.mkdirs();
        }

        // 获取文件名
        String filename = file.getOriginalFilename();

        // 获取格式化器
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        // 获取格式化之后的日期时间字符串
        String formatDate = formatter.format(new Date());

        // 获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        // 获取新的文件名
        filename = formatDate + suffix;

        ResultVO vo = new ResultVO();

        try {
            // 文件上传操作
            file.transferTo(new File(pathFile, filename));

            vo.setMessage("上传成功！！！");
            vo.setCode(200);
            vo.setSuccess(true);

            Map<String, Object> map = new HashMap<>();
            map.put("imgurl", "http://localhost:8081/upload/Poverty-Alleviation/" + type + "/" + filename);

            vo.setData(map);
        } catch (IOException e) {
            e.printStackTrace();

            vo.setMessage("上传失败！！！");
            vo.setCode(-2000);
            vo.setSuccess(false);
        }

        return vo;
    }
}
