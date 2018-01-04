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
 * @author my
 * @version 1.0
 */
@Entity
@Table(name = "borrow_repayment_plan")
public class BoRepaymentPlan extends BaseEntity {

    private static final long serialVersionUID = 3236638591802693673L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_id", nullable = false)
    private Integer id; //还款计划编号
    @Column(name = "product_id")
    private String product_id; //标的编号
    @Column(name = "user_id")
    private Integer user_id;//借款人编号
    @Column(name = "loan_term")
    private Integer loan_term;//借款期限
    @Column(name = "repayment_startperiod")
    private Timestamp repayment_startperiod; //开始还款时间
    @Column(name = "rep_total_money")
    private BigDecimal rep_total_money; //应还总额=本金+利息+服务费
    @Column(name = "terminal_money")
    private BigDecimal terminal_money; //每期应还款额
    @Column(name = "finish_time")
    private Timestamp finish_time; //结束时间
    @Column(name = "repayment_type")
    private String repayment_type; //还款类型
    @Column(name = "act_status")
    private Integer act_status;//激活状态
/*    @Column(name = "product_name")
    private String product_name;
    @Column(name = "name")
    private String name;*/
    @Column(name = "month_rate")
    private BigDecimal month_rate;//月综合费率
    @Column(name = "total_money")
    private BigDecimal total_money;//借款总额
    @Column(name = "comfee")
    private BigDecimal comfee;//综合费用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(Integer loan_term) {
        this.loan_term = loan_term;
    }

    public Timestamp getRepayment_startperiod() {
        return repayment_startperiod;
    }

    public void setRepayment_startperiod(Timestamp repayment_startperiod) {
        this.repayment_startperiod = repayment_startperiod;
    }

    public BigDecimal getRep_total_money() {
        return rep_total_money;
    }

    public void setRep_total_money(BigDecimal rep_total_money) {
        this.rep_total_money = rep_total_money;
    }

    public BigDecimal getTerminal_money() {
        return terminal_money;
    }

    public void setTerminal_money(BigDecimal terminal_money) {
        this.terminal_money = terminal_money;
    }

    public Timestamp getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
    }

    public String getRepayment_type() {
        return repayment_type;
    }

    public void setRepayment_type(String repayment_type) {
        this.repayment_type = repayment_type;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

 /*   public String getProduct_name() {
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
    }*/

    public BigDecimal getComfee() {
        return comfee;
    }

    public void setComfee(BigDecimal comfee) {
        this.comfee = comfee;
    }

    public BigDecimal getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(BigDecimal month_rate) {
        this.month_rate = month_rate;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
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