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
import com.peanut.p2p.products.model.entity.AccountCash;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = AccountCash.class, alias = "account_cash")
public class AccountCashQueryObject extends QueryObject {

    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "user_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer user_id;
    @QueryField(name = "status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer status;//状态：0初始1提现成功2提现失败
    @QueryField(name = "account", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String account;//账号
    @QueryField(name = "money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal money;//提现金额
    private BigDecimal total;//提现总额
    private BigDecimal fee;//手续费
    private String bank;//所属银行
    private String branch;//支行
    private Timestamp addtime;//提交时间
    private String addip;//提交IP
    private Timestamp notifytime;//通知时间
    private String bankcardno;//银行卡号
    private String outbizno;//外部订单号
    private String payno;//流水号
    private String paytype;//支付类型
    private String paytypemessage;//支付类型描述
    private String depositid;//充值流水号
    private BigDecimal amountln;//实际到账金额
    private Timestamp actual_time;//实际到账时间
    private String resultcode;//结果标识

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public String getAddip() {
        return addip;
    }

    public void setAddip(String addip) {
        this.addip = addip;
    }

    public Timestamp getNotifytime() {
        return notifytime;
    }

    public void setNotifytime(Timestamp notifytime) {
        this.notifytime = notifytime;
    }

    public String getBankcardno() {
        return bankcardno;
    }

    public void setBankcardno(String bankcardno) {
        this.bankcardno = bankcardno;
    }

    public String getOutbizno() {
        return outbizno;
    }

    public void setOutbizno(String outbizno) {
        this.outbizno = outbizno;
    }

    public String getPayno() {
        return payno;
    }

    public void setPayno(String payno) {
        this.payno = payno;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaytypemessage() {
        return paytypemessage;
    }

    public void setPaytypemessage(String paytypemessage) {
        this.paytypemessage = paytypemessage;
    }

    public String getDepositid() {
        return depositid;
    }

    public void setDepositid(String depositid) {
        this.depositid = depositid;
    }

    public BigDecimal getAmountln() {
        return amountln;
    }

    public void setAmountln(BigDecimal amountln) {
        this.amountln = amountln;
    }

    public Timestamp getActual_time() {
        return actual_time;
    }

    public void setActual_time(Timestamp actual_time) {
        this.actual_time = actual_time;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

}