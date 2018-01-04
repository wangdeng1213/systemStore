/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;

import com.peanut.p2p.code.model.entity.CreditInfo;

import java.util.List;

/**
 * Created by my
 */
public interface CreditInfoService {
    List<CreditInfo> queryAll();
    CreditInfo queryByID(Integer id);

    void doSave(CreditInfo creditInfo);

    void doUpdate(CreditInfo creditInfo);

    void doDelete(Integer id);
    void doUpdate(Integer id);
}
