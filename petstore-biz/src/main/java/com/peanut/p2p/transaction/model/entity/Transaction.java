/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.transaction.model.entity;

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
@Table(name = "transaction")
public class Transaction extends BaseEntity {

    private static final long serialVersionUID = 4069010867960742835L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", nullable = false)
    private Integer transaction_id; //order_id
    @Column(name = "product_id")
    private String product_id; //product_id
    @Column(name = "user_id")
    private String user_id; //user_id
    @Column(name = "invest_money")
    private BigDecimal invest_money; //invest_money
    @Column(name = "description")
    private String description; //description
    @Column(name = "invest_time")
    private Timestamp invest_time; //invest_time
    @Column(name = "bank_name")
    private String bank_name; //bank_name
    @Column(name = "bank_no")
    private String bank_no; //bank_no
    @Column(name = "bank_time")
    private Date bank_time; //bank_time
    @Column(name = "bank_money")
    private BigDecimal bank_money; //bank_money
    @Column(name = "order_no")
    private String order_no; //order_no
    @Column(name = "contract_no")
    private String contract_no; //contract_no
    @Column(name = "deal_status")
    private String deal_status; //deal_status
    @Column(name = "order_id", nullable = false)
    private Integer order_id; //order_id

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

    public Timestamp getInvest_time() {
        return invest_time;
    }

    public void setInvest_time(Timestamp invest_time) {
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

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}