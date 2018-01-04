/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;


import com.peanut.p2p.code.model.entity.BorrowRate;

import java.util.List;

/**
 * Created by my
 */
public interface BorrowRateService {
    List<BorrowRate> queryAll();
    BorrowRate queryByID(Integer id);

    void doSave(BorrowRate borrowRate);

    void doUpdate(BorrowRate borrowRate);

    void doDelete(Integer id);

    void doUpdate(Integer id);

}
