package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.user_roleDao;
import com.hwx.Service.user_roleS;
import com.hwx.join.power;
import com.hwx.join.user_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class user_roleimpl extends ServiceImpl<user_roleDao, user_role> implements user_roleS {

    @Autowired
    private  user_roleDao user_roleDao;

    @Override
    public List<power> getByUserId_hwx(Integer userid) {
        return user_roleDao.getByUserId(userid);
    }
}
