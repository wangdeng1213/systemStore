package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by my on 2015/5/20.
 */
@Entity
@Table(name="history_record")
public class HistoryRecord extends BaseEntity{
    private static final long serialVersionUID = 109783413372673160L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;//系统登录Id
    @Column(name = "his_end_time")
    private Timestamp hisEndTime;//历史结束时间
    @Column(name = "now_end_time")
    private Timestamp nowEndTime;//现在结束时间
    @Column(name = "product_id")
    private Long productId;//标的ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getHisEndTime() {
        return hisEndTime;
    }

    public void setHisEndTime(Timestamp hisEndTime) {
        this.hisEndTime = hisEndTime;
    }

    public Timestamp getNowEndTime() {
        return nowEndTime;
    }

    public void setNowEndTime(Timestamp nowEndTime) {
        this.nowEndTime = nowEndTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
