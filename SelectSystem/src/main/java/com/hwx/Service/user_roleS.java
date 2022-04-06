package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.power;
import com.hwx.join.user_role;

import java.util.List;

public interface user_roleS extends IService<user_role> {

    List<power> getByUserId_hwx(Integer userid);
}
