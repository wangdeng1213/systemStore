/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;

import com.peanut.p2p.code.model.entity.EnsureType;

import java.util.List;

/**
 * Created by my
 */
public interface EnsureTypeService {
    List<EnsureType> queryAll();
    EnsureType queryByID(Integer id);

    void doSave(EnsureType ensureType);

    void doUpdate(EnsureType ensureType);

    void doDelete(Integer id);
    void doUpdate(Integer id);
}
