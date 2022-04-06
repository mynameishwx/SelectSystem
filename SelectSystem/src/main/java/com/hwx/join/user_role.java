package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
@TableName("user_role")
public class user_role {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer  id;

    @Column("userid")
    private  Integer  userid;

    @Column("roleid")
    private  Integer roleid;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
