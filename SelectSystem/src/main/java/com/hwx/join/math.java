package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("math")
public class math {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;

    @Column("userId")
    private  Integer userId;

    @Column("mathScore")
    private Integer mathScore;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
