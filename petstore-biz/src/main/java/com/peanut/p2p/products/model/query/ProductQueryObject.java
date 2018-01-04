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
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Product.class, alias = "product")
public class ProductQueryObject extends QueryObject {

    private static final long serialVersionUID = 986066527049404505L;
    @QueryField(name = "productId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer productId; //product_id
    @QueryField(name = "productCode", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String productCode; //product_code
    @QueryField(name = "productName", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String productName; //product_name
    @QueryField(name = "productDesc", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
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
    @QueryField(name = "statusCode", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
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

    public String getApproval_opinion() {
        return approval_opinion;
    }
    public void setApproval_opinion(String approval_opinion) {
        this.approval_opinion = approval_opinion;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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