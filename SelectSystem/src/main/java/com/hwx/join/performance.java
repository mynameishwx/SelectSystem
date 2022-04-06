package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("performance")
public class performance {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;

    @Column("userId")
    private  Integer userId;

    @Column("performanceScore")
    private Integer performanceScore;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
