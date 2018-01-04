/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * @author my
 * @version 1.0
 */
@Entity
@Table(name = "ensuretype")
public class EnsureType extends BaseEntity {

    private static final long serialVersionUID = -8234002064135579678L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer Id; //id
    @Pattern(regexp = "^[A-Za-z0-9\u4E00-\u9FFF]{2,}$", message = "{ensureName.illegal}")
    @NotEmpty(message = "{ensureName.illegal}")
    @Column(name = "name")
    private String name; //name
    @Column(name = "constant")
    private String constant; //
    @Column(name = "act_status")
    private Integer act_status;//激活状态

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
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