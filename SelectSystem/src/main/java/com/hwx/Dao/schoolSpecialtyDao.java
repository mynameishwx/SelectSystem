package com.hwx.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.join.schoolSpecialty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface schoolSpecialtyDao extends BaseMapper<schoolSpecialty> {

    List<schoolSpecialty> SPECIALTIES(Integer SpecialtyId);

}
