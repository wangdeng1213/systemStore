package com.peanut.p2p.products.model.entity;


import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by my on 2015/4/29.
 */
@Entity
@Table(name="shcl")
public class Shcl extends BaseEntity{
    private static final long serialVersionUID = -6911592697683327852L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;//
    @Column(name = "picids")
    private String picId;//图片ID
    @Column(name = "shyj")
    private String shyj;//审核意见
    @Column(name = "shzt")
    private String shzt;//审核状态：1：通过2：驳回
    @Column(name = "rzrq")
    private Date rzrq;//认证日期
    @Column(name = "verify_user")
    private String verify_user;//审核人

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getShyj() {
        return shyj;
    }

    public void setShyj(String shyj) {
        this.shyj = shyj;
    }

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRzrq() {
        return rzrq;
    }

    public void setRzrq(Date rzrq) {
        this.rzrq = rzrq;
    }

    public String getVerify_user() {
        return verify_user;
    }

    public void setVerify_user(String verify_user) {
        this.verify_user = verify_user;
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
