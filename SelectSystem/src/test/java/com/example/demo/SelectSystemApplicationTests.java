package com.example.demo;

import com.hwx.Dao.enrollDao;
import com.hwx.SelectSystemApplication;
import com.hwx.Service.IMPL.adminIMPL;
import com.hwx.Service.enrollS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SelectSystemApplication.class)
class SelectSystemApplicationTests {

    @Autowired
    private adminIMPL adminIMPL;

    @Test
    void contextLoads() {
       int x=  adminIMPL.Stop();

    }

}
