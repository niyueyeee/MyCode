package com.itheima.pojo;

import java.util.Date;

public class User {

    /**
     * `id` INT(11) NOT NULL AUTO_INCREMENT,
     * `username` VARCHAR(32) NOT NULL COMMENT '用户名称',
     * `sex` CHAR(1) DEFAULT NULL COMMENT '性别',
     * `birthday` DATE DEFAULT NULL COMMENT '生日',
     * `address` VARCHAR(256) DEFAULT NULL COMMENT '地址',
     */
    private Integer id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
