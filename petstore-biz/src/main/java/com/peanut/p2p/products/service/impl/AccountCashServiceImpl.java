package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.AccountCashDao;
import com.peanut.p2p.products.model.entity.AccountCash;
import com.peanut.p2p.products.service.AccountCashService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("accountCashService")
public class AccountCashServiceImpl implements AccountCashService {

    @Resource
    private AccountCashDao accountCashDao;
    @Override
    public List<AccountCash>queryAll(){return  accountCashDao.findAll(AccountCash.class);}
    @Override
    public AccountCash queryByID(Integer id) {
        return accountCashDao.findById(AccountCash.class,id);
    }

    @Override
    public void doSave(AccountCash accountRecharge) {
        accountCashDao.save(accountRecharge);
    }

    @Override
    public void doUpdate(AccountCash accountRecharge) {
        accountCashDao.update(accountRecharge);
    }

    @Override
    public void doDelete(Integer id) {
        AccountCash riskinfo = accountCashDao.findById(AccountCash.class,id);
        accountCashDao.delete(riskinfo);
    }

}
