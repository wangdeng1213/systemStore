/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.AccountCash;

import java.util.List;

/**
 * Created by my
 */
public interface AccountCashService {
    List<AccountCash> queryAll();
    AccountCash queryByID(Integer id);

    void doSave(AccountCash accountCash);

    void doUpdate(AccountCash accountCash);

    void doDelete(Integer id);

}
