package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("specialty")
public class specialty {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer  id;

    @Column("name")
    private  String  name;

    @Column("specialtyclass")
    private Integer specialtyclass;

    @Column("admitscore")
    private Integer  admitscore;

    @Column("admitamount")
    private  Integer admitamount;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date  createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private  Date  updateTime;
}
