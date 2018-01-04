package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by my on 2015/6/4.
 */
@Entity
@Table(name = "borrow_repayment_detail")
public class BoRepaymentDetail extends BaseEntity{

    private static final long serialVersionUID = 3116865187948983744L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "product_id")
    private Integer product_id;//标的ID
    @Column(name = "term")
    private Integer term;//还款期数
    @Column(name = "repayment_time")
    private Timestamp repayment_time;//还款时间
    @Column(name = "repayment_money")
    private BigDecimal repayment_money;//应还金额
    @Column(name = "principal_fee")
    private BigDecimal principal_fee;//本金
    @Column(name = "interest_fee")
    private BigDecimal interest_fee;//利息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Timestamp getRepayment_time() {
        return repayment_time;
    }

    public void setRepayment_time(Timestamp repayment_time) {
        this.repayment_time = repayment_time;
    }

    public BigDecimal getRepayment_money() {
        return repayment_money;
    }

    public void setRepayment_money(BigDecimal repayment_money) {
        this.repayment_money = repayment_money;
    }

    public BigDecimal getPrincipal_fee() {
        return principal_fee;
    }

    public void setPrincipal_fee(BigDecimal principal_fee) {
        this.principal_fee = principal_fee;
    }

    public BigDecimal getInterest_fee() {
        return interest_fee;
    }

    public void setInterest_fee(BigDecimal interest_fee) {
        this.interest_fee = interest_fee;
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
