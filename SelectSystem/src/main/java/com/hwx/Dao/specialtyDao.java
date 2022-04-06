package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.specialty;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface specialtyDao extends BaseMapper<specialty> {

    List<specialty> BynameGetsp(String name);

//    Integer  MyInsertspecialty(user user);

    List<String> GetSchoolSpecialty(@Param("schoolId") Integer schoolId,@Param("specialtyClass") Integer specialtyClass);


    Integer  update_Specialty(Integer id);
}
