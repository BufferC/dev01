package com.fc.realm;

import com.fc.service.LoginService;
import com.fc.service.impl.LoginServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

// 自定义realm需要继承自授权realm
public class CustomRealm extends AuthorizingRealm {
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取主要凭证，也就是用户名和密码
        String username = (String) token.getPrincipal();

        LoginService loginService = new LoginServiceImpl();

        String password = loginService.getPasswordByUsername(username);

        // 没有密码
        if (password == null || password.equals("") || !username.equals("易烊千玺")) {
            // 说明账号不存在
            throw new UnknownAccountException("当前用户不存在");
        } else if (!password.equals("123456")) {
            // 密码错误
            throw new IncorrectCredentialsException("密码错误");
        } else {
            // 就传递一个简单的认证信息对象，里面包含了用户名、密码、realm的名称
            return new SimpleAuthenticationInfo(username, password, getName());
        }
    }
}
