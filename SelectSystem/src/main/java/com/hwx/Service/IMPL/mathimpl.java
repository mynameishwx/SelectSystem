package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.mathDao;
import com.hwx.Service.mathS;
import com.hwx.join.math;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mathimpl extends ServiceImpl<mathDao, math> implements mathS {

    @Autowired
    private mathDao mathDao;

    @Override
    public Integer insert_mybatis(math math) {
        return mathDao.insert(math);
    }

    @Override
    public math getbyid_mybatis(Integer id) {
        return mathDao.selectById(id);
    }

    @Override
    public List<math> get_hwx() {
        return mathDao.get_hwx();
    }

    @Override
    public List<Integer> math_row() {
        return mathDao.math_row();
    }
}
