package com.itheima.pojo;

import java.util.Date;

/**
 * `id` INT(11) NOT NULL AUTO_INCREMENT,
 * `user_id` INT(11) NOT NULL COMMENT '下单用户id',
 * `number` VARCHAR(32) NOT NULL COMMENT '订单号',
 * `createtime` DATETIME NOT NULL COMMENT '创建订单时间',
 * `note` VARCH
 */
public class Orders {
    private Integer id;
    private Integer userId;//但是这样写不符合java中的规范！！驼峰命名法userId
    private String number;
    private Date createtime;
    private String note;

    private User user;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
