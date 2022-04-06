package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("power")
public class power {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer  id;

    @Column("name")
    private  String  name;

    @Column("powerurl")
    private  String powerurl;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
