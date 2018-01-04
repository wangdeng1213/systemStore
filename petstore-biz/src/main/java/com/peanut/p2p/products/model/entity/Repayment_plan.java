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
import java.sql.Timestamp;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "t_repayment_plan")
public class Repayment_plan extends BaseEntity {

    private static final long serialVersionUID = -477846672786810357L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "repayment_plan_id", nullable = false)
    private Integer repayment_plan_id; //repayment_plan_id
    @Column(name = "product_id")
    private String product_id; //project_id
    @Column(name = "repayment_time")
    private Timestamp repayment_time; //repayment_time
    @Column(name = "finish")
    private BigDecimal finish; //finish
    @Column(name = "days")
    private Integer days; //days
    @Column(name = "money")
    private BigDecimal money; //actual_repayment_time
    @Column(name = "description")
    private String description; //description
    @Column(name = "uid")
    private Integer uid;//用户ID
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "act_status")
    private Integer act_status;
    @Column(name = "name")
    private String name;

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

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