package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    ResultVo login(String username, String password);

    Integer nick(String nick);

    ResultVo update(MultipartFile img, TbUser user);
}
