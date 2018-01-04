package com.peanut.p2p.code.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * Created by my on 2015/4/10.
 */
@Entity
@Table(name="borrow_rate")
public class BorrowRate extends BaseEntity{

    private static final long serialVersionUID = 8444432511235749679L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{creditRat.illegal}")
    @NotBlank(message = "{creditRat.illegal}")
    @Column(name = "credit_rating")
    private String credit_rating;//信用等级/
    //@Pattern(regexp = "^[0-9]{1,2}$", message = "{creditScore.illegal}")
    @NotBlank(message = "{creditScore.illegal}")
    @Column(name = "credit_score_range")
    private String credit_score_range;//信用分数区间
    @NotNull(message = "{monthRate.illegal}")
    @DecimalMin(value = "0")
    @Column(name = "month_rate")
    private BigDecimal month_rate;//月综合费率
    @DecimalMin(value = "0")
    @NotNull(message = "{firstRate.illegal}")
    @Column(name = "first_ser_rate")
    private BigDecimal first_ser_rate;//期初服务费率

    @Column(name = "act_status")
    private Integer act_status;//激活状态

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

    public String getCredit_rating() {
        return credit_rating;
    }

    public void setCredit_rating(String credit_rating) {
        this.credit_rating = credit_rating;
    }

    public String getCredit_score_range() {
        return credit_score_range;
    }

    public void setCredit_score_range(String credit_score_range) {
        this.credit_score_range = credit_score_range;
    }

    public BigDecimal getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(BigDecimal month_rate) {
        this.month_rate = month_rate;
    }

    public BigDecimal getFirst_ser_rate() {
        return first_ser_rate;
    }

    public void setFirst_ser_rate(BigDecimal first_ser_rate) {
        this.first_ser_rate = first_ser_rate;
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
