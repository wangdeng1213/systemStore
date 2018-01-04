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
import com.peanut.p2p.products.model.entity.Repayment_plan;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Repayment_plan.class, alias = "repayment_plan")
public class Repayment_planQueryObject extends QueryObject {

    private static final long serialVersionUID = -8103440015302155583L;
    @QueryField(name = "repayment_plan_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer repayment_plan_id; //repayment_plan_id
    @QueryField(name = "product_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String product_id; //project_id
    @QueryField(name = "repayment_time", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Timestamp repayment_time; //repayment_time
    @QueryField(name = "finish", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal finish; //finish
    @QueryField(name = "days", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer days; //days
    @QueryField(name = "money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal money; //actual_repayment_time
    @QueryField(name = "description", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String description; //description
    @QueryField(name = "uid", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer uid;//用户ID
    @QueryField(name = "product_name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String product_name;
    @QueryField(name = "act_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer act_status;
    @QueryField(name = "name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String name;
    public Integer getRepayment_plan_id() {
        return repayment_plan_id;
    }

    public void setRepayment_plan_id(Integer repayment_plan_id) {
        this.repayment_plan_id = repayment_plan_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Timestamp getRepayment_time() {
        return repayment_time;
    }

    public void setRepayment_time(Timestamp repayment_time) {
        this.repayment_time = repayment_time;
    }

    public BigDecimal getFinish() {
        return finish;
    }

    public void setFinish(BigDecimal finish) {
        this.finish = finish;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}