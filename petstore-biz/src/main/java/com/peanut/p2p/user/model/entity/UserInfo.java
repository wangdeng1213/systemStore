package com.peanut.p2p.user.model.entity;

import com.peanut.entity.BaseEntity;
import com.peanut.p2p.validation.annotations.DateFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by my on 2015/2/5.
 */
@Entity
@Table(name = "user_info")
@Cache(region = "user_infoCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = -2464547638630516980L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Integer id; //user_id
    @Column(name = "user_name",length = 50)
    private String userName; //user_name
    @Column(name = "password",length = 32)
    private String password; //password
    @Column(name = "name",length = 50)
    private String name; //name
    @Column(name = "sex")
    private Integer sex; //sex
    @Column(name = "idcard_type",length = 10)
    private String idcardType; //idcard_type
    @Column(name = "idcard",length = 18)
    private String idcard; //idcard
    @Column(name = "rele_documents",length = 18)
    private String releDocuments; //rele_documents
    @Column(name = "address",length = 100)
    private String address; //address
    @Column(name = "mobilephone",length = 11)
    private String mobilephone; //mobilephone
    @Column(name = "telephone",length = 20)
    private String telephone; //telephone
    @Column(name = "email",length = 100)
    private String email; //email
    @Column(name = "qq",length = 20)
    private String qq; //qq
    @DateFormat(message = "{birthday.date.error}")
    @Column(name = "birthday")
    private Date birthday; //birthday
    @Column(name = "act_status")
    private Integer actStatus; //act_status
    @Column(name = "phone_auth")
    private Integer phoneAuth; //phone_auth
    @Column(name = "idcard_auth")
    private Integer idcardAuth; //idcard_auth
    @Column(name = "email_auth")
    private Integer emailAuth; //email_auth
    @Column(name = "update_by",length = 100)
    private String updateBy; //update_by
    @Column(name = "update_time",length = 100)
    private Date updateTime; //update_time
    @Column(name = "descriptions",length = 200)
    private String descriptions;
    @Column(name = "pay_password",length = 50)
    private String payPassword;

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcardType() {
        return idcardType;
    }

    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getReleDocuments() {
        return releDocuments;
    }

    public void setReleDocuments(String releDocuments) {
        this.releDocuments = releDocuments;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getActStatus() {
        return actStatus;
    }

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    public Integer getPhoneAuth() {
        return phoneAuth;
    }

    public void setPhoneAuth(Integer phoneAuth) {
        this.phoneAuth = phoneAuth;
    }

    public Integer getIdcardAuth() {
        return idcardAuth;
    }

    public void setIdcardAuth(Integer idcardAuth) {
        this.idcardAuth = idcardAuth;
    }

    public Integer getEmailAuth() {
        return emailAuth;
    }

    public void setEmailAuth(Integer emailAuth) {
        this.emailAuth = emailAuth;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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
