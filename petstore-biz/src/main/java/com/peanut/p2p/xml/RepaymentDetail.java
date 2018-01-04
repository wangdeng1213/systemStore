package com.peanut.p2p.xml;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "request")
public class RepaymentDetail {

    private String platformNo;

    private String requestNo;

    private String platformUserNo;

    private String userType;

    private String bizType;

    private List<Acount> details;

    private List<Property> extend;

    private String notifyUrl;

    private String callbackUrl;

    private String remark;

    @XmlElement
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @XmlAttribute(name = " platformNo")
    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }
    @XmlElement(name = "requestNo")
    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }
    @XmlElement(name = "platformUserNo")
    public String getPlatformUserNo() {
        return platformUserNo;
    }

    public void setPlatformUserNo(String platformUserNo) {
        this.platformUserNo = platformUserNo;
    }
    @XmlElement(name = "userType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    @XmlElement(name = "bizType")
    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @XmlElementWrapper(name = "details")
    @XmlElement(name = "detail")
    public List<Acount> getDetails() {
        return details;
    }

    public void setDetails(List<Acount> details) {
        this.details = details;
    }

    @XmlElementWrapper(name = "extend")
    @XmlElement(name = "property")
    public List<Property> getExtend() {
        return extend;
    }

    public void setExtend(List<Property> extend) {
        this.extend = extend;
    }

    @XmlElement(name = "notifyUrl")
    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    @XmlElement(name = "callbackUrl")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

}
