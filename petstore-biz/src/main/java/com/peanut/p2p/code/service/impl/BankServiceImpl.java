package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.BankDao;
import com.peanut.p2p.code.dao.PicDao;
import com.peanut.p2p.code.model.entity.Bank;
import com.peanut.p2p.code.model.entity.Pic;
import com.peanut.p2p.code.service.BankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by my on 2015/3/18.
 */
@Service("bankService")
public class BankServiceImpl implements BankService{

    @Resource
    private BankDao  bankDao;
    @Resource
    private PicDao picDao;
    @Override
    public List<Bank> queryAll() {
        return bankDao.findAll(Bank.class);
    }

    @Override
    public Bank queryByID(Integer id) {
        return bankDao.findById(Bank.class,id);
    }

    @Override
    @Transactional
    public void doSave(Pic pic,Bank bank) {
        picDao.save(pic);
        bank.setPicId(pic.getId());
        bankDao.save(bank);
    }

    @Override
    @Transactional
    public void doUpdate(Pic pic,Bank bank) {
        picDao.update(pic);
        bankDao.update(bank);
    }
    @Override
    @Transactional
    public void doDelete(Integer id) {
       Bank bank = bankDao.findById(Bank.class,id);
        bankDao.delete(bank);
       Pic pic = picDao.findById(Pic.class,bank.getPicId());
        picDao.delete(pic);
    }

    public Pic getPicById(Integer picId){
       return  bankDao.getPicById(picId);
    }

 }
