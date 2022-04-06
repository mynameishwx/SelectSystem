package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.enrollDao;
import com.hwx.Service.enrollS;
import com.hwx.join.enroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class enrollimpl extends ServiceImpl<enrollDao, enroll> implements enrollS {

    @Autowired
    private  enrollDao enrollDao;

    @Override
    public Integer insert_mybatis(enroll enroll) {
        return enrollDao.insert(enroll);
    }

    @Override
    public List<enroll> getByUserId_hwx(Integer userid) {
        return enrollDao.getByUserId_hwx(userid);
    }


}
