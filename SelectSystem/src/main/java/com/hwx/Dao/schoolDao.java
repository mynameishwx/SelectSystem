package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.school;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface schoolDao extends BaseMapper<school> {

//    查询所有学校名称
    List<String> GetSchoolName();

     List<school>  Bynamegetschool(String schoolname);

}
