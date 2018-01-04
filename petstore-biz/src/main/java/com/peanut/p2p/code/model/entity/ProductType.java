package com.peanut.p2p.code.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by my on 2015/4/10.
 */
@Entity
@Table(name = "product_type")
public class ProductType extends BaseEntity{

    private static final long serialVersionUID = 3738126299607180478L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Pattern(regexp = "^[A-Za-z]$", message = "{productCodeName.illegal}")
    @NotEmpty(message = "{productCodeName.illegal}")
    @Column(name = "product_type_code")
    private String product_type_code;//标的类型编号
    @Pattern(regexp = "^[A-Za-z0-9\u4E00-\u9FFF]{2,}$", message = "{productTypeName.illegal}")
    @NotEmpty(message = "{productTypeName.illegal}")
    @Column(name = "product_type_name")
    private String product_type_name;//标的类型名称
    @Column(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_type_code() {
        return product_type_code;
    }

    public void setProduct_type_code(String product_type_code) {
        this.product_type_code = product_type_code;
    }

    public String getProduct_type_name() {
        return product_type_name;
    }

    public void setProduct_type_name(String product_type_name) {
        this.product_type_name = product_type_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
