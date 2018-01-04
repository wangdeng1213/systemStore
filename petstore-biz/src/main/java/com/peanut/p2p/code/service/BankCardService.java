package com.peanut.p2p.code.service;


import com.peanut.p2p.code.model.entity.BankCard;

/**
 * Created by my on 2015/5/6.
 */
public interface BankCardService {

    BankCard queryByID(long id);

    void doSave(BankCard bankCard);

    void doUpdate(BankCard bankCard);

    void doUpdate(Integer id);

    void doDelete(long id);
}
