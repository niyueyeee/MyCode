package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.BeanFactory;

public class AccountServiceImpl implements AccountService {

    /*
       今天的终极操作
          对象我们不再new了
            而且属性设置操作   spring也帮忙完成
              那么 我们以后 声明变量的时候 右边就不用写内容了！！
     */
    private AccountDao accountDao;


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void init() {
        System.out.println("我是初始化方法");
    }

    public AccountServiceImpl() {
        System.out.println("我是构造~");
    }


    public void destroy() {
        System.out.println("我是销毁方法");
    }

    @Override
    public void saveAccount(Account account) {

//        accountDao.saveAccount(account);
    }
}
