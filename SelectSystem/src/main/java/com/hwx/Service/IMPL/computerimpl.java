package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.computerDao;
import com.hwx.Service.computerS;
import com.hwx.join.computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class computerimpl extends ServiceImpl<computerDao,computer> implements computerS {

    @Autowired
    private computerDao computerDao;

    @Override
    public Integer insert_mybatis(computer computer) {

        return computerDao.insert(computer);
    }

    @Override
    public computer getbiid_mybatis(Integer id) {
        return computerDao.selectById(id);
    }
}
