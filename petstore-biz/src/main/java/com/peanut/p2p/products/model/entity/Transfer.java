/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import com.peanut.p2p.validation.annotations.DateFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "transfer")
public class Transfer extends BaseEntity {
    private static final Long serialVersionUID = 5503009085234320527L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transfer_id",nullable = false)
    private Integer transferId;
    @Column(name = "product_id")
    private String productId; //product_id
    @DecimalMin(value = "0")
    @Column(name = "profit_money")
    private BigDecimal profitMoney; //profit_money
    @Column(name = "repayment_rate")
    private BigDecimal repaymentRate; //repayment_date
    @NotEmpty(message = "{agent.not.empty}")
    @Column(name = "agent")
    private String agent; //agent
    @DateFormat(message = "{profitTime.date.error}")
    @Column(name = "profit_time")
    private Timestamp profitTime; //profit_time
    @Column(name = "attribute1")
    private String attribute1; //attribute1
    @Column(name = "attribute2")
    private String attribute2; //attribute2
    @Column(name = "attribute3")
    private String attribute3; //attribute3
    @Column(name = "description")
    private String description; //description：

    @Column(name = "per_value")
    private BigDecimal perValue; //per_value
    @Column(name = "start_time")
    private Timestamp startTime; //start_time
    @Column(name = "end_time")
    private Timestamp endTime; //end_time
    @Column(name = "pre_time")
    private Timestamp preTime;
    @Column(name = "finish_time")
    private Timestamp finishTime; //finish_time
    @Transient
    private String finishDate;//和finishTime对应，临时变量
    @NotEmpty(message = "{ensureType.not.empty}")
    @Column(name = "ensure_type")
    private String ensureType; //ensure_type
    @Column(name = "overdue")
    private String overdue; //overdue
    @Column(name = "repay_type")
    private String repayType; //repay_type
    @Column(name = "risk_info")
    private String riskInfo; //risk_info
    @Column(name = "create_by")
    private String createBy; //create_by
    @Column(name = "create_time")
    private  Date createTime; //create_time
    @Column(name = "finish")
    private Integer finish; //finish
    @NotNull(message = "{loanTerm.not.null}")
    @Column(name = "loan_term")
    private Integer loanTerm; //loan_term
    @Column(name = "auth_level")
    private Integer authLevel; //auth_level
    @Column(name = "publish_type")
    private String publishType; //publish_type

    @Column(name = "product_total")
    private Integer productTotal; //总fen数
    @Column(name = "over_time")
    private Timestamp over_time;//锁标结束时间
    @NotNull(message = "{overTerm.not.null}")
    @Column(name = "over_term")
    private Integer over_term;//锁标期
    @NotEmpty(message = "{type.not.empty}")
    @Column(name = "type")
    private String type;//标的种类
    @Column(name = "is_vouch")
    private Integer is_vouch;//点击次数

    @Column(name = "verify_user")
    private String verify_user;//审核人
    @Column(name = "verify_time")
    private Timestamp verify_time;//审核时间
    @Column(name = "verify_remark")
    private String verify_remark;//审核意见
    @Column(name = "transfer_fee")
    private BigDecimal transfer_fee;//交易手续费
    @Column(name = "manage_fee")
    private BigDecimal manage_fee;//管理费
    @Column(name = "to_pay")
    private BigDecimal to_pay;//待还本息
    @Column(name = "odd")
    private BigDecimal odd;//违约金
    @Column(name = "month_rate")
    private BigDecimal month_rate;//月综合费率

    public BigDecimal getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(BigDecimal month_rate) {
        this.month_rate = month_rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIs_vouch() {
        return is_vouch;
    }

    public void setIs_vouch(Integer is_vouch) {
        this.is_vouch = is_vouch;
    }

    public String getVerify_user() {
        return verify_user;
    }

    public void setVerify_user(String verify_user) {
        this.verify_user = verify_user;
    }

    public Timestamp getVerify_time() {
        return verify_time;
    }

    public void setVerify_time(Timestamp verify_time) {
        this.verify_time = verify_time;
    }

    public String getVerify_remark() {
        return verify_remark;
    }

    public void setVerify_remark(String verify_remark) {
        this.verify_remark = verify_remark;
    }

    public BigDecimal getTransfer_fee() {
        return transfer_fee;
    }

    public void setTransfer_fee(BigDecimal transfer_fee) {
        this.transfer_fee = transfer_fee;
    }

    public BigDecimal getManage_fee() {
        return manage_fee;
    }

    public void setManage_fee(BigDecimal manage_fee) {
        this.manage_fee = manage_fee;
    }

    public BigDecimal getTo_pay() {
        return to_pay;
    }

    public void setTo_pay(BigDecimal to_pay) {
        this.to_pay = to_pay;
    }

    public BigDecimal getOdd() {
        return odd;
    }

    public void setOdd(BigDecimal odd) {
        this.odd = odd;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Timestamp getOver_time() {
        return over_time;
    }

    public void setOver_time(Timestamp over_time) {
        this.over_time = over_time;
    }

    public Integer getOver_term() {
        return over_term;
    }

    public void setOver_term(Integer over_term) {
        this.over_term = over_term;
    }

    public Timestamp getPreTime() {
        return preTime;
    }

    public void setPreTime(Timestamp preTime) {
        this.preTime = preTime;
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(BigDecimal profitMoney) {
        this.profitMoney = profitMoney;
    }

    public BigDecimal getRepaymentRate() {
        return repaymentRate;
    }

    public void setRepaymentRate(BigDecimal repaymentRate) {
        this.repaymentRate = repaymentRate;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Timestamp getProfitTime() {
        return profitTime;
    }

    public void setProfitTime(Timestamp profitTime) {
        this.profitTime = profitTime;
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

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPerValue() {
        return perValue;
    }

    public void setPerValue(BigDecimal perValue) {
        this.perValue = perValue;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public String getEnsureType() {
        return ensureType;
    }

    public void setEnsureType(String ensureType) {
        this.ensureType = ensureType;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public Integer getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Integer loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Integer getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(Integer authLevel) {
        this.authLevel = authLevel;
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public Integer getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(Integer productTotal) {
        this.productTotal = productTotal;
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