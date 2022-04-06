package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.schoolDao;
import com.hwx.Service.SchoolS;
import com.hwx.join.school;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class schoolimpl extends ServiceImpl<schoolDao, school> implements SchoolS {
    @Autowired
    private  schoolDao schoolDao;

    @Override
    public List<String> getschoolName() {
        return schoolDao.GetSchoolName();
    }

    @Override
    public List<school> Bynamegetschool(String schoolname) {
        return schoolDao.Bynamegetschool(schoolname);
    }

    @Override
    public school getbyid(Integer id) {
        return schoolDao.selectById(id);
    }
}
