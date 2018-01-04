package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by my on 2015/4/11.
 */
@Entity
@Table(name = "t_borrow_actual_repayment")
@Cache(region = "actualRepaymentCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class BoActualRepayment extends BaseEntity {

    private static final long serialVersionUID = 5388754794655812496L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actual_repayment_id", nullable = false)
    private Integer id;//实际还款编号

    @Column(name = "product_id")
    private Integer product_id;//标的编号
    @Column(name = "product_name")
    private String product_name;//标的名称
    @Column(name = "repayment_term")
    private Integer repayment_term;//还款第几期

    @Column(name = "repayment_time")
    private String repayment_time;//还款时间

    @Column(name = "overdue")
    private Integer overdue;//逾期天数
    @Column(name = "isfull")
    private Integer isfull;//是否满额还款1：满额2：还部分
    @Column(name = "overdue_amount")
    private BigDecimal overdue_amount;//逾期金额
    @Column(name = "paid_amount")
    private BigDecimal paid_amount;//已还款总额
    @Column(name = "actual_money")
    private BigDecimal actual_money;//实际还款金额
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRepayment_time(String repayment_time) {
        this.repayment_time = repayment_time;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getRepayment_term() {
        return repayment_term;
    }

    public void setRepayment_term(Integer repayment_term) {
        this.repayment_term = repayment_term;
    }

    public String getRepayment_time() {
        return repayment_time;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getIsfull() {
        return isfull;
    }

    public void setIsfull(Integer isfull) {
        this.isfull = isfull;
    }

    public BigDecimal getOverdue_amount() {
        return overdue_amount;
    }

    public void setOverdue_amount(BigDecimal overdue_amount) {
        this.overdue_amount = overdue_amount;
    }

    public BigDecimal getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(BigDecimal paid_amount) {
        this.paid_amount = paid_amount;
    }

    public BigDecimal getActual_money() {
        return actual_money;
    }

    public void setActual_money(BigDecimal actual_money) {
        this.actual_money = actual_money;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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
