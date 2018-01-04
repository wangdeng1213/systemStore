/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Attachment_zqzr_attribute;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Attachment_zqzr_attributeService {
    Attachment_zqzr_attribute queryByID(String id);

    void doSave(Attachment_zqzr_attribute attachmentzqzrattribute);

    void doUpdate(Attachment_zqzr_attribute attachmentzqzrattribute);

    void doDelete(Integer id);

}
