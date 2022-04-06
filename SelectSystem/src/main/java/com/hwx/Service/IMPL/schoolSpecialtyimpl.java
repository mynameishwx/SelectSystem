package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.schoolSpecialtyDao;
import com.hwx.Service.schoolSpecialtyS;
import com.hwx.join.schoolSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class schoolSpecialtyimpl
        extends ServiceImpl<schoolSpecialtyDao,schoolSpecialty>
        implements schoolSpecialtyS {
    @Autowired
    private  schoolSpecialtyDao schoolSpecialtyDao;

    @Override
    public Integer insert_mybatis(schoolSpecialty schoolSpecialty){
        return  schoolSpecialtyDao.insert(schoolSpecialty);
    }

    @Override
    public List<schoolSpecialty> SPECIALTIES(Integer SpecialtyId) {
        return schoolSpecialtyDao.SPECIALTIES(SpecialtyId);
    }

}
