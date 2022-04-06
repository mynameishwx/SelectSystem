package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.power;
import com.hwx.join.user_role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface user_roleDao extends BaseMapper<user_role> {

    List<power>  getByUserId(Integer id);

}
