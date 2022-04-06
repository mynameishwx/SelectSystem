package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.performance;

import java.util.List;

public interface performanceS extends IService<performance> {

    Integer insert_mybatis(performance performance);

    performance getbyid_mybatis(Integer id);

    List<performance> get_hwx();
}
