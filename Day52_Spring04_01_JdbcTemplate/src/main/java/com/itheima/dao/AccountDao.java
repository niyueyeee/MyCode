package com.itheima.dao;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-06 19:50
 */
public interface AccountDao {
    Account queryAccountById(Integer id)throws Exception;

    List<Account> queryAccountByList() throws Exception;
}
