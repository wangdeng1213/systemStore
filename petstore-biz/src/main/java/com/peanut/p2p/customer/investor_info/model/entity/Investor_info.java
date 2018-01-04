/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.customer.investor_info.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "investor_info")
public class Investor_info extends BaseEntity {
    private static final long serialVersionUID = -7767039243810550188L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lender_id", nullable = false)
    private int lender_id;

    public int getLender_id() {
        return lender_id;
    }

    public void setLender_id(int lender_id) {
        this.lender_id = lender_id;
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