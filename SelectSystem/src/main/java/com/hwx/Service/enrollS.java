package com.hwx.Service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.enroll;

import java.util.List;

public interface enrollS extends IService<enroll> {

    Integer  insert_mybatis(enroll enroll);

    List<enroll> getByUserId_hwx(Integer userid);


}
