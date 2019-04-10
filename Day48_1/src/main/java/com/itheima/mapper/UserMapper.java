package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user (username,sex,birthday,address) VALUES (#{username},#{sex},#{birthday},#{address})")
    void saveUser(User user);

    @Update("update user set username=#{username} where id=#{id}")
    void updateUsernameById(User user);

    @Delete("delete from user where id=#{id} ")
    void deleteUserById(Integer id);

    @Select("select * from user where id=#{id}")
    User queryUserById(Integer id);

    @Select("select * from user")
    List<User> queryUserList();

    @Select("<script>" +
            "select * from user " +
            "<where>" +
            "<if test=\"sex!=null and sex!=''\">" +
            "AND sex=#{sex}" +
            "</if>" +
            "<if test=\"username!=null and username!=''\">" +
            "AND username like #{username}" +
            "</if>" +
            "</where>" +
            "</script>")
    List<User> queryUserByWhere(User user);

    @Select("<script>" +
            " select * from user where id in\n" +
            " <foreach collection=\"list\" open=\"(\" close=\")\" separator=\",\" item=\"id\">" +
            "  #{id}" +
            "   </foreach>" +
            "</script>")
    List<User> queryUserByIds(List<Integer> list);

    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "address", property = "address"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "ordersList", javaType = List.class, column = "id",
                    many = @Many(select = "com.itheima.mapper.OrdersMapper.queryOrdersByUid", fetchType = FetchType.LAZY))
    })
    List<User> queryUserOrders();
}
