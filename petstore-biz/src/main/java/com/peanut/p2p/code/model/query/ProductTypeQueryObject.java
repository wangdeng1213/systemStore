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
import com.peanut.p2p.code.model.entity.ProductType;

import java.math.BigDecimal;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = ProductType.class, alias = "productType")
public class ProductTypeQueryObject extends QueryObject {


    private static final long serialVersionUID = -3887527764303387936L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id; //product_id
    @QueryField(name = "product_type_code", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String product_type_code; //
    @QueryField(name = "product_type_name", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String product_type_name;
    @QueryField(name = "status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_type_code() {
        return product_type_code;
    }

    public void setProduct_type_code(String product_type_code) {
        this.product_type_code = product_type_code;
    }

    public String getProduct_type_name() {
        return product_type_name;
    }

    public void setProduct_type_name(String product_type_name) {
        this.product_type_name = product_type_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}