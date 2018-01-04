package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by my on 2015/5/6.
 */
@Entity
@Table(name = "v_repayment_plan")
@Cache(region = "vrepCache", usage = CacheConcurrencyStrategy.READ_ONLY)
public class VRepaymentPlan extends BaseEntity {
    private static final long serialVersionUID = 8420114043708151463L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "repayment_plan_id",nullable = false)
    private Long id;
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "year_rate")
    private BigDecimal yearRate;
    @Column(name = "total_money")
    private BigDecimal totalMoney;
    @Column(name = "over_term")
    private Integer overTerm;
    @Column(name = "type")
    private String type;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "invest_money")
    private BigDecimal investMoney;
    @Column(name = "repayment_time")
    private String repaymentTime;
    @Column(name = "money")
    private BigDecimal money;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "bank_branch")
    private String bankBranch;
    @Column(name = "bank_card_no")
    private String cardNo;
    @Column(name = "user_name")
    private  String userName;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getOverTerm() {
        return overTerm;
    }

    public void setOverTerm(Integer overTerm) {
        this.overTerm = overTerm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(BigDecimal investMoney) {
        this.investMoney = investMoney;
    }

    public String getRepaymentTime() {
        return repaymentTime;
    }

    public void setRepaymentTime(String repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
