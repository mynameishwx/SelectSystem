package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("enroll")
public class enroll {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer  id;

    @Column(value = "user_id")
    private  Integer  userId;

    @Column(value = "specialty_Id")
    private  Integer specialtyId;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
