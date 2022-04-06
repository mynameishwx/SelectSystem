package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("sorting")
public class sorting {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;

    @Column("userId")
    private Integer userId;

    @Column("userClass")
    private Integer userClass;

    @Column("userRow")
    private Integer userRow;

    @Column("specialtyClass")
    private  Integer specialtyClass;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
