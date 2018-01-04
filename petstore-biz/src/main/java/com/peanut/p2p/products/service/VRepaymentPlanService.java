/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.VRepaymentPlan;

import java.util.List;

/**
 * Created by my
 */
public interface VRepaymentPlanService {
    List<VRepaymentPlan> queryAll();
    VRepaymentPlan queryByID(Long id);

    void doSave(VRepaymentPlan vRepaymentPlan);

    void doUpdate(VRepaymentPlan vRepaymentPlan);

    void doDelete(Integer id);

}
