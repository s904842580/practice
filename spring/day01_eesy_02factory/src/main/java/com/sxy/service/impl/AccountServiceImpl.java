package com.sxy.service.impl;

import com.sxy.dao.AccountDao;
import com.sxy.dao.impl.AccountDaoImpl;
import com.sxy.service.AccountService;

/**
 * 账户的业务层实现层
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao =  new AccountDaoImpl();

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
