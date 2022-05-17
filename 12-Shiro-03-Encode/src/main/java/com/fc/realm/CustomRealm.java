package com.fc.realm;

import com.fc.service.LoginService;
import com.fc.service.impl.LoginServiceImpl;
import com.fc.util.HashUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Map;

public class CustomRealm extends AuthorizingRealm {
    public CustomRealm() {
        // 哈希凭证匹配器
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置算法的名称
        matcher.setHashAlgorithmName(HashUtil.ALGORITHM_NAME);
        // 设置散列的次数
        matcher.setHashIterations(HashUtil.HASH_ITERATIONS);
        // 替换掉原本的凭证匹配器
        setCredentialsMatcher(matcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();

        LoginService service = new LoginServiceImpl();

        Map<String, String> credential = service.getPasswordByUsername(username);

        if (credential == null || credential.isEmpty() || !username.equals("易烊千玺")) {
            throw new  UnknownAccountException("当前账号不存在");
        }

        String password = credential.get("password");
        String salt = credential.get("salt");

        // 返回用户名、加密后的密码、盐值就行了
        return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), getName());
    }
}
