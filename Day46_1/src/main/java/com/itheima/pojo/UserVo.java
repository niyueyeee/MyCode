package com.itheima.pojo;
/*
   这个  UserVo 包含一个pojo类型
       所以它是 pojo包装类
 */
public class UserVo {

    private int vid;

    private User user;

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserVo{" +
               "vid=" + vid +
               ", user=" + user +
               '}';
    }
}
