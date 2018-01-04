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
import com.peanut.p2p.code.model.entity.Period;

import java.math.BigDecimal;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = Period.class, alias = "period")
public class PeriodQueryObject extends QueryObject {


    private static final long serialVersionUID = 2556390745581590849L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id; //product_id
    @QueryField(name = "loan_term", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer loan_term; //product_code
    @QueryField(name = "month_rate", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal month_rate; //product_name
    @QueryField(name = "act_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer act_status;//激活状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(Integer loan_term) {
        this.loan_term = loan_term;
    }

    public BigDecimal getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(BigDecimal month_rate) {
        this.month_rate = month_rate;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }
}