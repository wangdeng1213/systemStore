package com.peanut.p2p.user.model.query;
import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.user.model.entity.InvestRecord;
import org.joda.time.DateTime;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by my on 2015/2/5.
 */
@QueryEntity(entityClazz = InvestRecord.class,alias = "ir")
public class InvestRecordQueryObject extends QueryObject {

    private static final long serialVersionUID = -1743477117170284346L;
    private Integer id;
    @QueryField(name = "productId",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String productId;
    @QueryField(name = "userId",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String userId;
    @QueryField(name = "investMoney",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal investMoney;

    private BigDecimal income;

    private String description;
    @QueryField(name = "investTime",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private Date[] investTimes;
    @QueryField(name = "repayTime",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] repayTimes;
    @QueryField(name = "finish",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer finish;
    @QueryField(name = "orderId",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer orderId;
    @QueryField(name = "productName",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String productName;//产品名称
    @QueryField(name = "term",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Integer term;//总期数
    @QueryField(name = "currentIncome",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal currentIncome;//已收收益
    @QueryField(name = "currentTerm",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Integer currentTerm;//当前期数
    @QueryField(name = "nextTerm",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Integer nextTerm;//下一期数
    @QueryField(name = "act_status",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer act_status;
    @QueryField(name = "dueIn",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal dueIn;
    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(BigDecimal investMoney) {
        this.investMoney = investMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date[] getInvestTimes() {
        return investTimes;
    }

    public void setInvestTimes(Date[] investTimes) {
        this.investTimes = investTimes;
    }

    public String[] getRepayTimes() {
        return repayTimes;
    }

    public void setRepayTimes(String[] repayTimes) {
        this.repayTimes = repayTimes;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(BigDecimal currentIncome) {
        this.currentIncome = currentIncome;
    }

    public Integer getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(Integer currentTerm) {
        this.currentTerm = currentTerm;
    }

    public Integer getNextTerm() {
        return nextTerm;
    }

    public void setNextTerm(Integer nextTerm) {
        this.nextTerm = nextTerm;
    }

    public BigDecimal getDueIn() {
        return dueIn;
    }

    public void setDueIn(BigDecimal dueIn) {
        this.dueIn = dueIn;
    }
}
