package com.fc.service;

import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResultVo upload(MultipartFile file);
}
