/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;

import com.peanut.p2p.code.model.entity.Contract;

import java.util.List;

/**
 * Created by myon 2014/11/30.
 */
public interface ContractService {
    List<Contract> queryAll();
    Contract queryByID(Integer id);

    void doSave(Contract contract);

    void doUpdate(Contract contract);

    void doDelete(Integer id);
    void doUpdate(Integer id);


}
