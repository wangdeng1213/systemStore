package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.AccountRechargeDao;
import com.peanut.p2p.products.model.entity.AccountRecharge;
import com.peanut.p2p.products.service.AccountRechargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("accountRechargeService")
public class AccountRechargeServiceImpl implements AccountRechargeService {

    @Resource
    private AccountRechargeDao accountRechargeDao;
    @Override
    public List<AccountRecharge>queryAll(){return  accountRechargeDao.findAll(AccountRecharge.class);}
    @Override
    public AccountRecharge queryByID(Integer id) {
        return accountRechargeDao.findById(AccountRecharge.class,id);
    }

    @Override
    public void doSave(AccountRecharge accountRecharge) {
        accountRechargeDao.save(accountRecharge);
    }

    @Override
    public void doUpdate(AccountRecharge accountRecharge) {
        accountRechargeDao.update(accountRecharge);
    }

    @Override
    public void doDelete(Integer id) {
        AccountRecharge riskinfo = accountRechargeDao.findById(AccountRecharge.class,id);
        accountRechargeDao.delete(riskinfo);
    }

}
