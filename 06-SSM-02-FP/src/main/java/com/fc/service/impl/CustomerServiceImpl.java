package com.fc.service.impl;

import com.fc.dao.CustomerMapper;
import com.fc.service.CustomerService;
import com.fc.util.JwtUtil;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ResultVo login(String username, String password) {
        int id = customerMapper.findLogin(username,password);
        ResultVo resultVo;
        if (id == 0) {
            resultVo = new ResultVo("登录失败...",null,false,-1);
        } else {
            Map<String, Object> claim = new HashMap<>();

            claim.put("username", username);
            claim.put("id", id);

            String token = JwtUtil.getToken(claim);

            resultVo = new ResultVo("登录成功...",token,true,200);
        }
        return resultVo;
    }

    @Override
    public Map<String, Object> verify(String token) {
        Map<String, Object> verify = JwtUtil.verify(token);
        return verify;
    }
}
