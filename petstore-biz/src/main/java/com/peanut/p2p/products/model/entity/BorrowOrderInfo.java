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
 * Created by  on 2015/4/11.
 */
@Entity
@Table(name = "borrow_order_info")
@Cache(region = "borrowOrderInfoCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class BorrowOrderInfo extends BaseEntity {

    private static final long serialVersionUID = 5388754794655812496L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrow_order_id", nullable = false)
    private Integer borrow_order_id;//	借款订单编号

    @Column(name = "user_id", nullable = false)
    private Integer user_id;//借款人编号

    @Column(name = "borrow_title")
    private String borrow_title;//	借款标题

    @Column(name = "borrow_money")
    private BigDecimal borrow_money;//借款金额

    @Column(name = "borrow_description")
    private String borrow_description;//借款描述

    @Column(name = "borrow_time")
    private String borrow_time;//借款时间

    @Column(name = "borrow_term")
    private Integer borrow_term;//借款期限

    @Column(name = "surplus")
    private BigDecimal surplus;//剩余还款额

    @Column(name = "success")
    private Integer success;//借款状态

    @Column(name = "order_type")
    private String order_type;

    @Column(name = "client_version")
    private String client_version;

    @Column(name = "loanorder_status")
    private String loanorder_status;

    @Column(name = "ip")
    private String ip;

    @Column(name = "attribute")
    private String attribute;

    @Column(name = "realname")
    private String realname;

    @Column(name = "income_money")
    private BigDecimal income_money;

    @Column(name = "id_card")
    private String id_card;

    @Column(name = "period_id")
    private Integer period_id;//借款期限ID


    public Integer getBorrow_order_id() {
        return borrow_order_id;
    }

    public void setBorrow_order_id(Integer borrow_order_id) {
        this.borrow_order_id = borrow_order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBorrow_title() {
        return borrow_title;
    }

    public void setBorrow_title(String borrow_title) {
        this.borrow_title = borrow_title;
    }

    public BigDecimal getBorrow_money() {
        return borrow_money;
    }

    public void setBorrow_money(BigDecimal borrow_money) {
        this.borrow_money = borrow_money;
    }

    public String getBorrow_description() {
        return borrow_description;
    }

    public void setBorrow_description(String borrow_description) {
        this.borrow_description = borrow_description;
    }

    public String getBorrow_time() {
        return borrow_time;
    }

    public void setBorrow_time(String borrow_time) {
        this.borrow_time = borrow_time;
    }

    public Integer getBorrow_term() {
        return borrow_term;
    }

    public void setBorrow_term(Integer borrow_term) {
        this.borrow_term = borrow_term;
    }

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getClient_version() {
        return client_version;
    }

    public void setClient_version(String client_version) {
        this.client_version = client_version;
    }

    public String getLoanorder_status() {
        return loanorder_status;
    }

    public void setLoanorder_status(String loanorder_status) {
        this.loanorder_status = loanorder_status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public BigDecimal getIncome_money() {
        return income_money;
    }

    public void setIncome_money(BigDecimal income_money) {
        this.income_money = income_money;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Integer getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(Integer period_id) {
        this.period_id = period_id;
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
