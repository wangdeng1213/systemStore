/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.Repayment_plan_relationship;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface Repayment_plan_relationshipService {
    Repayment_plan_relationship queryByID(Integer id);

    void doSave(Repayment_plan_relationship investorinfo);

    void doUpdate(Repayment_plan_relationship investorinfo);

    void doDelete(Integer id);

}
