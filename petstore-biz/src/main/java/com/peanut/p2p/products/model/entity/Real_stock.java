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
@Table(name = "real_stock")
public class Real_stock extends BaseEntity {
    private static final long serialVersionUID = 628304614321586603L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id",nullable = false)
    private Integer stock_id; //stock_id
    @Column(name = "product_id")
    private String product_id; //produc_id
    @Column(name = "left_amount")
    private BigDecimal left_amount; //left_amount

    public Integer getStock_id() {
        return stock_id;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public BigDecimal getLeft_amount() {
        return left_amount;
    }

    public void setLeft_amount(BigDecimal left_amount) {
        this.left_amount = left_amount;
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