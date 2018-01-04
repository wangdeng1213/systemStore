package com.peanut.p2p.user.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.user.model.entity.InternetUser;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by my on 2015/6/12.
 */
@QueryEntity(entityClazz = InternetUser.class,alias = "iu")
public class InternetUserQueryObject extends QueryObject{

    private static final long serialVersionUID = 248944307911929674L;
    @QueryField(name = "userName", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String userName;
    @QueryField(name = "name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String name;
    @QueryField(name = "password", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String password;
    @QueryField(name = "idcard", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String idcard;
    @QueryField(name = "email", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String email;
    @QueryField(name = "mobilephone", logicType = LogicType.and, genericOperator = GenericOperator.LIKE)
    private String mobilephone;
    @QueryField(name = "actStatus", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer actStatus;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "registerDate", logicType = LogicType.and, genericOperator = GenericOperator.BETWEEN)
    private Date[] registerDates;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public Integer getActStatus() {
        return actStatus;
    }

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date[] getRegisterDates() {
        return registerDates;
    }

    public void setRegisterDates(Date[] registerDates) {
        this.registerDates = registerDates;
    }
}
