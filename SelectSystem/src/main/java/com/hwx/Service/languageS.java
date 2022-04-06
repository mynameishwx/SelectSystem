package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.language;

public interface languageS extends IService<language> {

    Integer insert_mybatis(language language);

    language getbyid_mybatis(Integer id);
}
