package com.peanut.p2p.user.model.entity;
import com.peanut.entity.BaseEntity;
import com.peanut.p2p.validation.annotations.DateFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.DateTime;


import javax.persistence.*;
import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by my on 2015/2/5.
 */
@Entity
@Table(name = "invest_record")
@Cache(region = "investRecordCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class InvestRecord  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invest_record_id", nullable = false)
    private Integer id;
    @Column(name = "product_id", length = 100)
    private String productId;
    @Column(name = "user_id",length = 100)
    private String userId;
    @Column(name = "invest_money")
    private BigDecimal investMoney;
    @Column(name = "income")
    private BigDecimal income;
    @Column(name = "description",length = 50)
    private String description;
    @Column(name = "invest_time")
    private Date investTime;
    @Column(name = "repay_time")
    private String repayTime;
    @Column(name = "finish")
    private Integer finish;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "product_name")
    private String productName;//产品名称
    @Column(name = "term")
    private Integer term;//总期数
    @Column(name = "current_income")
    private BigDecimal currentIncome;//已收收益
    @Column(name = "current_term")
    private Integer currentTerm;//当前期数
    @Column(name = "next_term")
    private Integer nextTerm;//下一期数
    @Transient
    private Long tztimes;//投资总次数
    @Transient
    private Long tzperson;//投资总人数
    @Column(name = "act_status")
    private Integer act_status;//激活状态
    @Column(name = "dueIn")
    private BigDecimal dueIn;//待收收益

    public BigDecimal getDueIn() {
        return dueIn;
    }

    public void setDueIn(BigDecimal dueIn) {
        this.dueIn = dueIn;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(BigDecimal investMoney) {
        this.investMoney = investMoney;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInvestTime() {
        return investTime;
    }

    public void setInvestTime(Date investTime) {
        this.investTime = investTime;
    }

    public String getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(BigDecimal currentIncome) {
        this.currentIncome = currentIncome;
    }

    public Integer getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(Integer currentTerm) {
        this.currentTerm = currentTerm;
    }

    public Integer getNextTerm() {
        return nextTerm;
    }

    public void setNextTerm(Integer nextTerm) {
        this.nextTerm = nextTerm;
    }

    public Long getTztimes() {
        return tztimes;
    }

    public void setTztimes(Long tztimes) {
        this.tztimes = tztimes;
    }

    public Long getTzperson() {
        return tzperson;
    }

    public void setTzperson(Long tzperson) {
        this.tzperson = tzperson;
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
