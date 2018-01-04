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
import com.peanut.p2p.products.model.entity.Repayment_plan_relationship;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Repayment_plan_relationship.class, alias = "repayment_plan_relationship")
public class Repayment_plan_relationshipQueryObject extends QueryObject {


    private static final long serialVersionUID = -1431334129696951522L;
    @QueryField(name = "ship_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer ship_id; //ship_id
    @QueryField(name = "project_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String project_id; //project_id
    @QueryField(name = "repayment_time", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date repayment_time; //repayment_time
    @QueryField(name = "finish", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal finish; //finish
    @QueryField(name = "days", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer days; //days
    @QueryField(name = "actual_repayment_time", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date actual_repayment_time; //actual_repayment_time
    @QueryField(name = "description", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String description; //description

    public Integer getShip_id() {
        return ship_id;
    }

    public void setShip_id(Integer ship_id) {
        this.ship_id = ship_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public Date getRepayment_time() {
        return repayment_time;
    }

    public void setRepayment_time(Date repayment_time) {
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

    public Date getActual_repayment_time() {
        return actual_repayment_time;
    }

    public void setActual_repayment_time(Date actual_repayment_time) {
        this.actual_repayment_time = actual_repayment_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}