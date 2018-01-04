/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.customer.investor_info.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.customer.investor_info.model.entity.Investor_info;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Investor_info.class, alias = "investor_info")
public class Investor_infoQueryObject extends QueryObject {

    private static final long serialVersionUID = -7902228374281561299L;
    @QueryField(name = "lender_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer lender_id;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }
}