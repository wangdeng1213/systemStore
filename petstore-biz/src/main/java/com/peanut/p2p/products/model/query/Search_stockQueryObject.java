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
import com.peanut.p2p.products.model.entity.Search_stock;

import java.math.BigDecimal;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Search_stock.class, alias = "lender_info")
public class Search_stockQueryObject extends QueryObject {

    private static final long serialVersionUID = -3786320370195358172L;
    @QueryField(name = "search_stock_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer search_stock_id; //search_stock_id
    @QueryField(name = "product_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String produc_id; //produc_id
    @QueryField(name = "total", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal total; //total
    @QueryField(name = "left_amount", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal left_amount; //left_amount
    @QueryField(name = "finish", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer finish; //finish
    @QueryField(name = "rate", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal rate; //rate

    public Integer getSearch_stock_id() {
        return search_stock_id;
    }

    public void setSearch_stock_id(Integer search_stock_id) {
        this.search_stock_id = search_stock_id;
    }

    public String getProduc_id() {
        return produc_id;
    }

    public void setProduc_id(String produc_id) {
        this.produc_id = produc_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getLeft_amount() {
        return left_amount;
    }

    public void setLeft_amount(BigDecimal left_amount) {
        this.left_amount = left_amount;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}