package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.BorrowOrderInfo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by my on 2015/4/11.
 */
@QueryEntity(entityClazz = BorrowOrderInfo.class, alias = "borrowOrderInfo")
public class BorrowOrderInfoQueryObject extends QueryObject {

    private static final long serialVersionUID = -8397007254022383204L;

    @QueryField(name = "borrow_order_id",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private Integer borrow_order_id;//	借款订单编号
    @QueryField(name = "user_id",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String user_id;//借款人编号

    private String borrow_title;//	借款标题
    @QueryField(name = "borrow_money",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal borrow_money;//借款金额

    private String borrow_description;//借款描述
    @QueryField(name = "borrow_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] borrow_times;//借款时间
    @QueryField(name = "borrow_term",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer borrow_term;//借款期限s

    private BigDecimal surplus;//剩余还款额

    private Integer success;//借款状态

    private String order_type;

    private String client_version;

    private String loanorder_status;

    private String ip;

    private String attribute;

    private String realname;

    private BigDecimal income_money;

    private String id_card;

    private Integer period_id;//借款期限ID

    public Integer getBorrow_order_id() {
        return borrow_order_id;
    }

    public void setBorrow_order_id(Integer borrow_order_id) {
        this.borrow_order_id = borrow_order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBorrow_title() {
        return borrow_title;
    }

    public void setBorrow_title(String borrow_title) {
        this.borrow_title = borrow_title;
    }

    public BigDecimal getBorrow_money() {
        return borrow_money;
    }

    public void setBorrow_money(BigDecimal borrow_money) {
        this.borrow_money = borrow_money;
    }

    public String getBorrow_description() {
        return borrow_description;
    }

    public void setBorrow_description(String borrow_description) {
        this.borrow_description = borrow_description;
    }

    public String[] getBorrow_times() {
        return borrow_times;
    }

    public void setBorrow_times(String[] borrow_times) {
        this.borrow_times = borrow_times;
    }

    public Integer getBorrow_term() {
        return borrow_term;
    }

    public void setBorrow_term(Integer borrow_term) {
        this.borrow_term = borrow_term;
    }

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getClient_version() {
        return client_version;
    }

    public void setClient_version(String client_version) {
        this.client_version = client_version;
    }

    public String getLoanorder_status() {
        return loanorder_status;
    }

    public void setLoanorder_status(String loanorder_status) {
        this.loanorder_status = loanorder_status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public BigDecimal getIncome_money() {
        return income_money;
    }

    public void setIncome_money(BigDecimal income_money) {
        this.income_money = income_money;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Integer getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(Integer period_id) {
        this.period_id = period_id;
    }
}
