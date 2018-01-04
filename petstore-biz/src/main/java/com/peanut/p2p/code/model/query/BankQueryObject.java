package com.peanut.p2p.code.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.code.model.entity.Bank;

/**
 * Created by my on 2015/3/18.
 */
@QueryEntity(entityClazz = Bank.class, alias = "bank")
public class BankQueryObject extends QueryObject {


    private static final long serialVersionUID = 5744341426448706468L;
    @QueryField(name = "bank_id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer bank_id;
    @QueryField(name = "bank_name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bank_name;
    @QueryField(name = "bank_address", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bank_address;
    @QueryField(name = "bank_no", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bank_no;
    @QueryField(name = "bank_phone", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bank_phone;

    private byte[] bank_img;
    @QueryField(name = "bank_branch", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String bank_branch;
    @QueryField(name = "act_status", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer act_status;

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_address() {
        return bank_address;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }

    public String getBank_phone() {
        return bank_phone;
    }

    public void setBank_phone(String bank_phone) {
        this.bank_phone = bank_phone;
    }

    public byte[] getBank_img() {
        return bank_img;
    }

    public void setBank_img(byte[] bank_img) {
        this.bank_img = bank_img;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }
}
