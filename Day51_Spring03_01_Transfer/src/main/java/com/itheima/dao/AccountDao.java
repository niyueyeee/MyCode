package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * @author niyueyeee
 * @create 2019-04-03 19:44
 */
public interface AccountDao {
    // 根据用户名 查询账户信息
    Account queryAccountByName(String name) throws Exception;

    // 更新账户信息
    void updateAccount(Account account) throws Exception;
}
