/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Search_stock;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Search_stockService {
    Search_stock queryByID(String id);

    void doSave(Search_stock search_stock);

    void doUpdate(Search_stock search_stock);

    void doDelete(Integer id);

}
