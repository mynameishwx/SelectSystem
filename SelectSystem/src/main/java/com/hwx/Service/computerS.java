package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.computer;

public interface computerS extends IService<computer> {


    Integer  insert_mybatis(computer computer);

    computer getbiid_mybatis(Integer id);
}
