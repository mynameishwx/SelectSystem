package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userDao extends BaseMapper<user> {

    List<user> GetUserName(String userID);

    Integer  MyInsertUser(user user);

}
