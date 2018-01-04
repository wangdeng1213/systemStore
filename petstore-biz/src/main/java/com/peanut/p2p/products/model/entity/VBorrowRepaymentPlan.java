package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by my on 2015/5/18.
 */
@Entity
@Table(name = "v_borrow_repayment_plan")
public class VBorrowRepaymentPlan extends BaseEntity{
    private static final long serialVersionUID = -7464054494877008215L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_id",nullable = false)
    private Integer id;//还款计划编号
    @Column(name = "product_name")
    private String product_name;//借款标题
    @Column(name = "total_money")
    private BigDecimal total_money;//借款总额
    @Column(name = "year_rate")
    private BigDecimal year_rate;//年化收益
    @Column(name = "type")
    private String type;//债券S:散标U:U计划
    @Column(name = "over_term")
    private Integer over_term;//借款期限
    @Column(name = "user_id")
    private Integer user_id;//借款人编号
    @Column(name = "rep_total_money")
    private BigDecimal rep_total_money;//应还总额=本金+利息+服务费
    @Column(name = "repayment_startperiod")
    private String repayment_startperiod;//开始还款时间
    @Column(name = "terminal_money")
    private BigDecimal terminal_money;//每期应还款额
    @Column(name = "repayment_type")
    private String repayment_type;//还款类型
    @Column(name = "finish_time")
    private String finish_time;//结束时间
    @Column(name = "payment_id")
    private Integer payment_id;//还款银行卡ID
    @Column(name = "bank_name")
    private String bank_name;
    @Column(name = "bank_branch")
    private String bank_branch;
    @Column(name = "bank_card_no")
    private String bank_card_no;//卡号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public BigDecimal getYear_rate() {
        return year_rate;
    }

    public void setYear_rate(BigDecimal year_rate) {
        this.year_rate = year_rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOver_term() {
        return over_term;
    }

    public void setOver_term(Integer over_term) {
        this.over_term = over_term;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getRep_total_money() {
        return rep_total_money;
    }

    public void setRep_total_money(BigDecimal rep_total_money) {
        this.rep_total_money = rep_total_money;
    }

    public BigDecimal getTerminal_money() {
        return terminal_money;
    }

    public void setTerminal_money(BigDecimal terminal_money) {
        this.terminal_money = terminal_money;
    }

    public String getRepayment_type() {
        return repayment_type;
    }

    public void setRepayment_type(String repayment_type) {
        this.repayment_type = repayment_type;
    }

    public String getRepayment_startperiod() {
        return repayment_startperiod;
    }

    public void setRepayment_startperiod(String repayment_startperiod) {
        this.repayment_startperiod = repayment_startperiod;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }

    public String getBank_card_no() {
        return bank_card_no;
    }

    public void setBank_card_no(String bank_card_no) {
        this.bank_card_no = bank_card_no;
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
