package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.math;

import java.util.List;

public interface mathS extends IService<math> {

    Integer insert_mybatis(math math);

    math getbyid_mybatis(Integer id);

    List<math> get_hwx();

    List<Integer> math_row();
}
