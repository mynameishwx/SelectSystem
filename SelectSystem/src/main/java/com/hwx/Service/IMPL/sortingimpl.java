package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.sortingDao;
import com.hwx.Service.sortingS;
import com.hwx.join.sorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sortingimpl extends ServiceImpl<sortingDao, sorting> implements sortingS {

    @Autowired
    private sortingDao sortingDao;


    @Override
    public List<sorting> getrow_math() {
        return sortingDao.getrow_Math();
    }

    @Override
    public List<sorting> getrow_Language() {
        return sortingDao.getrow_Language();
    }

    @Override
    public Integer delete_hwx(Integer dj) {
       if(dj==1){
           sortingDao.delete_uservolunteer();
           sortingDao.delete_computer();
           sortingDao.delete_math();
           sortingDao.delete_language();
           sortingDao.delete_performance();
           sortingDao.delete_english();
           return  1;
       }else {
           sortingDao.delete_enroll();
           return 1;
       }
    }

}
