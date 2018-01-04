package com.peanut.p2p.user.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by my on 2015/2/5.
 */
@Entity
@Table(name = "user_privilege")
@Cache(region = "user_privilegeCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserPrivilege extends BaseEntity {

    private static final long serialVersionUID = 8373177274151991356L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "privilege_id", nullable = false)
    private Integer id;
    @Column(name = "level_no")
    private Integer levelNo;
    @Column(name = "credit",length = 20)
    private String credit;
    @Column(name = "activity",length = 50)
    private String activity;
    @Column(name = "attribute1",length = 100)
    private String attribute1;
    @Column(name = "attribute2",length = 100)
    private String attribute2;
    @Column(name = "description",length = 200)
    private String description;
    @Column(name = "user_id",length = 100)
    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Integer levelNo) {
        this.levelNo = levelNo;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
