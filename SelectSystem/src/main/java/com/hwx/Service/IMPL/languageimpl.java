package com.hwx.Service.IMPL;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwx.Dao.languageDao;
import com.hwx.Service.languageS;
import com.hwx.join.language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class languageimpl extends ServiceImpl<languageDao, language> implements languageS {

    @Autowired
    private languageDao languageDao;

    @Override
    public Integer insert_mybatis(language language) {
        return languageDao.insert(language);
    }

    @Override
    public language getbyid_mybatis(Integer id) {
        return languageDao.selectById(id);
    }
}
