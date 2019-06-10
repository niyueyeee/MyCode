package com.itheima.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;

/**
 * @author NiYueYeee
 * @create 2019-06-09 18:10
 */
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer age ;
    private String username ;
    private String password ;
    private String email ;
    private String sex ;
}
