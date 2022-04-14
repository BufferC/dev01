package com.fc.service;

import com.fc.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResultVO fileUpload(MultipartFile file, String type);
}
