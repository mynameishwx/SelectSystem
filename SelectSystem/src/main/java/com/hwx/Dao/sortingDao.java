package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.sorting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface sortingDao extends BaseMapper<sorting> {
    Integer delete_uservolunteer();
    Integer delete_computer();
    Integer delete_performance();
    Integer delete_math();
    Integer delete_english();
    Integer delete_language();
    Integer delete_enroll();

    List<sorting> getrow_Math();

    List<sorting> getrow_Language();

}
