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
import com.peanut.p2p.products.model.entity.BoRepaymentPlan;
import com.peanut.p2p.products.model.entity.TBoRepaymentPlan;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = TBoRepaymentPlan.class, alias = "repayment_plan3")
public class TBoRepaymentPlanQueryObject extends QueryObject {

    private static final long serialVersionUID = -6613830335173577971L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id; //还款计划编号
    @QueryField(name = "product_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String product_id; //标的编号
    @QueryField(name = "user_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer user_id;//借款人编号
    @QueryField(name = "loan_term", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer loan_term;//借款期限
    private Timestamp repayment_startperiod; //开始还款时间
    private BigDecimal rep_total_money; //应还总额=本金+利息+服务费
    private BigDecimal terminal_money; //每期应还款额
    private Timestamp finish_time; //结束时间
    @QueryField(name = "repayment_type", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String repayment_type; //还款类型
    @QueryField(name = "act_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer act_status;//激活状态
    @QueryField(name = "product_name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String product_name;
    @QueryField(name = "name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String name;
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
}