/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.AccountRecharge;

import java.util.List;

/**
 * Created by my
 */
public interface AccountRechargeService {
    List<AccountRecharge> queryAll();
    AccountRecharge queryByID(Integer id);

    void doSave(AccountRecharge accountRecharge);

    void doUpdate(AccountRecharge accountRecharge);

    void doDelete(Integer id);

}
