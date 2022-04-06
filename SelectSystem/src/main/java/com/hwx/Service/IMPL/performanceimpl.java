package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.performanceDao;
import com.hwx.Service.performanceS;
import com.hwx.join.performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class performanceimpl extends ServiceImpl<performanceDao, performance>implements performanceS {

    @Autowired
    private performanceDao performanceDao;

    @Override
    public Integer insert_mybatis(performance performance) {
        return performanceDao.insert(performance);
    }

    @Override
    public performance getbyid_mybatis(Integer id) {
        return performanceDao.selectById(id);
    }

    @Override
    public List<performance> get_hwx() {
        return performanceDao.get_hwx();
    }


}
