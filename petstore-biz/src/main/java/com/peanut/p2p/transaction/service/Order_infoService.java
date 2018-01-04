/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.transaction.service;

import com.peanut.p2p.transaction.model.entity.Order_info;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Order_infoService {
    Order_info queryByID(Integer id);

    void doSave(Order_info order_info);

    void doUpdate(Order_info order_info);

    void doDelete(Integer id);



}
