package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.school;

import java.util.List;

public interface SchoolS extends IService<school> {

     List<String>  getschoolName();


    List<school>  Bynamegetschool(String schoolname);


    school getbyid(Integer id);
}
