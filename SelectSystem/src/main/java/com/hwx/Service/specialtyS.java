package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.specialty;

import java.util.List;

public interface specialtyS extends IService<specialty> {

    Integer  insert(specialty specialty);

//    根据学校名查id
    List<specialty> BynameGetsp(String name);


//    根据学校名查该学校的专业，在挑选文理科
   List<String> GetSchoolSpecialty(Integer schoolId,Integer specialtyClass);


//   修改剩余录取人数
    Integer  update_Specialty(Integer id);
}
