package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.component.QueryObject;
import com.peanut.p2p.products.model.entity.BorrowStat;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Administrator on 2015/4/11.
 */
@QueryEntity(entityClazz = BorrowStat.class, alias = "borrowStat")
public class BorrowStatQueryObject extends QueryObject {

    private static final long serialVersionUID = -8397007254022383204L;

    private Integer stat_id;//统计编号

    private Integer product_id;//标的编号

    private BigDecimal acutal_rep_total;//实际还款总额=本金+利息+服务费+罚息

    private Integer rep_terms;//还款期数

    private Date[] finish_time;//满标日期

    private Date[] arrive_date;//到账日期

    private BigDecimal cost_money;//借款利息

    private BigDecimal demurrage;//逾期费

    private BigDecimal early_repayment_default_payment;//提前还款违约金

    private BigDecimal loan_management_fee;//借款管理费

    private BigDecimal principal;//待还本金

    private BigDecimal interest;//待还利息

    private BigDecimal late_fee;//待还逾期费用

    private BigDecimal management_fee;//待还借款管理费

    private BigDecimal a_principal;//已还本金

    private BigDecimal a_interest;//已还利息

    private BigDecimal a_late_fee;//已交逾期费用

    private BigDecimal t_default_payment;//已交提前还款违约金

    private BigDecimal a_loan_management_fee;//已交借款管理费

    private Integer overdue_days;//总逾期天数

    private String constract_id;//此合同为实际借款金额到账最终借款合同


    public Integer getStat_id() {
        return stat_id;
    }

    public void setStat_id(Integer stat_id) {
        this.stat_id = stat_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public BigDecimal getAcutal_rep_total() {
        return acutal_rep_total;
    }

    public void setAcutal_rep_total(BigDecimal acutal_rep_total) {
        this.acutal_rep_total = acutal_rep_total;
    }

    public Integer getRep_terms() {
        return rep_terms;
    }

    public void setRep_terms(Integer rep_terms) {
        this.rep_terms = rep_terms;
    }

    public Date[] getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date[] finish_time) {
        this.finish_time = finish_time;
    }

    public Date[] getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(Date[] arrive_date) {
        this.arrive_date = arrive_date;
    }

    public BigDecimal getCost_money() {
        return cost_money;
    }

    public void setCost_money(BigDecimal cost_money) {
        this.cost_money = cost_money;
    }

    public BigDecimal getDemurrage() {
        return demurrage;
    }

    public void setDemurrage(BigDecimal demurrage) {
        this.demurrage = demurrage;
    }

    public BigDecimal getEarly_repayment_default_payment() {
        return early_repayment_default_payment;
    }

    public void setEarly_repayment_default_payment(BigDecimal early_repayment_default_payment) {
        this.early_repayment_default_payment = early_repayment_default_payment;
    }

    public BigDecimal getLoan_management_fee() {
        return loan_management_fee;
    }

    public void setLoan_management_fee(BigDecimal loan_management_fee) {
        this.loan_management_fee = loan_management_fee;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getLate_fee() {
        return late_fee;
    }

    public void setLate_fee(BigDecimal late_fee) {
        this.late_fee = late_fee;
    }

    public BigDecimal getManagement_fee() {
        return management_fee;
    }

    public void setManagement_fee(BigDecimal management_fee) {
        this.management_fee = management_fee;
    }

    public BigDecimal getA_principal() {
        return a_principal;
    }

    public void setA_principal(BigDecimal a_principal) {
        this.a_principal = a_principal;
    }

    public BigDecimal getA_interest() {
        return a_interest;
    }

    public void setA_interest(BigDecimal a_interest) {
        this.a_interest = a_interest;
    }

    public BigDecimal getA_late_fee() {
        return a_late_fee;
    }

    public void setA_late_fee(BigDecimal a_late_fee) {
        this.a_late_fee = a_late_fee;
    }

    public BigDecimal getT_default_payment() {
        return t_default_payment;
    }

    public void setT_default_payment(BigDecimal t_default_payment) {
        this.t_default_payment = t_default_payment;
    }

    public BigDecimal getA_loan_management_fee() {
        return a_loan_management_fee;
    }

    public void setA_loan_management_fee(BigDecimal a_loan_management_fee) {
        this.a_loan_management_fee = a_loan_management_fee;
    }

    public Integer getOverdue_days() {
        return overdue_days;
    }

    public void setOverdue_days(Integer overdue_days) {
        this.overdue_days = overdue_days;
    }

    public String getConstract_id() {
        return constract_id;
    }

    public void setConstract_id(String constract_id) {
        this.constract_id = constract_id;
    }
}
