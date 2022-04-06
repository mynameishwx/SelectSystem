package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("school")
public class school {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer  id;

    @Column("school_Name")
    private  String  schoolName;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private  Date  updateTime;

}
