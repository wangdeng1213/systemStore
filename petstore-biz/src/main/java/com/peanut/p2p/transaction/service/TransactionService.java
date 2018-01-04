/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.transaction.service;

import com.peanut.p2p.transaction.model.entity.Transaction;

import java.util.List;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface TransactionService {
    Transaction queryByID(Integer id);

    List<Transaction> queryByPID(String pid);

    void doSave(Transaction investorinfo);

    void doUpdate(Transaction investorinfo);

    void doDelete(Integer id);

}
