package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.performance;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface performanceDao extends BaseMapper<performance> {

    List<user> GetperformanceName(String userID);

    Integer  MyInsertperformance(user user);

    List<performance> get_hwx();
}
