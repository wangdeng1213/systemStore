package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by my on 2015/4/22.
 */
@Entity
@Table(name="t_actual_repayment_plan")
public class ActualRepaymentPlan extends BaseEntity{

    private static final long serialVersionUID = 8022402189778923123L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;//实际付收益编号
    @Column(name = "product_id")
    private Integer productId;//标的编号
    @Column(name = "actual_repayment_term")
    private Integer actual_repayment_term;//收益第几期
    @Column(name = "actual_repayment_time")
    private Timestamp actual_repayment_time;//付收益时间
    @Column(name = "user_id")
    private Integer user_id;//用户ID
    @Column(name = "actual_money")
    private BigDecimal actual_money;//应付收益金额
    @Column(name = "description")
    private String description;//描述
    @Column(name = "act_status")
    private Integer act_status;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "name")
    private  String name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getActual_repayment_term() {
        return actual_repayment_term;
    }

    public void setActual_repayment_term(Integer actual_repayment_term) {
        this.actual_repayment_term = actual_repayment_term;
    }

    public Timestamp getActual_repayment_time() {
        return actual_repayment_time;
    }

    public void setActual_repayment_time(Timestamp actual_repayment_time) {
        this.actual_repayment_time = actual_repayment_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getActual_money() {
        return actual_money;
    }

    public void setActual_money(BigDecimal actual_money) {
        this.actual_money = actual_money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
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
