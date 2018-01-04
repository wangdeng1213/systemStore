package com.peanut.p2p.user.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.user.model.entity.UserAccount;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by my on 2015/2/5.
 */
@QueryEntity(entityClazz = UserAccount.class,alias = "ua")
public class UserAccountQueryObject extends QueryObject{

    private static final long serialVersionUID = -5767119255821666467L;
    private Integer id;
    @QueryField(name = "userId",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer userId;
    @QueryField(name = "totalMoney",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal totalMoney;

    private BigDecimal currentMoney;

    private BigDecimal collectedMoney;

    private BigDecimal frozenMoney;

    private BigDecimal drawMoney;
    @QueryField(name = "createTime",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] createTimes;
    @QueryField(name = "createT",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] createT;


    private String payPassword;

    @QueryField(name = "dueIn",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal dueIn;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public BigDecimal getCollectedMoney() {
        return collectedMoney;
    }

    public void setCollectedMoney(BigDecimal collectedMoney) {
        this.collectedMoney = collectedMoney;
    }

    public BigDecimal getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(BigDecimal frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public BigDecimal getDrawMoney() {
        return drawMoney;
    }

    public void setDrawMoney(BigDecimal drawMoney) {
        this.drawMoney = drawMoney;
    }

    public String[] getCreateTimes() {
        return createTimes;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCreateTimes(String[] createTimes) {
        this.createTimes = createTimes;
    }

    public String[] getCreateT() {
        return createT;
    }

    public void setCreateT(String[] createT) {
        this.createT = createT;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public BigDecimal getDueIn() {
        return dueIn;
    }

    public void setDueIn(BigDecimal dueIn) {
        this.dueIn = dueIn;
    }
}
