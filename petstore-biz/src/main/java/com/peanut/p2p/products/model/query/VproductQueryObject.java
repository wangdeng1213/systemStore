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
import com.peanut.p2p.products.model.entity.Product;
import com.peanut.p2p.products.model.entity.Vproduct;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author my
 * @version 1.0
 */
@QueryEntity(entityClazz = Vproduct.class, alias = "vproduct")
public class VproductQueryObject extends QueryObject {


    private static final long serialVersionUID = -2762471180012573362L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id; //product_id
    @QueryField(name = "productCode", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String productCode; //product_code
    @QueryField(name = "productName", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String productName; //product_name
    @QueryField(name = "productDesc", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String productDesc; //product_desc
    @QueryField(name = "productTypeCod", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String productTypeCod; //product_type_cod
    @QueryField(name = "investmentStartDate", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date investmentStartDate; //investment_start_date
    @QueryField(name = "investmentEndDate", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date investmentEndDate; //investment_end_date
    @QueryField(name = "used", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String used; //used
    @QueryField(name = "repaymentDate", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Date repaymentDate; //repayment_date
    @QueryField(name = "yearRate", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal yearRate; //year_rate
    @QueryField(name = "statusCode", logicType = LogicType.and, genericOperator = GenericOperator.IN)
    private String statusCode; //status_code
    @QueryField(name = "minimumInvestment", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal minimumInvestment; //minimum_investment
    @QueryField(name = "ascendcompanyidea", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String ascendcompanyidea; //ascendcompanyidea
    @QueryField(name = "enterStatus", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String enterStatus; //enter_status
    @QueryField(name = "approvalStatus", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String approvalStatus; //approval_status
    @QueryField(name = "approval_opinion", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String approval_opinion;//审批意见
    @QueryField(name = "act_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer act_status;
    @QueryField(name = "transferId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer transferId;
    @QueryField(name = "profitMoney", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal profitMoney; //profit_money
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
    @QueryField(name = "finishTime", logicType = LogicType.and, genericOperator = GenericOperator.ISNULL)
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
    @QueryField(name = "type", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String type;//类型
    @QueryField(name = "isfull", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String isfull;

    public String getIsfull() {
        return isfull;
    }

    public void setIsfull(String isfull) {
        this.isfull = isfull;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public BigDecimal getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(BigDecimal profitMoney) {
        this.profitMoney = profitMoney;
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

    public String getApproval_opinion() {
        return approval_opinion;
    }
    public void setApproval_opinion(String approval_opinion) {
        this.approval_opinion = approval_opinion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductTypeCod() {
        return productTypeCod;
    }

    public void setProductTypeCod(String productTypeCod) {
        this.productTypeCod = productTypeCod;
    }

    public Date getInvestmentStartDate() {
        return investmentStartDate;
    }

    public void setInvestmentStartDate(Date investmentStartDate) {
        this.investmentStartDate = investmentStartDate;
    }

    public Date getInvestmentEndDate() {
        return investmentEndDate;
    }

    public void setInvestmentEndDate(Date investmentEndDate) {
        this.investmentEndDate = investmentEndDate;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public String getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public BigDecimal getMinimumInvestment() {
        return minimumInvestment;
    }

    public void setMinimumInvestment(BigDecimal minimumInvestment) {
        this.minimumInvestment = minimumInvestment;
    }

    public String getAscendcompanyidea() {
        return ascendcompanyidea;
    }

    public void setAscendcompanyidea(String ascendcompanyidea) {
        this.ascendcompanyidea = ascendcompanyidea;
    }

    public String getEnterStatus() {
        return enterStatus;
    }

    public void setEnterStatus(String enterStatus) {
        this.enterStatus = enterStatus;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}