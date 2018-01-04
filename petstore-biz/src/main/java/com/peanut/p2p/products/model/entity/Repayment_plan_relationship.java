/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "repayment_plan_relationship")
public class Repayment_plan_relationship extends BaseEntity {

    private static final long serialVersionUID = -8273335716534244890L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ship_id", nullable = false)
    private Integer ship_id; //repayment_plan_id
    @Column(name = "project_id")
    private String project_id; //project_id
    @Column(name = "repayment_time")
    private Date repayment_time; //repayment_time
    @Column(name = "finish")
    private BigDecimal finish; //finish
    @Column(name = "days")
    private Integer days; //days
    @Column(name = "actual_repayment_time")
    private Date actual_repayment_time; //actual_repayment_time
    @Column(name = "description")
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

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}