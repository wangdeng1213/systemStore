/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.VBorrowRepaymentPlan;
import com.peanut.p2p.products.model.entity.VRepaymentPlan;

import java.util.List;

/**
 * Created by my
 */
public interface VBorrowRepaymentPlanService {
    List<VBorrowRepaymentPlan> queryAll();
    VBorrowRepaymentPlan queryByID(Long id);

    void doSave(VBorrowRepaymentPlan vRepaymentPlan);

    void doUpdate(VBorrowRepaymentPlan vRepaymentPlan);

    void doDelete(Integer id);

}
