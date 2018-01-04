/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Riskinfo;

import java.util.List;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface RiskinfoService {
    List<Riskinfo> queryAll ();
    Riskinfo queryByID(Long id);

    void doSave(Riskinfo  riskinfo );

    void doUpdate(Riskinfo riskinfo );

    void doUpdate(Long  id);

    void doDelete(Long id);

}
