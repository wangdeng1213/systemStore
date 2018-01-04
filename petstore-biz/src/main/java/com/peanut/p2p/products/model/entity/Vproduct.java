package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by my on 2015/3/30.
 */
@Entity
@Table(name = "v_product")
public class Vproduct extends BaseEntity {


    private static final long serialVersionUID = -9199217309429407575L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id",nullable = false)
    private Integer id; //product_id
    @Column(name = "product_code")
    private String productCode; //product_code
    @Column(name = "product_name")
    private String productName; //product_name
    @Column(name = "product_desc")
    private String productDesc; //product_desc
    @Column(name = "product_type_code")
    private String productTypeCod; //product_type_cod
    @Column(name = "investment_start_date")
    private Date investmentStartDate; //investment_start_date
    @Column(name = "investment_end_date")
    private Date investmentEndDate; //investment_end_date
    @Column(name = "used")
    private String used; //used
    @Column(name = "repayment_date")
    private Date repaymentDate; //repayment_date
    @Column(name = "year_rate")
    private BigDecimal yearRate; //year_rate
    @Column(name = "status_code")
    private String statusCode; //status_code
    @Column(name = "minimum_investment")
    private BigDecimal minimumInvestment; //minimum_investment
    @Column(name = "ascendcompanyidea")
    private String ascendcompanyidea; //ascendcompanyidea
    @Column(name = "enter_status")
    private String enterStatus; //enter_status
    @Column(name = "approval_status")
    private String approvalStatus; //approval_status
    @Column(name = "total_money")
    private BigDecimal totalMoney;
    @Column(name = "release_status")
    private String releaseStatus;//发布状态
    @Column(name = "buy_type")
    private String buyType;//购买方式
    @Column(name = "borrower_rep_time")
    private Date borrower_rep_time;//借款人借款时间
    @Column(name = "borrower_bor_time")
    private Date borrower_bor_time;//借款人还款时间
    @Transient
    private String left_amount;
    @Transient
    private String transferinfo;
    @Column(name = "approval_opinion")
    private String approval_opinion;//审批意见

    @Column(name = "act_status")
    private Integer act_status;//激活状态，默认1

    @Column(name = "transfer_id",nullable = false)
    private Integer transferId;

    @Column(name = "profit_money")
    private BigDecimal profitMoney; //profit_money
    @Column(name = "repayment_rate")
    private BigDecimal repaymentRate; //repayment_date
    @Column(name = "agent")
    private String agent; //agent
    @Column(name = "profit_time")
    private Date profitTime; //profit_time
    @Column(name = "attribute1")
    private String attribute1; //attribute1
    @Column(name = "attribute2")
    private String attribute2; //attribute2
    @Column(name = "attribute3")
    private String attribute3; //attribute3
    @Column(name = "description")
    private String description; //description
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
    @Column(name = "over_term")
    private Integer over_term;//锁标期
    @Column(name = "type")
    private String type;//标的类型
    @Transient
    private String isfull;//未满标

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

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
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

    public Date getProfitTime() {
        return profitTime;
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


    public String getApproval_opinion() {
        return approval_opinion;
    }

    public void setApproval_opinion(String approval_opinion) {
        this.approval_opinion = approval_opinion;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public Date getBorrower_rep_time() {
        return borrower_rep_time;
    }

    public void setBorrower_rep_time(Date borrower_rep_time) {
        this.borrower_rep_time = borrower_rep_time;
    }

    public Date getBorrower_bor_time() {
        return borrower_bor_time;
    }

    public void setBorrower_bor_time(Date borrower_bor_time) {
        this.borrower_bor_time = borrower_bor_time;
    }

    public String getLeft_amount() {
        return left_amount;
    }

    public void setLeft_amount(String left_amount) {
        this.left_amount = left_amount;
    }

    public String getTransferinfo() {
        return transferinfo;
    }

    public void setTransferinfo(String transferinfo) {
        this.transferinfo = transferinfo;
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

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
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
