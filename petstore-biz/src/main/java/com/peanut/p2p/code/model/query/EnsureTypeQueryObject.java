/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.code.model.entity.EnsureType;
import com.peanut.p2p.products.model.entity.Riskinfo;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = EnsureType.class, alias = "ensure")
public class EnsureTypeQueryObject extends QueryObject {

    private static final long serialVersionUID = 7096508305336814052L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id; //product_id
    @QueryField(name = "name", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String name; //product_code
    @QueryField(name = "constant", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String constant; //product_name
    @QueryField(name = "act_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer act_status;

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }
}