package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.uservolunteer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface uservolunteerDao extends BaseMapper<uservolunteer> {

    List<uservolunteer> getbyUserid_hwx(Integer id);

    List<Integer>  getUser_hwx();
}
