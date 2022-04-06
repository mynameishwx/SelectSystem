package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.uservolunteer;

import java.util.List;

public interface uservolunteerS extends IService<uservolunteer> {

//    插入(mybatis)
    Integer insert_mybatis(uservolunteer uservolunteer);

//    根据用户id查询专业信息
    List<uservolunteer> getbyUserid_hwx(Integer id);

//    获取报考专业的去重数据
    List<Integer>  getUser_hwx();
}
