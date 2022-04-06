package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.englishDao;
import com.hwx.Service.englishS;
import com.hwx.join.english;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class englishimpl extends ServiceImpl<englishDao, english> implements englishS {

    @Autowired
    private englishDao englishDao;
    @Override
    public Integer insert_mybatis(english english) {
        return englishDao.insert(english);
    }

    @Override
    public english getbyid_mybatis(Integer id) {
        return englishDao.selectById(id);
    }

    @Override
    public List<Integer> get_hwx() {
        return englishDao.get_hwx();
    }

    @Override
    public List<english> getbyUserid(Integer userid) {
        return englishDao.GetEnglishName(userid);
    }
}
