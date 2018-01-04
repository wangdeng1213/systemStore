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
import com.peanut.p2p.products.model.entity.Attachment_zqzr_attribute;

import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Attachment_zqzr_attribute.class, alias = "attachment_zqzr_attribute")
public class Attachment_zqzr_attributeQueryObject extends QueryObject {

    private static final long serialVersionUID = -4624409191295280802L;
    @QueryField(name = "product_users_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String product_users_id;
    @QueryField(name = "product_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String product_id;
    @QueryField(name = "user_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String user_id;
    @QueryField(name = "contract", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String contract;
    @QueryField(name = "create_by", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String create_by;
    @QueryField(name = "lastupdate_by", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String lastupdate_by;
    @QueryField(name = "contract_type", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String contract_type;
    @QueryField(name = "contract_path", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String contract_path;
    @QueryField(name = "order_num", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer order_num;
    @QueryField(name = "create_date", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date create_date;
    @QueryField(name = "lastupdate_date", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date lastupdate_date;


    public String getProduct_users_id() {
        return product_users_id;
    }

    public void setProduct_users_id(String product_users_id) {
        this.product_users_id = product_users_id;
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

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getLastupdate_by() {
        return lastupdate_by;
    }

    public void setLastupdate_by(String lastupdate_by) {
        this.lastupdate_by = lastupdate_by;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getContract_path() {
        return contract_path;
    }

    public void setContract_path(String contract_path) {
        this.contract_path = contract_path;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLastupdate_date() {
        return lastupdate_date;
    }

    public void setLastupdate_date(Date lastupdate_date) {
        this.lastupdate_date = lastupdate_date;
    }
}