/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.user.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.user.model.entity.UserPrivilege;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = UserPrivilege.class, alias = "u")
public class UserPrivilegeQueryObject extends QueryObject {

    private static final long serialVersionUID = 1923535550885476528L;
    private Integer id;
    @QueryField(name = "levelNo",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer levelNo;
    @QueryField(name = "credit",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String credit;
//    @QueryField(name = "activity",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String activity;
//    @QueryField(name = "attribute1",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String attribute1;
//    @QueryField(name = "attribute1",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String attribute2;
//    @QueryField(name = "attribute2",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String description;
    @QueryField(name = "user_id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Integer levelNo) {
        this.levelNo = levelNo;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
