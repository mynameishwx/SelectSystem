package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.user;

import java.util.List;

public interface userS extends IService<user> {

//    根据昵称查找用户
    List<user> GetUserName(String userID);

//    自己插入的方法
    Integer  MyInsertUser(user user);

}
