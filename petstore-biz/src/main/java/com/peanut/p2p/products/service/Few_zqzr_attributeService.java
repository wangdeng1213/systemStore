/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Few_zqzr_attribute;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Few_zqzr_attributeService {
    Few_zqzr_attribute queryByID(String id);

    void doSave(Few_zqzr_attribute fewzqzrattribute);

    void doUpdate(Few_zqzr_attribute fewzqzrattribute);

    void doDelete(Integer id);

}
