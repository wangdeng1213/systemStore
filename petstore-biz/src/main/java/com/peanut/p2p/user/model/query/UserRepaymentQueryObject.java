package com.peanut.p2p.user.model.query;
import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.user.model.entity.UserRepayment;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by my on 2015/2/5.
 */
@QueryEntity(entityClazz = UserRepayment.class,alias = "ur")
public class UserRepaymentQueryObject extends QueryObject {

    private static final long serialVersionUID = 3920008367426746496L;
    private Integer id;
    @QueryField(name = "begin_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] beginTimes;
    @QueryField(name = "user_id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer userId;
    @QueryField(name = "product_id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer productId;
    private DecimalFormat incomeMoney;
    @QueryField(name = "income_time",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] incomeTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getIncomeTimes() {
        return incomeTimes;
    }

    public void setIncomeTimes(String[] incomeTimes) {
        this.incomeTimes = incomeTimes;
    }

    public String[] getBeginTimes() {
        return beginTimes;
    }

    public void setBeginTimes(String[] beginTimes) {
        this.beginTimes = beginTimes;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public DecimalFormat getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(DecimalFormat incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

}
