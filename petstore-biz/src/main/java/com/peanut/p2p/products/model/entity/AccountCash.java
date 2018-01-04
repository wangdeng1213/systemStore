package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 提现记录
 * Created by my on 2015/4/11.
 */
@Entity
@Table(name = "df_account_cash")
public class AccountCash extends BaseEntity {


    private static final long serialVersionUID = 6882504863392760004L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "status")
    private Integer status;//状态：0初始1提现成功2提现失败
    @Column(name = "account")
    private String account;//账号
    @Column(name = "money")
    private BigDecimal money;//提现金额
    @Column(name = "total")
    private BigDecimal total;//提现总额
    @Column(name = "fee")
    private BigDecimal fee;//手续费
    @Column(name = "bank")
    private String bank;//所属银行
    @Column(name = "branch")
    private String branch;//支行
    @Column(name = "addtime")
    private Timestamp addtime;//提交时间
    @Column(name = "addip")
    private String addip;//提交IP
    @Column(name = "notifytime")
    private Timestamp notifytime;//通知时间
    @Column(name = "bankcardno")
    private String bankcardno;//银行卡号
    @Column(name = "outbizno")
    private String outbizno;//外部订单号
    @Column(name = "payno")
    private String payno;//流水号
    @Column(name = "paytype")
    private String paytype;//支付类型
    @Column(name = "paytypemessage")
    private String paytypemessage;//支付类型描述
    @Column(name = "amountln")
    private BigDecimal amountln;//实际到账金额
    @Column(name = "actual_time")
    private Timestamp actual_time;//实际到账时间
    @Column(name = "resultcode")
    private String resultcode;//结果标识

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
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

    public String getBankcardno() {
        return bankcardno;
    }

    public void setBankcardno(String bankcardno) {
        this.bankcardno = bankcardno;
    }

    public String getOutbizno() {
        return outbizno;
    }

    public void setOutbizno(String outbizno) {
        this.outbizno = outbizno;
    }

    public String getPayno() {
        return payno;
    }

    public void setPayno(String payno) {
        this.payno = payno;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaytypemessage() {
        return paytypemessage;
    }

    public void setPaytypemessage(String paytypemessage) {
        this.paytypemessage = paytypemessage;
    }



    public BigDecimal getAmountln() {
        return amountln;
    }

    public void setAmountln(BigDecimal amountln) {
        this.amountln = amountln;
    }

    public Timestamp getActual_time() {
        return actual_time;
    }

    public void setActual_time(Timestamp actual_time) {
        this.actual_time = actual_time;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
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
