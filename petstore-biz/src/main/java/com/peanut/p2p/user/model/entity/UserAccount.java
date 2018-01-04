package com.peanut.p2p.user.model.entity;

import com.peanut.entity.BaseEntity;
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
@Table(name = "user_account")
@Cache(region = "user_accountCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserAccount extends BaseEntity{

    private static final long serialVersionUID = -3174270189279185719L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id",nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "total_money")
    private BigDecimal totalMoney;
    @Column(name = "crrent_money")
    private BigDecimal currentMoney;
    @Column(name = "collected_money")
    private BigDecimal collectedMoney;
    @Column(name = "frozen_money")
    private BigDecimal frozenMoney;
    @Column(name = "draw_money")
    private BigDecimal drawMoney;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "pay_password",length = 100)
    private String payPassword;
    @Transient
    private String createT;

    @Column(name = "dueIn")
    private BigDecimal dueIn;//待收收益

    public BigDecimal getDueIn() {
        return dueIn;
    }

    public void setDueIn(BigDecimal dueIn) {
        this.dueIn = dueIn;
    }


    public String getCreateT() {
        return createT;
    }

    public void setCreateT(String createT) {
        this.createT = createT;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public BigDecimal getCollectedMoney() {
        return collectedMoney;
    }

    public void setCollectedMoney(BigDecimal collectedMoney) {
        this.collectedMoney = collectedMoney;
    }

    public BigDecimal getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(BigDecimal frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public BigDecimal getDrawMoney() {
        return drawMoney;
    }

    public void setDrawMoney(BigDecimal drawMoney) {
        this.drawMoney = drawMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
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
