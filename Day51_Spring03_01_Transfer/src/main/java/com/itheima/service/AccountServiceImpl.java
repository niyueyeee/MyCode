package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.utils.TranscationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author niyueyeee
 * @create 2019-04-03 19:50
 */
@Repository("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;
    @Autowired
    @Qualifier("transcationManager")
    private TranscationManager transcationManager;
    /**
     * 实现转账业务
     *
     * @param fromName 汇款人
     * @param toName   收款人
     * @param money    转账金额
     * @throws Exception
     */
    @Override
    public void transfer(String fromName, String toName, Float money)
            throws Exception {


        try {
            transcationManager.begin();
            //业务逻辑代码
            // 查询 汇款人 收款人 账户信息
            Account fromAccount = accountDao.queryAccountByName(fromName);
            Account toAccount = accountDao.queryAccountByName(toName);
            // 完成计算 汇款人-money  收款人+money
            fromAccount.setMoney(fromAccount.getMoney() - money);
            toAccount.setMoney(toAccount.getMoney() + money);
            // 将数据进行更新
            accountDao.updateAccount(toAccount);
            accountDao.updateAccount(fromAccount);
            transcationManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transcationManager.rollback();
        } finally {
            transcationManager.close();
        }

    }


}
