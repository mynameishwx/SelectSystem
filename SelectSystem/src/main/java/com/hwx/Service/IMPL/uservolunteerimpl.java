package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.uservolunteerDao;
import com.hwx.Service.uservolunteerS;
import com.hwx.join.uservolunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class uservolunteerimpl extends ServiceImpl<uservolunteerDao, uservolunteer>
        implements uservolunteerS {

    @Autowired
    private  uservolunteerDao uservolunteerDao;


    @Override
    public Integer insert_mybatis(uservolunteer uservolunteer) {
        return uservolunteerDao.insert(uservolunteer);
    }

    @Override
    public List<uservolunteer> getbyUserid_hwx(Integer id) {
        return uservolunteerDao.getbyUserid_hwx(id);
    }

    @Override
    public List<Integer> getUser_hwx() {
        return uservolunteerDao.getUser_hwx();
    }


}
