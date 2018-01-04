/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.BoRepaymentPlan;

/**
 * Created by my
 */
public interface BoRepaymentPlanService {
    BoRepaymentPlan queryByID(Integer id);

    BoRepaymentPlan queryByUserId(Integer id);

    void doSave(BoRepaymentPlan investorinfo);

    void doUpdate(BoRepaymentPlan investorinfo);

    void doUpdate(Integer id);

    void doDelete(Integer id);

}
