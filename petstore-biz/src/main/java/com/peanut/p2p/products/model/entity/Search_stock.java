/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "search_stock")
public class Search_stock extends BaseEntity {

    private static final long serialVersionUID = 1023356892714498395L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "search_stock_id", nullable = false)
    private Integer search_stock_id; //search_stock_id
    @Column(name = "product_id")
    private String product_id; //product_id
    @Column(name = "total")
    private BigDecimal total; //total
    @Column(name = "left_amount")
    private BigDecimal left_amount; //left_amount
    @Column(name = "finish")
    private Integer finish; //finish
    @Column(name = "rate")
    private BigDecimal rate; //rate

    public Integer getSearch_stock_id() {
        return search_stock_id;
    }

    public void setSearch_stock_id(Integer search_stock_id) {
        this.search_stock_id = search_stock_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getLeft_amount() {
        return left_amount;
    }

    public void setLeft_amount(BigDecimal left_amount) {
        this.left_amount = left_amount;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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