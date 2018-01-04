package com.peanut.p2p.code.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by my on 2015/7/1.
 */
@Entity
@Table(name = "resp_parameter")
public class RespParameter extends BaseEntity {

    private static final long serialVersionUID = 644739866235088134L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "platformNo")
    private String  platformNo;//商户编号
    @Column(name = "requestNo")
    private String requestNo;//请求流水号
    @Column(name = "service")
    private String service;//服务名称
    @Column(name = "code")
    private String code;//返回值
    @Column(name = "description")
    private String description;//描述信息
    @Column(name = "operator")
    private String  operator;//
    @Column(name = "parameters")
    private String parameters;//传入参数
    @Column(name = "notifyurl")
    private String notifyurl;//
    @Column(name = "notifyparams")
    private String notifyparams;//notify参数
    @Column(name = "callbackurl")
    private String callbackurl;//
    @Column(name = "callbackparams")
    private String callbackparams;//callback参数
    @Column(name = "createtime")
    private Timestamp createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public String getNotifyparams() {
        return notifyparams;
    }

    public void setNotifyparams(String notifyparams) {
        this.notifyparams = notifyparams;
    }

    public String getCallbackurl() {
        return callbackurl;
    }

    public void setCallbackurl(String callbackurl) {
        this.callbackurl = callbackurl;
    }

    public String getCallbackparams() {
        return callbackparams;
    }

    public void setCallbackparams(String callbackparams) {
        this.callbackparams = callbackparams;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
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
