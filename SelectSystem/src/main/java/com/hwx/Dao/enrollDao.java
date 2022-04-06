package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.enroll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface enrollDao extends BaseMapper<enroll> {

    List<enroll>  getByUserId_hwx(Integer userid);


}
