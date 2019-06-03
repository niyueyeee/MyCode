package com.itheima.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {

    private Integer id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    private List<Orders> ordersList;

}
