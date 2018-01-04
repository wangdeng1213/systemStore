package com.peanut.p2p.user.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by my on 2015/7/6.
 */
@Entity
@Table(name = "loan_apply")
public class LoanApply extends BaseEntity{

    private static final long serialVersionUID = -4442804881306497358L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;//姓名
    @Column(name = "phone")
    private String  phone;//手机号
    @Column(name = "amount")
    private BigDecimal amount;//借款金额
    @Column(name = "email")
    private String email;//邮箱
    @Column(name = "applytime")
    private Timestamp applytime;//申请时间
    @Column(name = "act_status")
    private Integer act_status;//激活状态0:未激活1:已激活

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public Timestamp getApplytime() {
        return applytime;
    }

    public void setApplytime(Timestamp applytime) {
        this.applytime = applytime;
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
