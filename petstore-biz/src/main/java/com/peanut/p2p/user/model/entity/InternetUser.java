package com.peanut.p2p.user.model.entity;


import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by my on 2015/2/26.
 */
@Entity
@Table(name = "internet_user")
@Cache(region = "internetUserCache",usage = CacheConcurrencyStrategy.READ_WRITE)
public class InternetUser extends BaseEntity{
    @Column(name = "login_name",length = 50)
    private String userName;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "password",length = 500)
    private String password;
    @Column(name = "id_number",length = 18)
    private String idcard;
    @Column(name = "email",length = 500)
    private String email;
    @Column(name = "phone",length = 15)
    private String mobilephone;
    @Column(name = "registerDate")
    private Date registerDate;
    @Column(name = "status")
    private Integer actStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id",nullable = false)
    private Integer id;
   // @Column(name = "salt",length = 100)
   // private String salt;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public Integer getActStatus() {
        return actStatus;
    }

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
