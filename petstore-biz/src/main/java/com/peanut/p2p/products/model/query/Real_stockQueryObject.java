/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.Real_stock;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Real_stock.class, alias = "real_stock")
public class Real_stockQueryObject extends QueryObject {

    private static final long serialVersionUID = 6973327333390053563L;
    @QueryField(name = "stock_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer stock_id; //stock_id
    @QueryField(name = "produc_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String produc_id; //produc_id
    @QueryField(name = "left_amount", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer left_amount; //left_amount

    public Integer getStock_id() {
        return stock_id;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public String getProduc_id() {
        return produc_id;
    }

    public void setProduc_id(String produc_id) {
        this.produc_id = produc_id;
    }

    public Integer getLeft_amount() {
        return left_amount;
    }

    public void setLeft_amount(Integer left_amount) {
        this.left_amount = left_amount;
    }
}