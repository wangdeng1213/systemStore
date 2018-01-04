package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.VActualRepayment;
import com.peanut.p2p.products.model.entity.VRepaymentPlan;

import java.math.BigDecimal;

/**
 * Created by my on 2015/5/6.
 */
@QueryEntity(entityClazz = VActualRepayment.class, alias = "var")
public class VActualRepaymentQueryObject extends QueryObject {

    private static final long serialVersionUID = -1839109044156539941L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Long id;
    @QueryField(name = "productName", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String productName;
    @QueryField(name = "yearRate", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private BigDecimal yearRate;
    @QueryField(name = "totalMoney", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private BigDecimal totalMoney;
    @QueryField(name = "overTerm", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private Integer overTerm;
    @QueryField(name = "overTerm", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String type;
    @QueryField(name = "userId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer userId;
    @QueryField(name = "investMoney", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal investMoney;
    @QueryField(name = "repaymentTime", logicType = LogicType.and, genericOperator = GenericOperator.BETWEEN)
    private String[] repaymentTimes;
    @QueryField(name = "money", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private BigDecimal money;
    @QueryField(name = "bankName", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bankName;
    @QueryField(name = "bankBranch", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bankBranch;
    @QueryField(name = "cardNo", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String cardNo;
    @QueryField(name = "userName", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private  String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getOverTerm() {
        return overTerm;
    }

    public void setOverTerm(Integer overTerm) {
        this.overTerm = overTerm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(BigDecimal investMoney) {
        this.investMoney = investMoney;
    }

    public String[] getRepaymentTimes() {
        return repaymentTimes;
    }

    public void setRepaymentTimes(String[] repaymentTimes) {
        this.repaymentTimes = repaymentTimes;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
