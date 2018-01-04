
package com.peanut.p2p.products.model.entity;


import com.peanut.workflow.domain.ProcessInstanceEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * Created by my on 2015/4/11.
 */

@Entity
@Table(name = "borrow_tran")
public class BorrowTran extends ProcessInstanceEntity {
    private static final long serialVersionUID = 5388754794655812496L;


   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "", nullable = false)
    private Integer borrow_tran_id;//借款交易编号*//*



    private Integer user_id;//用户编号


    private BigDecimal borrow_money;//借款金额


    private String borrow_description;//借款描述


    private String borrow_time;//   借款时间

    private String borrow_title;//借款标题

    private Integer borrow_term;//借款期限

    private String deal_status;//借款状态,0:风控正在审核；1：审核成功等待总裁审批；2；审核失败不准许再次申请；f1：风控审核失败重新借款申请；f2：风控2次失败重新填写借款申请；3：所有审核通过，投标开始。4：流标；5：还款中;6: 交易成功


    private Integer order_id;//借款订单编号


    private String constract_id;//交易生成合同


    private String ip;//IP


    private Date notify_time;//通知时间


    private String notify_type;//通知方式


    private String remark;//备注

    private String verify_user;//审核人

    private Timestamp verify_time;//审核时间

    private String approval_opinion;//审核意见

    private Long riskinfoid;//风控ID

    private String fk_user;//风控审核人

    private Timestamp fk_time;//风控审核时间

    private String fk_opinion;//风控审核意见

    private Integer act_status;//激活状态
    @Column(name = "act_status")
    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrow_tran_id", nullable = false)
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    @Column(name = "process_instance_id")
    public String getProcessInstanceId() {
        return super.getProcessInstanceId();
    }

    @Override
    public void setProcessInstanceId(String processInstanceId) {
        super.setProcessInstanceId(processInstanceId);
    }

    @Override
    @Transient
    public String getApplyUserId() {
        return user_id == null ? StringUtils.EMPTY : Integer.toString(user_id);
    }

    @Override
    public void setApplyUserId(String applyUserId) {
        super.setApplyUserId(applyUserId);
    }

    @Column(name = "riskinfoid")
    public Long getRiskinfoid() {
        return riskinfoid;
    }

    public void setRiskinfoid(Long riskinfoid) {
        this.riskinfoid = riskinfoid;
    }

    @Column(name = "borrow_title")
    public String getBorrow_title() {
        return borrow_title;
    }

    public void setBorrow_title(String borrow_title) {
        this.borrow_title = borrow_title;
    }

    @Column(name = "borrow_term")
    public Integer getBorrow_term() {
        return borrow_term;
    }

    public void setBorrow_term(Integer borrow_term) {
        this.borrow_term = borrow_term;
    }

    @Column(name = "verify_user")
    public String getVerify_user() {
        return verify_user;
    }

    public void setVerify_user(String verify_user) {
        this.verify_user = verify_user;
    }

    @Column(name = "verify_time")
    public Timestamp getVerify_time() {
        return verify_time;
    }

    public void setVerify_time(Timestamp verify_time) {
        this.verify_time = verify_time;
    }

    @Column(name = "approval_opinion")
    public String getApproval_opinion() {
        return approval_opinion;
    }

    public void setApproval_opinion(String approval_opinion) {
        this.approval_opinion = approval_opinion;
    }

    @Column(name = "user_id", nullable = false)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Column(name = "borrow_money")
    public BigDecimal getBorrow_money() {
        return borrow_money;
    }

    public void setBorrow_money(BigDecimal borrow_money) {
        this.borrow_money = borrow_money;
    }

    @Column(name = "borrow_description")
    public String getBorrow_description() {
        return borrow_description;
    }

    public void setBorrow_description(String borrow_description) {
        this.borrow_description = borrow_description;
    }

    @Column(name = "borrow_time")
    public String getBorrow_time() {
        return borrow_time;
    }

    public void setBorrow_time(String borrow_time) {
        this.borrow_time = borrow_time;
    }

    @Column(name = "deal_status")
    public String getDeal_status() {
        return deal_status;
    }

    public void setDeal_status(String deal_status) {
        this.deal_status = deal_status;
    }

    @Column(name = "order_id")
    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    @Column(name = "constract_id")
    public String getConstract_id() {
        return constract_id;
    }

    public void setConstract_id(String constract_id) {
        this.constract_id = constract_id;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "notify_time")
    public Date getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(Date notify_time) {
        this.notify_time = notify_time;
    }

    @Column(name = "notify_type")
    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(name = "fk_user")
    public String getFk_user() {
        return fk_user;
    }

    public void setFk_user(String fk_user) {
        this.fk_user = fk_user;
    }
    @Column(name = "fk_time")
    public Timestamp getFk_time() {
        return fk_time;
    }

    public void setFk_time(Timestamp fk_time) {
        this.fk_time = fk_time;
    }
    @Column(name = "fk_opinion")
    public String getFk_opinion() {
        return fk_opinion;
    }

    public void setFk_opinion(String fk_opinion) {
        this.fk_opinion = fk_opinion;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
