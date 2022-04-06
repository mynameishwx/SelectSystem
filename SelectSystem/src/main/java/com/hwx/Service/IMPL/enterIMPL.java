package com.hwx.Service.IMPL;

import com.hwx.join.user;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class enterIMPL {

//密码MD5加密
    public user  MyMD5(user user){
        String url=")(*79&^863248%$5#@WECLO142DK8757F";
        Random random=new Random();
        int x=random.nextInt(32);
        String salt=url.substring(x,x+1);
        Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1125);
        user.setPassword(md5Hash.toHex());
        user.setSalt(salt);
        return user;
    }

}