package com.hwx.Comp;

import com.hwx.Service.userS;
import com.hwx.Service.user_roleS;
import com.hwx.join.power;
import com.hwx.join.user;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class Myrealm extends AuthorizingRealm {

    @Autowired
    private userS userS;

    @Autowired
    private HostHand hostHand;

    @Autowired
    private user_roleS user_roleS;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        user user=hostHand.getuser();
        List<power> powerList=user_roleS.getByUserId_hwx(user.getId());
        Iterator<power> iterator=powerList.iterator();
        while (iterator.hasNext()){
            String  url=iterator.next().getPowerurl();
            simpleAuthorizationInfo.addStringPermission(url);
            System.out.println("用户添加了:" + url+"权限");
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        String  name= (String) token.getPrincipal();
        List<user> userList=userS.GetUserName(name);
        Iterator<user> iterator=userList.iterator();
        user user=iterator.next();
        return new SimpleAuthenticationInfo(
                name,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
    }
}
