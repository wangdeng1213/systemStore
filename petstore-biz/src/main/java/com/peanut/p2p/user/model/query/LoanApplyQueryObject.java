package com.peanut.p2p.user.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.user.model.entity.LoanApply;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by my on 2015/6/12.
 */
@QueryEntity(entityClazz = LoanApply.class,alias = "la")
public class LoanApplyQueryObject extends QueryObject{

    private static final long serialVersionUID = -1113796856796216869L;
    @QueryField(name = "id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "name",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String name;//姓名
    @QueryField(name = "phone",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String  phone;//手机号
    @QueryField(name = "amount",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal amount;//借款金额
    @QueryField(name = "email",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String email;//邮箱
    @QueryField(name = "applytime",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Timestamp applytime;//申请时间
    @QueryField(name = "act_status",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer act_status;//激活状态0:未激活1:已激活

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public Timestamp getApplytime() {
        return applytime;
    }

    public void setApplytime(Timestamp applytime) {
        this.applytime = applytime;
    }

}
