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
import com.peanut.p2p.products.model.entity.Transfer;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Transfer.class, alias = "transfer")
public class TransferQueryObject extends QueryObject {

    private static final long serialVersionUID = 2785292036910597325L;
    @QueryField(name = "transferId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer transferId;
    @QueryField(name = "productId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String productId; //product_id
    @QueryField(name = "profitMoney", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal profitMoney; //profit_money
    @QueryField(name = "repaymentDate", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal repaymentDate; //repayment_date
    @QueryField(name = "agent", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String agent; //agent
    @QueryField(name = "profitTime", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date profitTime; //profit_time
    @QueryField(name = "attribute1", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String attribute1; //attribute1
    @QueryField(name = "attribute2", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String attribute2; //attribute2
    @QueryField(name = "attribute3", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String attribute3; //attribute3
    @QueryField(name = "description", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String description; //description
    @QueryField(name = "preTime", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Timestamp preTime;
    @QueryField(name = "totalMoney", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal totalMoney; //total_money
    @QueryField(name = "perValue", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal perValue; //per_value
    @QueryField(name = "startTime", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Timestamp startTime; //start_time
    @QueryField(name = "endTime", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Timestamp endTime; //end_time
    @QueryField(name = "finishTime", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date finishTime; //finish_time
    @QueryField(name = "ensureType", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String ensureType; //ensure_type
    @QueryField(name = "overdue", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String overdue; //overdue
    @QueryField(name = "repayType", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String repayType; //repay_type
    @QueryField(name = "riskInfo", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String riskInfo; //risk_info
    @QueryField(name = "createBy", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String createBy; //create_by
    @QueryField(name = "createTime", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private  Date createTime; //create_time
    @QueryField(name = "finish", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer finish; //finish
    @QueryField(name = "loanTerm", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer loanTerm; //loan_term
    @QueryField(name = "authLevel", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer authLevel; //auth_level
    @QueryField(name = "publishType", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String publishType; //publish_type
    @QueryField(name = "productTotal", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer productTotal; //product_total

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

    public BigDecimal getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(BigDecimal repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getProfitTime() {
        return profitTime;
    }

    public Timestamp getPreTime() {
        return preTime;
    }

    public void setPreTime(Timestamp preTime) {
        this.preTime = preTime;
    }

    public void setProfitTime(Date profitTime) {
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

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
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

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
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
}