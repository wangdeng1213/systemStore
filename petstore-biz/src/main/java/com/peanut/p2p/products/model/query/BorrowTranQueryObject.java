package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.BorrowTran;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by my on 2015/4/11.
 */
@QueryEntity(entityClazz = BorrowTran.class, alias = "borrowTran")
public class BorrowTranQueryObject extends QueryObject {

    private static final long serialVersionUID = -8397007254022383204L;

    @QueryField(name = "id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Long id;//借款交易编号

    @QueryField(name = "user_id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer user_id;//用户编号

    @QueryField(name = "borrow_money",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal borrow_money;//借款金额
    @QueryField(name = "borrow_title",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String borrow_title;//借款标题
    private String borrow_description;//借款描述

    @QueryField(name = "borrow_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] borrow_times;//	借款时间


    private String bank_name;//银行名称


    private String bank_no;//银行编号


    private Integer loanorder_no;

    @QueryField(name = "deal_status",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String deal_status;//借款状态,0:风控正在审核；1：审核成功等待总裁审批；2；审核失败不准许再次申请；f1：风控审核失败重新借款申请；f2：风控2次失败重新填写借款申请；3：所有审核通过，投标开始。4：流标；5：还款中;6: 交易成功


    private Integer order_id;//借款订单编号


    private String constract_id;//交易生成合同


    private String ip;//IP


    private Date[] notify_time;//通知时间


    private String notify_type;//通知方式


    private String remark;//备注
    @QueryField(name = "act_status",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer act_status;//激活状态

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public String getBorrow_title() {
        return borrow_title;
    }

    public void setBorrow_title(String borrow_title) {
        this.borrow_title = borrow_title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }

    public Integer getLoanorder_no() {
        return loanorder_no;
    }

    public void setLoanorder_no(Integer loanorder_no) {
        this.loanorder_no = loanorder_no;
    }

    public String getDeal_status() {
        return deal_status;
    }

    public void setDeal_status(String deal_status) {
        this.deal_status = deal_status;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getConstract_id() {
        return constract_id;
    }

    public void setConstract_id(String constract_id) {
        this.constract_id = constract_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date[] getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(Date[] notify_time) {
        this.notify_time = notify_time;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
