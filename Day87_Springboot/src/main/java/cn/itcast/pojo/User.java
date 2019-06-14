package cn.itcast.pojo;

import lombok.Data;
import lombok.val;

import javax.persistence.*;

/**
 * @author NiYueYeee
 * @create 2019-06-04 19:47
 */
@val
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int age;

}
