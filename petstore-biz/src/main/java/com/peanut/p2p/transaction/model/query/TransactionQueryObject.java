/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.transaction.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.transaction.model.entity.Transaction;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Transaction.class, alias = "transaction")
public class TransactionQueryObject extends QueryObject {

    private static final long serialVersionUID = -3691822744713156589L;
    @QueryField(name = "transaction_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer transaction_id; //order_id
    @QueryField(name = "product_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String product_id; //product_id
    @QueryField(name = "user_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String user_id; //user_id
    @QueryField(name = "invest_money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal invest_money; //invest_money
    @QueryField(name = "description", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String description; //description
    @QueryField(name = "invest_time", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date invest_time; //invest_time
    @QueryField(name = "bank_name", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String bank_name; //bank_name
    @QueryField(name = "bank_no", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String bank_no; //bank_no
    @QueryField(name = "bank_time", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date bank_time; //bank_time
    @QueryField(name = "bank_money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal bank_money; //bank_money
    @QueryField(name = "order_no", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String order_no; //order_no
    @QueryField(name = "contract_no", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String contract_no; //contract_no
    @QueryField(name = "deal_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String deal_status; //deal_status
    @QueryField(name = "order_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer order_id; //deal_status

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getInvest_money() {
        return invest_money;
    }

    public void setInvest_money(BigDecimal invest_money) {
        this.invest_money = invest_money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInvest_time() {
        return invest_time;
    }

    public void setInvest_time(Date invest_time) {
        this.invest_time = invest_time;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }

    public Date getBank_time() {
        return bank_time;
    }

    public void setBank_time(Date bank_time) {
        this.bank_time = bank_time;
    }

    public BigDecimal getBank_money() {
        return bank_money;
    }

    public void setBank_money(BigDecimal bank_money) {
        this.bank_money = bank_money;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getContract_no() {
        return contract_no;
    }

    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    public String getDeal_status() {
        return deal_status;
    }

    public void setDeal_status(String deal_status) {
        this.deal_status = deal_status;
    }
}