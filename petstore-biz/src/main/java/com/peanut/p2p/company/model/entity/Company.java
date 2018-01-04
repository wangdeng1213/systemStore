/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.company.model.entity;

import com.peanut.entity.BaseEntity;
import com.peanut.p2p.validation.annotations.DateFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;

/**
 * @author 安文涛
 * @version 1.0
 */
@Entity
@Table(name = "company")
@Cache(region = "companyCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Company extends BaseEntity {
    private static final long serialVersionUID = 5388754794655812496L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Pattern(regexp = "^[A-Za-z0-9\u4E00-\u9FFF]{2,}$", message = "{companyName.illegal}")
    @Column(name = "name", length = 100)
//    @CellConvert(colum = 0, dataType = DataType.STRING)
    private String name;

    @Email(message = "{email.illegal}")
    @NotEmpty(message = "{email.illegal}")
    @Column(name = "email", length = 100)
//    @CellConvert(colum = 1, dataType = DataType.STRING)
    private String email;

    @Pattern(regexp = "(\\(?0\\d{3}[)-]?\\d{7,8})|(\\(?0\\d{2}[)-]?\\d{8})|(1[0-9]{10})", message = "{phone.illegal}")
    @Column(name = "phone", length = 20)
//    @CellConvert(colum = 2, dataType = DataType.STRING)
    private String phone;

    @DateFormat(message = "{register.date.error}")
    @Column(name = "registerDate")
//    @CellConvert(colum = 3, dataType = DataType.DATE)
    private Date registerDate;

    @Column(name = "persons")
    private Integer persons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
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