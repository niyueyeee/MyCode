package cn.itcast.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-03 20:08
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int age;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReceivingAddress> receivingAddressList =new ArrayList<>();


    public List<ReceivingAddress> getReceivingAddressList() {
        return receivingAddressList;
    }

    public void setReceivingAddressList(List<ReceivingAddress> receivingAddressList) {
        this.receivingAddressList = receivingAddressList;
    }

    public User() {
    }

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return "1+1";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
