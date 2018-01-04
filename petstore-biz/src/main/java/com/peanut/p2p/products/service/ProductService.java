/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Product;
import com.peanut.p2p.products.model.entity.ProductInfo;
import com.peanut.p2p.products.model.entity.Transfer;

import java.util.List;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface ProductService {
    Product queryByID(Long id);

    void doSave(Product product);

    void doUpdate(Product product);

    void doDelete(Integer id);

    List<Product> getEndTimeafterSysTime();

    List<Product> getSysTimeafterEndTime();

    List<Product> queryList();

    List<Product> queryMBList();

    void doUpdate(Long id);

    void doUpdateEnter(Long id);

    void doUpdateStatus(String statusCode,Long id);

    void doSave(Product product,Transfer transfer);

    void doUpdate(ProductInfo productInfo);

    String confirmZZ(long id);
}
