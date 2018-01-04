package com.peanut.p2p.code.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.code.model.entity.BankCard;

/**
 * Created by my on 2015/5/6.
 */
@QueryEntity(entityClazz = BankCard.class,alias = "bankC")
public class BankCardQueryObject extends QueryObject{

    private static final long serialVersionUID = -7518717522586812682L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "accountId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer accountId;
    @QueryField(name = "bankId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer bankId;
    @QueryField(name = "cardNo", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String cardNo;
    @QueryField(name = "bankNo", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bankNo;
    @QueryField(name = "bankName", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bankName;
    @QueryField(name = "bankBranch", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bankBranch;
    @QueryField(name = "userId", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer userId;
    @QueryField(name = "userName", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String userName;
    @QueryField(name = "actStatus", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer actStatus;
    @QueryField(name = "tail_no", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String tail_no;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getActStatus() {
        return actStatus;
    }

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    public String getTail_no() {
        return tail_no;
    }

    public void setTail_no(String tail_no) {
        this.tail_no = tail_no;
    }
}
