package com.peanut.p2p.user.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.entity.BaseEntity;
import com.peanut.p2p.user.model.entity.VInvestRecord;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by my on 2015/2/5.
 */
@QueryEntity(entityClazz = VInvestRecord.class,alias = "vir")
public class VInvestRecordQueryObject extends QueryObject{

    private static final long serialVersionUID = 5302779634644111915L;
    @QueryField(name = "id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "productId",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String productId;
    @QueryField(name = "investMoney",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal investMoney;
    @QueryField(name = "income",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal income;
    @QueryField(name = "investTime",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String [] investTimes;
    @QueryField(name = "productName",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String productName;//产品名称
    @QueryField(name = "tztimes",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Long tztimes;//投资总次数
    @QueryField(name = "tzperson",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Long tzperson;//投资总人数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(BigDecimal investMoney) {
        this.investMoney = investMoney;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String[] getInvestTimes() {
        return investTimes;
    }

    public void setInvestTimes(String[] investTimes) {
        this.investTimes = investTimes;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getTztimes() {
        return tztimes;
    }

    public void setTztimes(Long tztimes) {
        this.tztimes = tztimes;
    }

    public Long getTzperson() {
        return tzperson;
    }

    public void setTzperson(Long tzperson) {
        this.tzperson = tzperson;
    }

}
