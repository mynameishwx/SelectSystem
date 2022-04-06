package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.english;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface englishDao extends BaseMapper<english> {

    List<english> GetEnglishName(Integer userID);

    Integer  MyInsertEnglish(user user);

    List<Integer> get_hwx();




}
