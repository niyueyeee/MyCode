package com.itheima.mapper;

import com.itheima.pojo.Orders;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-30 20:28
 */
public interface OrdersMapper {
    @Select("select * from orders")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "number", property = "number"),
            @Result(column = "createtime", property = "createtime"),
            @Result(column = "note", property = "note"),
            @Result(property = "user", javaType = User.class, column = "user_id",
                    one = @One(select = "com.itheima.mappers.UserMapper.queryUserById", fetchType = FetchType.LAZY))
    })
    List<Orders> queryOrdersUser();

    @Select("select id,user_id userId,number,createtime,note from orders where user_id=#{user_id}")
    List<Orders> queryOrdersByUid(Integer userid);

}
