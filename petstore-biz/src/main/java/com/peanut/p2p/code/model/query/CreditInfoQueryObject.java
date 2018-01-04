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
import com.peanut.p2p.code.model.entity.CreditInfo;

import java.math.BigDecimal;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = CreditInfo.class, alias = "creditInfo")
public class CreditInfoQueryObject extends QueryObject {

    private static final long serialVersionUID = -8568740445911265155L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "credit_rating", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String credit_rating;//信用等级
    @QueryField(name = "credit_score", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer credit_score;//信用总分
    @QueryField(name = "credit_available", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal credit_available;//可用额度

    private Integer borrow_app_times;//申请借款次数
    private BigDecimal credit_lines;//信用额度

    private BigDecimal overdue_amount;//逾期金额
    private Integer successful_loan_times;//成功借款次数
    private BigDecimal total_loan;//借款总额
    private Integer overdue_times;//逾期次数
    private Integer pay_off;//还清笔数
    private BigDecimal to_pay;//待还本息
    private Integer serious_overdue;//严重逾期次数
    private Integer normal_times;//正常还款次数
    private Integer user_id;
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

    public String getCredit_rating() {
        return credit_rating;
    }

    public void setCredit_rating(String credit_rating) {
        this.credit_rating = credit_rating;
    }

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

    public BigDecimal getCredit_available() {
        return credit_available;
    }

    public void setCredit_available(BigDecimal credit_available) {
        this.credit_available = credit_available;
    }

    public Integer getBorrow_app_times() {
        return borrow_app_times;
    }

    public void setBorrow_app_times(Integer borrow_app_times) {
        this.borrow_app_times = borrow_app_times;
    }

    public BigDecimal getCredit_lines() {
        return credit_lines;
    }

    public void setCredit_lines(BigDecimal credit_lines) {
        this.credit_lines = credit_lines;
    }

    public BigDecimal getOverdue_amount() {
        return overdue_amount;
    }

    public void setOverdue_amount(BigDecimal overdue_amount) {
        this.overdue_amount = overdue_amount;
    }

    public Integer getSuccessful_loan_times() {
        return successful_loan_times;
    }

    public void setSuccessful_loan_times(Integer successful_loan_times) {
        this.successful_loan_times = successful_loan_times;
    }

    public BigDecimal getTotal_loan() {
        return total_loan;
    }

    public void setTotal_loan(BigDecimal total_loan) {
        this.total_loan = total_loan;
    }

    public Integer getOverdue_times() {
        return overdue_times;
    }

    public void setOverdue_times(Integer overdue_times) {
        this.overdue_times = overdue_times;
    }

    public Integer getPay_off() {
        return pay_off;
    }

    public void setPay_off(Integer pay_off) {
        this.pay_off = pay_off;
    }

    public BigDecimal getTo_pay() {
        return to_pay;
    }

    public void setTo_pay(BigDecimal to_pay) {
        this.to_pay = to_pay;
    }

    public Integer getSerious_overdue() {
        return serious_overdue;
    }

    public void setSerious_overdue(Integer serious_overdue) {
        this.serious_overdue = serious_overdue;
    }

    public Integer getNormal_times() {
        return normal_times;
    }

    public void setNormal_times(Integer normal_times) {
        this.normal_times = normal_times;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}