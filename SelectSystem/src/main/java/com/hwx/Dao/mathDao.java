package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.math;
import com.hwx.join.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface mathDao extends BaseMapper<math> {

    List<user> GetMathName(String userID);

    Integer  MyInsertMath(user user);

    List<math> get_hwx();

    List<Integer> math_row();
}
