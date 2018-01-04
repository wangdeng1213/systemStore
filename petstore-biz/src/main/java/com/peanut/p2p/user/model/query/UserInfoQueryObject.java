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
import com.peanut.p2p.user.model.entity.UserInfo;

import java.util.Date;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = UserInfo.class, alias = "u")
public class UserInfoQueryObject extends QueryObject {

    private static final long serialVersionUID = 7194703386282047738L;
    private Integer id;
    @QueryField(name = "userName",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String userName; //user_name
    private String password; //password
    @QueryField(name = "name",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String name; //name
    @QueryField(name = "sex",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer sex; //sex
    @QueryField(name = "idcardType",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String idcardType; //idcard_type
    @QueryField(name = "idcard",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String idcard; //idcard
    @QueryField(name = "releDocuments",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String releDocuments; //rele_documents
    @QueryField(name = "address",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String address; //address
    @QueryField(name = "mobilephone",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String mobilephone; //mobilephone
    private String telephone; //telephone
    private String email; //email
    @QueryField(name = "qq",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String qq; //qq
    @QueryField(name = "birthday",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Date[] birthdays; //birthday
    @QueryField(name = "actStatus",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer actStatus; //act_status
    @QueryField(name = "phoneAuth",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Integer phoneAuth; //phone_auth
    @QueryField(name = "idcardAuth",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Integer idcardAuth; //idcard_auth
    @QueryField(name = "emailAuth",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Integer emailAuth; //email_auth
    @QueryField(name = "updateBy",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String updateBy; //update_by
    @QueryField(name = "updateTime",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String updateTime; //update_time
    @QueryField(name = "descriptions",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String descriptions;

    private String payPassword;

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcardType() {
        return idcardType;
    }

    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getReleDocuments() {
        return releDocuments;
    }

    public void setReleDocuments(String releDocuments) {
        this.releDocuments = releDocuments;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date[] getBirthdays() {
        return birthdays;
    }

    public void setBirthdays(Date[] birthdays) {
        this.birthdays = birthdays;
    }

    public Integer getActStatus() {
        return actStatus;
    }

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    public Integer getPhoneAuth() {
        return phoneAuth;
    }

    public void setPhoneAuth(Integer phoneAuth) {
        this.phoneAuth = phoneAuth;
    }

    public Integer getIdcardAuth() {
        return idcardAuth;
    }

    public void setIdcardAuth(Integer idcardAuth) {
        this.idcardAuth = idcardAuth;
    }

    public Integer getEmailAuth() {
        return emailAuth;
    }

    public void setEmailAuth(Integer emailAuth) {
        this.emailAuth = emailAuth;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
