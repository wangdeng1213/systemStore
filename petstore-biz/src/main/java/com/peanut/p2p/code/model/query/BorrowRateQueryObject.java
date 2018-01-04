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
import com.peanut.p2p.code.model.entity.BorrowRate;
import com.peanut.p2p.code.model.entity.Period;

import java.math.BigDecimal;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = BorrowRate.class, alias = "borrowRate")
public class BorrowRateQueryObject extends QueryObject {


    private static final long serialVersionUID = 5447564298721519514L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id; //product_id
    @QueryField(name = "credit_rating", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer credit_rating; //product_code

    private String credit_score_range;//信用分数区间

    private BigDecimal month_rate;//月综合费率

    private BigDecimal first_ser_rate;//期初服务费率
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

    public Integer getCredit_rating() {
        return credit_rating;
    }

    public void setCredit_rating(Integer credit_rating) {
        this.credit_rating = credit_rating;
    }

    public String getCredit_score_range() {
        return credit_score_range;
    }

    public void setCredit_score_range(String credit_score_range) {
        this.credit_score_range = credit_score_range;
    }

    public BigDecimal getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(BigDecimal month_rate) {
        this.month_rate = month_rate;
    }

    public BigDecimal getFirst_ser_rate() {
        return first_ser_rate;
    }

    public void setFirst_ser_rate(BigDecimal first_ser_rate) {
        this.first_ser_rate = first_ser_rate;
    }
}