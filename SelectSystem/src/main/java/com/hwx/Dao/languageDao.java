package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.language;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface languageDao extends BaseMapper<language> {

    List<user> GetlanguageName(String userID);

    Integer  MyInsertlanguage(user user);
}
