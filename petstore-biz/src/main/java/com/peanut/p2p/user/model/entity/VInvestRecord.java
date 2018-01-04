package com.peanut.p2p.user.model.entity;

import com.peanut.entity.BaseEntity;
import com.peanut.p2p.validation.annotations.DateFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by my on 2015/2/5.
 */
@Entity
@Table(name = "v_invest_record")
@Cache(region = "vInvestRecordCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class VInvestRecord extends BaseEntity{
    private static final long serialVersionUID = 7379759929306576304L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "productId", length = 100)
    private String productId;
    @Column(name = "investMoney")
    private BigDecimal investMoney;
    @Column(name = "income")
    private BigDecimal income;
    @Column(name = "investTime")
    private String investTime;
    @Column(name = "productName")
    private String productName;//产品名称
    @Column(name = "tztimes")
    private Long tztimes;//投资总次数
    @Column(name = "tzperson")
    private Long tzperson;//投资总人数


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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
