package com.itheima.pojo;

import java.util.List;
import java.util.Map;

/**
 * @author niyueyeee
 * @create 2019-04-07 21:59
 */
public class UserVo {

    private Integer vid;
    private User user;

    private List<User> userList;

    private Map<String, User> userMap;

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(
            Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
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

