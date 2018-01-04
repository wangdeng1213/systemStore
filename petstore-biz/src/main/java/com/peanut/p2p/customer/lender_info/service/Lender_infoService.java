/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.customer.lender_info.service;

import com.peanut.p2p.customer.lender_info.model.entity.Lender_info;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Lender_infoService {
    Lender_info queryByID(Integer id);

    void doSave(Lender_info investorinfo);

    void doUpdate(Lender_info investorinfo);

    void doDelete(Integer id);

}
