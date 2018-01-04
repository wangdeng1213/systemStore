/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.Shcl;

import java.util.List;

/**
 * Created by my
 */
public interface ShclService {
    List<Shcl> queryAll();
    Shcl queryByID(Long id);

    void doSave(Shcl shcl);

    void doUpdate(Shcl shcl);

    void doDelete(Integer id);

    Shcl queryByPicId(Long picId);
}
