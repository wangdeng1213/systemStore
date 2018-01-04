/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.company.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.company.model.entity.Company;

import java.util.Date;

/**
 * @author 安文涛
 * @version 1.0
 */
@QueryEntity(entityClazz = Company.class, alias = "com")
public class CompanyQueryObject extends QueryObject {
    private static final long serialVersionUID = -8397007254022383204L;

    private Integer id;

    @QueryField(name = "name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String name;

    @QueryField(name = "email", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String email;

    private String phone;

    @QueryField(name = "registerDate", logicType = LogicType.and, genericOperator = GenericOperator.BETWEEN)
    private Date[] registerDates;

    @QueryField(name = "persons", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer persons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date[] getRegisterDates() {
        return registerDates;
    }

    public void setRegisterDates(Date[] registerDates) {
        this.registerDates = registerDates;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }
}