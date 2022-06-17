package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserDao;

    @Override
    public ResultVo login(String username, String password) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> tbUsers = tbUserDao.selectByExample(tbUserExample);

        if (tbUsers.isEmpty()){

        }else {
            for (TbUser tbUser : tbUsers) {
                if (tbUser.getPassword() != null && !tbUser.getPassword().equals("") && tbUser.getPassword().equals(password)){
                    // 成功
                    return new ResultVo(200, "登录成功", true, tbUser);
                }
            }
        }
        // 失败
        return new ResultVo(0, "登录失败，用户名或密码错误", false, null);
    }

    @Override
    public Integer nick(String nick) {
        TbUserExample tbUserExample = new TbUserExample();

        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andNickEqualTo(nick);

        List<TbUser> tbUsers = tbUserDao.selectByExample(tbUserExample);

        return tbUsers.size();
    }

    @Override
    public ResultVo update(MultipartFile file, TbUser tbUser) {
        ResultVo resultVo = new ResultVo();
        if (file != null && !file.isEmpty()){
            // 准备路径
            String path = "C:/worker/apache-tomcat-8.5.37-windows-x64/server/apache-tomcat-8.5.37/webapps/upload";
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

            //Client client = Client.create();
            //连接服务器
            //WebResource resource = client.resource(path + filename);

            try {
                // 上传本地
                file.transferTo(new File(path,filename));
                // 推送文件到服务器上
                //resource.put(file.getBytes());

                // 如果上传成功，一定要把user中的头像给重新设置一下
                tbUser.setHead(filename);
            } catch (IOException e) {
                e.printStackTrace();

                resultVo.setCode(0);
                resultVo.setSuccess(false);
                resultVo.setMessage("头像上传失败");
                return resultVo;
            }
            tbUser.setHead("http://localhost:8081/upload/" + filename);
        }

        int affectedRows = tbUserDao.updateByPrimaryKeySelective(tbUser);

        if (affectedRows > 0) {
            resultVo.setCode(1);
            resultVo.setMessage("更新个人信息成功！");

            tbUser= tbUserDao.selectByPrimaryKey(tbUser.getId());

            resultVo.setData(tbUser);
        } else {
            resultVo.setMessage("头像上传成功，但是修改失败");
            resultVo.setCode(0);
            resultVo.setSuccess(false);
        }

        return resultVo;
    }
}
