package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.specialtyDao;
import com.hwx.Service.specialtyS;
import com.hwx.join.specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class Specialtyimpl extends ServiceImpl<specialtyDao, specialty> implements specialtyS {

    @Autowired
    private  specialtyDao specialtyDao;

    @Override
    public Integer insert(specialty specialty) {
        return specialtyDao.insert(specialty);
    }

    @Override
    public List<specialty> BynameGetsp(String name) {
        switch (1){
            case 1:;
            default:
        }
        return specialtyDao.BynameGetsp(name);
    }

    @Override
    public List<String> GetSchoolSpecialty(Integer schoolId, Integer specialtyClass) {
        List<String> strings=specialtyDao.GetSchoolSpecialty(schoolId,specialtyClass);

//        Iterator<String> iterator=strings.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        return  strings;
    }

    @Override
    public Integer update_Specialty(Integer id) {
        int  idr=id;
        return specialtyDao.update_Specialty(id);
    }

}
