package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.ActualRepaymentPlan;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by my on 2015/4/22.
 */
@QueryEntity(entityClazz = ActualRepaymentPlan.class, alias = "actual_repayment")
public class ActualRepaymentPlanQueryObject extends QueryObject {

    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id;//实际付收益编号
    @QueryField(name = "productId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer productId;//标的编号
    @QueryField(name = "actual_repayment_term", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer actual_repayment_term;//收益第几期
    @QueryField(name = "actual_repayment_time", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Timestamp actual_repayment_time;//付收益时间
    @QueryField(name = "user_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer user_id;//用户ID
    @QueryField(name = "actual_money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal actual_money;//应付收益金额
    @QueryField(name = "description", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String description;//描述
    @QueryField(name = "act_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer act_status;
    @QueryField(name = "product_name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String product_name;
    @QueryField(name = "name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private  String name;
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
}
