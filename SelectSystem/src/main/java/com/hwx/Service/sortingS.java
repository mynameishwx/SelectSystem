package com.hwx.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwx.join.sorting;

import java.util.List;

public interface sortingS extends IService<sorting> {

    List<sorting> getrow_math();

    List<sorting> getrow_Language();

    Integer delete_hwx(Integer dj);
}
