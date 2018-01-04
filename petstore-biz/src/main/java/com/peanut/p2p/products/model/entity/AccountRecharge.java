package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 充值记录
 * Created by my on 2015/4/11.
 */
@Entity
@Table(name = "df_account_recharge")
public class AccountRecharge extends BaseEntity {


    private static final long serialVersionUID = -8723630788023550983L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "trade_no")
    private String trade_no;//交易号
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "status")
    private Integer status;//状态：0初始化，1充值成功，2充值失败
    @Column(name = "money")
    private BigDecimal money;//充值金额
    @Column(name = "fee")
    private BigDecimal fee;//手续费
    @Column(name = "addtime")
    private String addtime;//提交时间
    @Column(name = "addip")
    private String addip;//提交IP
    @Column(name = "notifytime")
    private Timestamp notifytime;//通知时间
    @Column(name = "notifytype")
    private String notifytype;//通知类型
    @Column(name = "depositid")
    private String depositid;//充值流水号
    @Column(name = "amountln")
    private BigDecimal amountln;//实际到账金额
    @Column(name = "actual_time")
    private String actual_time;//实际到账时间
    @Column(name = "remark")
    private String remark;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getActual_time() {
        return actual_time;
    }

    public void setActual_time(String actual_time) {
        this.actual_time = actual_time;
    }

    public String getAddip() {
        return addip;
    }

    public void setAddip(String addip) {
        this.addip = addip;
    }

    public Timestamp getNotifytime() {
        return notifytime;
    }

    public void setNotifytime(Timestamp notifytime) {
        this.notifytime = notifytime;
    }

    public String getNotifytype() {
        return notifytype;
    }

    public void setNotifytype(String notifytype) {
        this.notifytype = notifytype;
    }

    public String getDepositid() {
        return depositid;
    }

    public void setDepositid(String depositid) {
        this.depositid = depositid;
    }

    public BigDecimal getAmountln() {
        return amountln;
    }

    public void setAmountln(BigDecimal amountln) {
        this.amountln = amountln;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
