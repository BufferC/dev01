package com.fc.service.impl;

import com.fc.service.FileService;
import com.fc.vo.ResultVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
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
    public ResultVo upload(MultipartFile file) {
        // 准备路径
        String path = "http://localhost:8081/upload/";
        File filess = new File(path);
        // 路径不存在
        if (!filess.exists()) {
            //多级
            filess.mkdirs();
        }
        // 获取文件名
        String filename = file.getOriginalFilename();

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
            // 上传本地
            //file.transferTo(new File(path, filename));
            // 推送文件到服务器上
            resource.put(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        filename = path+filename;
        map.put("imgurl",filename);
        return new ResultVo("成功",map,true,200);
    }
}
