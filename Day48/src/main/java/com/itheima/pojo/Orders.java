package com.itheima.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private Integer id;
    private Integer userId;//但是这样写不符合java中的规范！！驼峰命名法userId
    private String number;
    private Date createtime;
    private String note;
    private User user;
}
