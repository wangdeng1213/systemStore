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
import java.util.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "order_info")
public class Order_info extends BaseEntity {

    private static final long serialVersionUID = -6073284148579124678L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private Integer order_id; //order_id
    @Column(name = "product_id")
    private String product_id; //product_id
    @Column(name = "user_id")
    private String user_id; //user_id
    @Column(name = "invest_money")
    private BigDecimal invest_money; //invest_money
    @Column(name = "description")
    private String description; //description
    @Column(name = "invest_time")
    private Date invest_time; //invest_time
    @Column(name = "success")
    private Integer success; //success
    @Column(name = "order_type")
    private String order_type; //order_type
    @Column(name = "client_version")
    private String client_version; //client_version
    @Column(name = "order_status")
    private String order_status; //order_status
    @Column(name = "ip")
    private String ip; //ip
    @Column(name = "attribute")
    private String attribute; //attribute
    @Column(name = "realname")
    private String realname; //realname
    @Column(name = "income_money")
    private BigDecimal income_money; //income_money
    @Column(name = "id_card")
    private String id_card;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
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

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getClient_version() {
        return client_version;
    }

    public void setClient_version(String client_version) {
        this.client_version = client_version;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public BigDecimal getIncome_money() {
        return income_money;
    }

    public void setIncome_money(BigDecimal income_money) {
        this.income_money = income_money;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
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