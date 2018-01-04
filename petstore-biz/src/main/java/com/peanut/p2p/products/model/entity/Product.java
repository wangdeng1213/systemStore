/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import com.peanut.p2p.validation.annotations.DateFormat;
import com.peanut.workflow.domain.ProcessInstanceEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
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
@Table(name = "product")
public class Product extends BaseEntity {
    private static final long serialVersionUID = 4408554752037805961L;

    private Long id;

    private String productCode; //product_code

    private String productName; //product_name

    private String productDesc; //product_desc

    private String productTypeCod; //product_type_cod


    private Date investmentStartDate; //investment_start_date


    private Date investmentEndDate; //investment_end_date

    private String used; //used

    private Date repaymentDate; //repayment_date

    private BigDecimal yearRate; //year_rate


    private String statusCode; //status_code

    private BigDecimal minimumInvestment; //minimum_investment

    private String ascendcompanyidea; //ascendcompanyidea

    private String enterStatus; //enter_status

    private String approvalStatus; //approval_status

    private BigDecimal totalMoney;

    private String releaseStatus;//发布状态

    private String buyType;//购买方式

    private Date borrower_rep_time;//借款人还款时间

    private Date borrower_bor_time;//借款人借款时间

    private String left_amount;

    private String transferinfo;

    private String approval_opinion;//审批意见

    private Integer act_status;//激活状态，默认1

    private String verify_user;//审核人

    private Timestamp verify_time;//审核时间


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "verify_user")
    public String getVerify_user() {
        return verify_user;
    }

    public void setVerify_user(String verify_user) {
        this.verify_user = verify_user;
    }
    @Column(name = "verify_time")
    public Timestamp getVerify_time() {
        return verify_time;
    }

    public void setVerify_time(Timestamp verify_time) {
        this.verify_time = verify_time;
    }
    @Column(name = "act_status")
    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }
    @Column(name = "approval_opinion")
    public String getApproval_opinion() {
        return approval_opinion;
    }

    public void setApproval_opinion(String approval_opinion) {
        this.approval_opinion = approval_opinion;
    }
    @NotEmpty(message = "{buyType.not.empty}")
    @Column(name = "buy_type")
    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }
    @DateFormat(message = "{borrowRep.date.error}")
    @Column(name = "borrower_rep_time")
    public Date getBorrower_rep_time() {
        return borrower_rep_time;
    }

    public void setBorrower_rep_time(Date borrower_rep_time) {
        this.borrower_rep_time = borrower_rep_time;
    }
    @DateFormat(message = "{borrowBor.date.error}")
    @Column(name = "borrower_bor_time")
    public Date getBorrower_bor_time() {
        return borrower_bor_time;
    }

    public void setBorrower_bor_time(Date borrower_bor_time) {
        this.borrower_bor_time = borrower_bor_time;
    }
    @Transient
    public String getLeft_amount() {
        return left_amount;
    }

    public void setLeft_amount(String left_amount) {
        this.left_amount = left_amount;
    }
    @Transient
    public String getTransferinfo() {
        return transferinfo;
    }

    public void setTransferinfo(String transferinfo) {
        this.transferinfo = transferinfo;
    }

    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    @NotEmpty(message = "{productName.not.empty}")
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    @NotEmpty(message = "{productDesc.not.empty}")
    @Column(name = "product_desc")
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    @NotEmpty(message = "{productCode.not.empty}")
    @Column(name = "product_type_code")
    public String getProductTypeCod() {
        return productTypeCod;
    }

    public void setProductTypeCod(String productTypeCod) {
        this.productTypeCod = productTypeCod;
    }
    @Column(name = "investment_start_date")
    public Date getInvestmentStartDate() {
        return investmentStartDate;
    }

    public void setInvestmentStartDate(Date investmentStartDate) {
        this.investmentStartDate = investmentStartDate;
    }
    @Column(name = "investment_end_date")
    public Date getInvestmentEndDate() {
        return investmentEndDate;
    }

    public void setInvestmentEndDate(Date investmentEndDate) {
        this.investmentEndDate = investmentEndDate;
    }
   // @Pattern(regexp = "^[A-Za-z0-9\u4E00-\u9FFF]{2,}$", message = "{used.illegal}")
    @Column(name = "used")
    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
    @DateFormat(message = "{repaymentDate.date.error}")
    @Column(name = "repayment_date")
    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }
    @NotNull(message = "{yearRate.not.null}")
    @Column(name = "year_rate")
    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }
    @Column(name = "status_code")
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    @Column(name = "minimum_investment")
    public BigDecimal getMinimumInvestment() {
        return minimumInvestment;
    }

    public void setMinimumInvestment(BigDecimal minimumInvestment) {
        this.minimumInvestment = minimumInvestment;
    }
    @Column(name = "ascendcompanyidea")
    public String getAscendcompanyidea() {
        return ascendcompanyidea;
    }

    public void setAscendcompanyidea(String ascendcompanyidea) {
        this.ascendcompanyidea = ascendcompanyidea;
    }
    @Column(name = "enter_status")
    public String getEnterStatus() {
        return enterStatus;
    }

    public void setEnterStatus(String enterStatus) {
        this.enterStatus = enterStatus;
    }
    @Column(name = "approval_status")
    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    @Column(name = "total_money")
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
    @Column(name = "release_status")
    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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