/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;



import com.peanut.p2p.code.model.entity.ProductType;

import java.util.List;

/**
 * Created by my
 */
public interface ProductTypeService {
    List<ProductType> queryAll();
    ProductType queryByID(Integer id);

    void doSave(ProductType productType);

    void doUpdate(ProductType productType);

    void doDelete(Integer id);
    void doUpdate(Integer id);
}
