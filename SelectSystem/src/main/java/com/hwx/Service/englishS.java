package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.english;

import java.util.List;

public interface englishS extends IService<english> {

    Integer  insert_mybatis(english english);

    english getbyid_mybatis(Integer id);

    List<Integer>  get_hwx();

    List<english> getbyUserid(Integer userid);
 }
