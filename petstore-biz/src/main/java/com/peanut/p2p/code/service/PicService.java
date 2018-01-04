/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;

import com.peanut.p2p.code.model.entity.Pic;

import java.util.List;

/**
 * Created bymy on 2014/11/30.
 */
public interface PicService {
    List<Pic> queryAll();
    Pic queryByID(Integer id);

    void doSave(Pic pic);

    void doUpdate(Pic pic);

    void doDelete(Integer id);

}
