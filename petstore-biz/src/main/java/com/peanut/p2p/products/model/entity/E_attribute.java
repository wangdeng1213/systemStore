/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "e_attribute")
public class E_attribute extends BaseEntity {
    private static final long serialVersionUID = -82083576402283196L;
    @Id
    @Column(name = "product_id",length = 100, nullable = false)
    private String product_id;

    @Column(name = "product_code",length = 20)
    private String product_code;
    @Column(name = "product_name",length = 100)
    private String product_name;
    @Column(name = "product_desc")
    private String product_desc;
    @Column(name = "product_type_cod",length = 10)
    private String product_type_cod;
    @Column(name = "product_type_name",length = 10)
    private String product_type_name;
    @Column(name = "used",length = 500)
    private String used;
    @Column(name = "status_code",length = 50)
    private String status_code;

    @Column(name = "current_dtail_id",length = 50)
    private String current_dtail_id;
    @Column(name = "user_name",length = 50)
    private String user_name;
    @Column(name = "user_id",length = 50)
    private String user_id;
    @Column(name = "product_area",length = 200)
    private String product_area;
    @Column(name = "ascendcompanyidea")
    private String ascendcompanyidea;
    @Column(name = "hasfactorage",length = 50)
    private String hasfactorage;
    @Column(name = "create_by",length = 200)
    private String create_by;
    @Column(name = "lastupdate_by",length = 200)
    private String lastupdate_by;
    @Column(name = "reverse_update_content")
    private String reverse_update_content;
    @Column(name = "update_content")
    private String update_content;
    @Column(name = "financing_name",length = 100)
    private String financing_name;
    @Column(name = "financing_id",length = 100)
    private String financing_id;
    @Column(name = "enter_status",length = 12)
    private String enter_status;
    @Column(name = "approval_status",length = 12)
    private String approval_status;
    @Column(name = "credit_level")
    private Integer credit_level;
    @Column(name = "investment_start_date")
    private Date investment_start_date;
    @Column(name = "investment_end_date")
    private Date investment_end_date;
    @Column(name = "repayment_date")
    private Date repayment_date;
    @Column(name = "create_date")
    private Date create_date;
    @Column(name = "full_scale")
    private Date full_scale;
    @Column(name = "lastupdate_date")
    private Date lastupdate_date;
    @Column(name = "year_rate")
     private BigDecimal year_rate;
    @Column(name = "platform_rate")
    private BigDecimal platform_rate;
    @Column(name = "minimum_investment")
    private BigDecimal minimum_investment;
    @Column(name = "total_money")
    private BigDecimal total_money;
    @Column(name = "current_money")
    private BigDecimal current_money;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_type_cod() {
        return product_type_cod;
    }

    public void setProduct_type_cod(String product_type_cod) {
        this.product_type_cod = product_type_cod;
    }

    public String getProduct_type_name() {
        return product_type_name;
    }

    public void setProduct_type_name(String product_type_name) {
        this.product_type_name = product_type_name;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getCurrent_dtail_id() {
        return current_dtail_id;
    }

    public void setCurrent_dtail_id(String current_dtail_id) {
        this.current_dtail_id = current_dtail_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProduct_area() {
        return product_area;
    }

    public void setProduct_area(String product_area) {
        this.product_area = product_area;
    }

    public String getAscendcompanyidea() {
        return ascendcompanyidea;
    }

    public void setAscendcompanyidea(String ascendcompanyidea) {
        this.ascendcompanyidea = ascendcompanyidea;
    }

    public String getHasfactorage() {
        return hasfactorage;
    }

    public void setHasfactorage(String hasfactorage) {
        this.hasfactorage = hasfactorage;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getLastupdate_by() {
        return lastupdate_by;
    }

    public void setLastupdate_by(String lastupdate_by) {
        this.lastupdate_by = lastupdate_by;
    }

    public String getReverse_update_content() {
        return reverse_update_content;
    }

    public void setReverse_update_content(String reverse_update_content) {
        this.reverse_update_content = reverse_update_content;
    }

    public String getUpdate_content() {
        return update_content;
    }

    public void setUpdate_content(String update_content) {
        this.update_content = update_content;
    }

    public String getFinancing_name() {
        return financing_name;
    }

    public void setFinancing_name(String financing_name) {
        this.financing_name = financing_name;
    }

    public String getFinancing_id() {
        return financing_id;
    }

    public void setFinancing_id(String financing_id) {
        this.financing_id = financing_id;
    }

    public String getEnter_status() {
        return enter_status;
    }

    public void setEnter_status(String enter_status) {
        this.enter_status = enter_status;
    }

    public String getApproval_status() {
        return approval_status;
    }

    public void setApproval_status(String approval_status) {
        this.approval_status = approval_status;
    }

    public Integer getCredit_level() {
        return credit_level;
    }

    public void setCredit_level(Integer credit_level) {
        this.credit_level = credit_level;
    }

    public Date getInvestment_start_date() {
        return investment_start_date;
    }

    public void setInvestment_start_date(Date investment_start_date) {
        this.investment_start_date = investment_start_date;
    }

    public Date getInvestment_end_date() {
        return investment_end_date;
    }

    public void setInvestment_end_date(Date investment_end_date) {
        this.investment_end_date = investment_end_date;
    }

    public Date getRepayment_date() {
        return repayment_date;
    }

    public void setRepayment_date(Date repayment_date) {
        this.repayment_date = repayment_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getFull_scale() {
        return full_scale;
    }

    public void setFull_scale(Date full_scale) {
        this.full_scale = full_scale;
    }

    public Date getLastupdate_date() {
        return lastupdate_date;
    }

    public void setLastupdate_date(Date lastupdate_date) {
        this.lastupdate_date = lastupdate_date;
    }

    public BigDecimal getYear_rate() {
        return year_rate;
    }

    public void setYear_rate(BigDecimal year_rate) {
        this.year_rate = year_rate;
    }

    public BigDecimal getPlatform_rate() {
        return platform_rate;
    }

    public void setPlatform_rate(BigDecimal platform_rate) {
        this.platform_rate = platform_rate;
    }

    public BigDecimal getMinimum_investment() {
        return minimum_investment;
    }

    public void setMinimum_investment(BigDecimal minimum_investment) {
        this.minimum_investment = minimum_investment;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public BigDecimal getCurrent_money() {
        return current_money;
    }

    public void setCurrent_money(BigDecimal current_money) {
        this.current_money = current_money;
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