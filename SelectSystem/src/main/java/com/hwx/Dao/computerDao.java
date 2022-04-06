package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.computer;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface computerDao extends BaseMapper<computer>{

    List<user> GetcomputerName(String userID);

    Integer  MyInsertcomputer(user user);
}
