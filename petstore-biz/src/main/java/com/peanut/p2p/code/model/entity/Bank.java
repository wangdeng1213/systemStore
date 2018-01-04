package com.peanut.p2p.code.model.entity;


import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by my on 2015/3/18.
 */
@Entity
@Table(name="bank")
public class Bank extends BaseEntity {

    private static final long serialVersionUID = -6740271767846117448L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id", nullable = false)
    private Integer bank_id;
    @Pattern(regexp = "^[A-Za-z0-9\u4E00-\u9FFF]{2,}$", message = "{bankName.illegal}")
    @NotBlank(message = "{bankName.illegal}")
    @Column(name = "bank_name")
    private String bank_name;
    @Pattern(regexp = "^[A-Za-z0-9\u4E00-\u9FFF]{2,}$", message = "{bankAddress.illegal}")
    @NotBlank(message = "{bankAddress.illegal}")
    @Column(name = "bank_address")
    private String bank_address;
    @NotBlank(message = "{bankNo.illegal}")
    @Column(name = "bank_no")
    private String bank_no;
    @Pattern(regexp = "(\\(?0\\d{3}[)-]?\\d{7,8})|(\\(?0\\d{2}[)-]?\\d{8})|(1[0-9]{10})", message = "{bankPhone.illegal}")
    @NotBlank(message = "{bankPhone.illegal}")
    @Column(name = "bank_phone")
    private String bank_phone;
    @Pattern(regexp = "^[A-Za-z0-9\u4E00-\u9FFF]{2,}$", message = "{bankBranch.illegal}")
    @NotBlank(message = "{bankBranch.illegal}")
    @Column(name = "bank_branch")
    private String bank_branch;
    @Column(name = "pic_id")
    private Integer picId;
    @Column(name = "act_status")
    private Integer act_status;//激活状态

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_address() {
        return bank_address;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }

    public String getBank_phone() {
        return bank_phone;
    }

    public void setBank_phone(String bank_phone) {
        this.bank_phone = bank_phone;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
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
