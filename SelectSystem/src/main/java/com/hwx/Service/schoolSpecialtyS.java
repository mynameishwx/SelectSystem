package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.schoolSpecialty;

import java.util.List;

public interface schoolSpecialtyS extends IService<schoolSpecialty>  {

    public Integer insert_mybatis(schoolSpecialty schoolSpecialty);

//    根据专业id查询学校
    List<schoolSpecialty> SPECIALTIES(Integer SpecialtyId);
}
