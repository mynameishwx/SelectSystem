package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.userDao;
import com.hwx.Service.userS;
import com.hwx.join.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class userimpl  extends ServiceImpl<userDao, user> implements  userS {

    @Autowired
    userDao userDao;

    public user  getUser_mybatis(Integer id){
        return userDao.selectById(id);

    }

    public  Integer  insert_user(user user){

        return userDao.insert(user);
    }

    @Override
    public List<user> GetUserName(String userID) {
        List<user> users=userDao.GetUserName(userID);
        if(users.size()==0){
            return  null;
        }else {
            return users;
        }
    }

    @Override
    public Integer MyInsertUser(user user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        return userDao.MyInsertUser(user);
    }
}
