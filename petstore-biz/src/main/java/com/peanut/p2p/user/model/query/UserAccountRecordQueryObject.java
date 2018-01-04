package com.peanut.p2p.user.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.user.model.entity.UserAccountRecord;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by my on 2015/2/5.
 */
@QueryEntity(entityClazz = UserAccountRecord.class,alias = "uar")
public class UserAccountRecordQueryObject extends QueryObject{

    private static final long serialVersionUID = -7173018356819463581L;
    private Integer id;
    @QueryField(name ="userId", logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String userId;
    @QueryField(name = "accountId",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String  accountId;
    @QueryField(name = "rechanrgeMoney",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal rechanrgeMoney;

    private BigDecimal rechanrgeType;
    @QueryField(name = "rechanrge_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] rechanrgeTimes;
    @QueryField(name = "rechanrge_receive_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] rechanrgeReceiveTimes;
    @QueryField(name = "description",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String description;
    @QueryField(name = "update_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] updateTimes;
    @QueryField(name = "update_by",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String updateBy;
    @QueryField(name = "bank_name",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String bankName;
    @QueryField(name = "bank_no",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String bankNo;
    @QueryField(name = "bank_address",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String bankAddress;
    @QueryField(name = "bank_tel",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String bankTel;
    @QueryField(name = "create_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] createtimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getRechanrgeMoney() {
        return rechanrgeMoney;
    }

    public void setRechanrgeMoney(BigDecimal rechanrgeMoney) {
        this.rechanrgeMoney = rechanrgeMoney;
    }

    public BigDecimal getRechanrgeType() {
        return rechanrgeType;
    }

    public void setRechanrgeType(BigDecimal rechanrgeType) {
        this.rechanrgeType = rechanrgeType;
    }

    public String[] getRechanrgeTimes() {
        return rechanrgeTimes;
    }

    public void setRechanrgeTimes(String[] rechanrgeTimes) {
        this.rechanrgeTimes = rechanrgeTimes;
    }

    public String[] getRechanrgeReceiveTimes() {
        return rechanrgeReceiveTimes;
    }

    public void setRechanrgeReceiveTimes(String[] rechanrgeReceiveTimes) {
        this.rechanrgeReceiveTimes = rechanrgeReceiveTimes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getUpdateTimes() {
        return updateTimes;
    }

    public void setUpdateTimes(String[] updateTimes) {
        this.updateTimes = updateTimes;
    }

    public String[] getCreatetimes() {
        return createtimes;
    }

    public void setCreatetimes(String[] createtimes) {
        this.createtimes = createtimes;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankTel() {
        return bankTel;
    }

    public void setBankTel(String bankTel) {
        this.bankTel = bankTel;
    }

}
