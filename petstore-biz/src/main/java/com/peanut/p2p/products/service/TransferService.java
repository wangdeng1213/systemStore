/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Transfer;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface TransferService {
    Transfer queryByID(Integer id);
    Transfer queryByPID(String pid);
    void doSave(Transfer zqzrattribute);

    void doUpdate(Transfer zqzrattribute);

    void doUpdate(Long id,Timestamp endTime);
    void doDelete(Integer id);

    List<Transfer> queryAll();

}
