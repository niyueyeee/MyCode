package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * @author niyueyeee
 * @create 2019-04-06 19:50
 */
public interface AccountDao {
    //根据用户名 查询账户信息
    Account queryAccountByName(String name) throws Exception;

    // 更新 账户的 金额 根据id
    void updateAccountById(Account account) throws Exception;
}
