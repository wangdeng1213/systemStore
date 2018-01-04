/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.customer.investor_info.service;

import com.peanut.p2p.customer.investor_info.model.entity.Investor_info;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Investor_infoService {
    Investor_info queryByID(Integer id);

    void doSave(Investor_info investorinfo);

    void doUpdate(Investor_info investorinfo);

    void doDelete(Integer id);

}
