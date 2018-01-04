package com.peanut.p2p.code.model.entity;


import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * Created by my on 2015/4/10.
 */
@Entity
@Table(name = "period")
public class Period extends BaseEntity{


    private static final long serialVersionUID = 4803489419471981351L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "period_id",nullable = false)
    private Integer id;
    @NotNull(message = "{loanTerm.illegal}")
    @Column(name = "loan_term")
    private  Integer loan_term;/*借款期限*/
    @DecimalMin(value = "0")
    @Column(name = "month_rate")
    private BigDecimal month_rate;//月综合费率
    @Column(name = "act_status")
    private Integer act_status;//激活状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(Integer loan_term) {
        this.loan_term = loan_term;
    }

    public BigDecimal getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(BigDecimal month_rate) {
        this.month_rate = month_rate;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
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
