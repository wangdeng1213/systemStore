/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Real_stock;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Real_stockService {
    Real_stock queryByPID(String id);

    void doSave(Real_stock real__stock);

    void doUpdate(Real_stock real__stock);

    void doDelete(Integer id);

}
