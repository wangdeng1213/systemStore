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
import com.peanut.p2p.transaction.model.entity.Order_info;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Order_info.class, alias = "order_info")
public class Order_infoQueryObject extends QueryObject {

    private static final long serialVersionUID = -1744547027952113861L;
    @QueryField(name = "order_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer order_id; //order_id
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
    @QueryField(name = "success", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer success; //success
    @QueryField(name = "order_type", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String order_type; //order_type
    @QueryField(name = "client_version", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String client_version; //client_version
    @QueryField(name = "order_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String order_status; //order_status
    @QueryField(name = "", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String ip; //ip
    @QueryField(name = "attribute", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String attribute; //attribute
    @QueryField(name = "realname", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String realname; //realname
    @QueryField(name = "income_money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal income_money; //income_money
    @QueryField(name = "id_card", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String id_card; //id_card

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
}