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
import com.peanut.p2p.products.model.entity.AccountRecharge;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = AccountRecharge.class, alias = "account_recharge")
public class AccountRechargeQueryObject extends QueryObject {

    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "trade_no", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String trade_no;//交易号
    @QueryField(name = "user_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer user_id;
    @QueryField(name = "status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer status;//状态：0初始化，1充值成功，2充值失败
    @QueryField(name = "money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal money;//充值金额
    @QueryField(name = "fee", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal fee;//手续费
    @QueryField(name = "addtime", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String[] addtimes;//提交时间
    private String addip;//提交IP
    private Timestamp notifytime;//通知时间
    private String notifytype;//通知类型
    private String depositid;//充值流水号
    private BigDecimal amountln;//实际到账金额
    @QueryField(name = "actual_time", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String[] actual_times;//实际到账时间
    private String remark;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String[] getAddtimes() {
        return addtimes;
    }

    public void setAddtimes(String[] addtimes) {
        this.addtimes = addtimes;
    }

    public String[] getActual_times() {
        return actual_times;
    }

    public void setActual_times(String[] actual_times) {
        this.actual_times = actual_times;
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

    public String getNotifytype() {
        return notifytype;
    }

    public void setNotifytype(String notifytype) {
        this.notifytype = notifytype;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}