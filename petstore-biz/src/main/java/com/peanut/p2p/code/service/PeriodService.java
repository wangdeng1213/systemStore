/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;


import com.peanut.p2p.code.model.entity.Period;

import java.util.List;

/**
 * Created by my
 */
public interface PeriodService {
    List<Period> queryAll();
    Period queryByID(Integer id);

    void doSave(Period agent);

    void doUpdate(Period agent);

    void doUpdate(Integer id);

    void doDelete(Integer id);

}
