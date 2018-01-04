package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.VBorrowRepaymentPlan;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by my on 2015/5/18.
 */
@QueryEntity(entityClazz = VBorrowRepaymentPlan.class,alias = "vBorrowPlan")
public class VBorrowRepaymentPlanQueryObject extends QueryObject {
    private static final long serialVersionUID = 3306041236015373417L;
    @QueryField(name = "id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer id;//还款计划编号
    @QueryField(name = "product_name",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String product_name;//借款标题
    @QueryField(name = "total_money",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal total_money;//借款总额
    @QueryField(name = "year_rate",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal year_rate;//年化收益
    @QueryField(name = "type",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String type;//债券S:散标U:U计划
    @QueryField(name = "over_term",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer over_term;//借款期限
    @QueryField(name = "user_id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer user_id;//借款人编号
    @QueryField(name = "rep_total_money",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal rep_total_money;//应还总额=本金+利息+服务费
    @QueryField(name = "repayment_startperiod",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] repayment_startperiods;//开始还款时间
    @QueryField(name = "terminal_money",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private BigDecimal terminal_money;//每期应还款额
    @QueryField(name = "repayment_type",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private String repayment_type;//还款类型
    @QueryField(name = "finish_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[]  finish_times;//结束时间

    private Integer payment_id;//还款银行卡ID
    private String bank_name;
    private String bank_branch;
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

    public String[] getRepayment_startperiods() {
        return repayment_startperiods;
    }

    public void setRepayment_startperiods(String[] repayment_startperiods) {
        this.repayment_startperiods = repayment_startperiods;
    }

    public String[] getFinish_times() {
        return finish_times;
    }

    public void setFinish_times(String[] finish_times) {
        this.finish_times = finish_times;
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
}
