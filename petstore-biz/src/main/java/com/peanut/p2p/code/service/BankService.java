/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;


import com.peanut.p2p.code.model.entity.Bank;
import com.peanut.p2p.code.model.entity.Pic;

import java.util.List;

/**
 * Created by my
 */
public interface BankService {
    List<Bank> queryAll();
    Bank queryByID(Integer id);

    void doSave(Pic pic,Bank bank);

    void doUpdate(Pic pic,Bank bank);

    void doDelete(Integer id);

    Pic getPicById(Integer picId);

   // void uploadImage(MultipartFile file,Bank bank);

}
