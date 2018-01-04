package com.peanut.p2p.user.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by my on 2015/2/5.
 */
@Entity
@Table(name = "user_account_record")
@Cache(region = "user_account_recordCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserAccountRecord extends BaseEntity{

    private static final long serialVersionUID = 4609325629474857548L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rechanrge_id",nullable = false)
    private Integer id;
    @Column(name = "user_id",length = 100)
    private String userId;
    @Column(name = "account_id",length = 100)
    private String  accountId;
    @Column(name = "rechanrge_money")
    private BigDecimal rechanrgeMoney;
    @Column(name = "rechanrge_type")
    private BigDecimal rechanrgeType;
    @Column(name = "rechanrge_time")
    private String rechanrgeTime;
    @Column(name = "rechanrge_receive_time")
    private String rechanrgeReceiveTime;
    @Column(name = "description",length = 300)
    private String description;
    @Column(name = "update_time")
    private String updateTime;
    @Column(name = "update_by",length = 100)
    private String updateBy;
    @Column(name = "bank_name",length = 50)
    private String bankName;
    @Column(name = "bank_no",length = 50)
    private String bankNo;
    @Column(name = "bank_address",length = 200)
    private String bankAddress;
    @Column(name = "bank_tel",length = 20)
    private String bankTel;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "open_bankname",length = 50)
    private String openBankName;

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getRechanrgeMoney() {
        return rechanrgeMoney;
    }

    public void setRechanrgeMoney(BigDecimal rechanrgeMoney) {
        this.rechanrgeMoney = rechanrgeMoney;
    }

    public BigDecimal getRechanrgeType() {
        return rechanrgeType;
    }

    public void setRechanrgeType(BigDecimal rechanrgeType) {
        this.rechanrgeType = rechanrgeType;
    }

    public String getRechanrgeTime() {
        return rechanrgeTime;
    }

    public void setRechanrgeTime(String rechanrgeTime) {
        this.rechanrgeTime = rechanrgeTime;
    }

    public String getRechanrgeReceiveTime() {
        return rechanrgeReceiveTime;
    }

    public void setRechanrgeReceiveTime(String rechanrgeReceiveTime) {
        this.rechanrgeReceiveTime = rechanrgeReceiveTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankTel() {
        return bankTel;
    }

    public void setBankTel(String bankTel) {
        this.bankTel = bankTel;
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
