package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.BoActualRepayment;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by my on 2015/4/11.
 */
@QueryEntity(entityClazz = BoActualRepayment.class, alias = "actualRepayment")
public class BoActualRepaymentQueryObject extends QueryObject {

    private static final long serialVersionUID = -8397007254022383204L;
    @QueryField(name = "id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer id;//实际还款编号
    @QueryField(name = "product_id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer product_id;//标的编号
    @QueryField(name = "product_name",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String product_name;//标的名称
    @QueryField(name = "repayment_term",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer repayment_term;//还款第几期
    @QueryField(name = "repayment_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] repayment_times;//还款时间

    private Integer overdue;//逾期天数
    @QueryField(name = "isfull",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer isfull;//是否满额还款1：满额2：还部分
    @QueryField(name = "overdue_amount",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal overdue_amount;//逾期金额
    @QueryField(name = "paid_amount",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal paid_amount;//已还款总额
    @QueryField(name = "actual_money",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private BigDecimal actual_money;//实际还款金额
    public Integer getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getRepayment_times() {
        return repayment_times;
    }

    public void setRepayment_times(String[] repayment_times) {
        this.repayment_times = repayment_times;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getRepayment_term() {
        return repayment_term;
    }

    public void setRepayment_term(Integer repayment_term) {
        this.repayment_term = repayment_term;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getIsfull() {
        return isfull;
    }

    public void setIsfull(Integer isfull) {
        this.isfull = isfull;
    }

    public BigDecimal getOverdue_amount() {
        return overdue_amount;
    }

    public void setOverdue_amount(BigDecimal overdue_amount) {
        this.overdue_amount = overdue_amount;
    }

    public BigDecimal getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(BigDecimal paid_amount) {
        this.paid_amount = paid_amount;
    }

    public BigDecimal getActual_money() {
        return actual_money;
    }

    public void setActual_money(BigDecimal actual_money) {
        this.actual_money = actual_money;
    }
}
