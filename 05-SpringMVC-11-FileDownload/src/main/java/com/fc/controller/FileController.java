package com.fc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("toDownload")
    public String toDownload(Model model) {
        model.addAttribute("img", "001.jpg");

        return "/index.jsp";
    }

    @RequestMapping("download")
    public void download(String filename, HttpServletResponse response) {
        // 下载的路径
        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";

        File file = new File(path, filename);

        // 声明我们要进行下载了
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        ServletOutputStream outputStream = null;
        BufferedInputStream inputStream = null;
        try {
            outputStream =response.getOutputStream();
            inputStream =new BufferedInputStream(new FileInputStream(file));

            // 缓冲区
            byte[] buffer = new byte[1024 * 8];

            // 没有读到文件的末尾
            while (inputStream.read(buffer) != -1) {
                // 写入数据
                outputStream.write(buffer);

                // 刷新
                outputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 通过SpringMVC的方式进行文件下载
    @RequestMapping("download2")
    public ResponseEntity<byte[]> download2(String filename) throws IOException {
        // 下载的路径
        String path = "D:/server/apache-tomcat-8.5.37/webapps/upload";

        File file = new File(path, filename);

        HttpHeaders headers = new HttpHeaders();

        // 内容类型使用八进制流
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // 设置内容安排的附件以及文件名
        headers.setContentDispositionFormData("attachment", filename);

        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}
