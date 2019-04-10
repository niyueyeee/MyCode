package com.itheima.mapper;


import com.itheima.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-08 12:31
 */
@Mapper
public interface AccountMapper {
    public List<Account> queryAccountList();
}
