package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.BankCardDao;
import com.peanut.p2p.code.model.entity.BankCard;
import com.peanut.p2p.code.service.BankCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by my on 2015/5/6.
 */
@Service("bankCardService")
public class BankCardServiceImpl implements BankCardService{

    @Resource
    private BankCardDao bankCardDao;

    @Override
    public BankCard queryByID(long id) {
        return bankCardDao.findById(BankCard.class,id);
    }

    @Override
    public void doSave(BankCard BankCard) {
        bankCardDao.save(BankCard);
    }

    @Override
    public void doUpdate(BankCard BankCard) {
        bankCardDao.update(BankCard);
    }

    @Override
    public void doUpdate(Integer id) {
        bankCardDao.update(id);
    }

    @Override
    public void doDelete(long id) {
        BankCard bankCard = queryByID(id);
        bankCardDao.delete(bankCard);
    }
}
