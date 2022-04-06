package com.hwx.join;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;


@Data
@TableName("user")
public class user {

    @TableId(value = "id",type = IdType.AUTO)
    private  Integer  id;

    @Column("name")
    private  String  name;

    @Column("sex")
    private  Integer  sex;

    @Column("nameID")
    private  String  nameId;

    @Column("password")
    private  String  password;

    @Column("salt")
    private  String salt;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date  createTime;

    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
