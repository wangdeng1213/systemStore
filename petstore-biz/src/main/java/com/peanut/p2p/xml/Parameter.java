package com.peanut.p2p.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ln on 2015/6/26.
 * email 5107678@sohu.com
 */
@XmlRootElement(name = "request")
public class Parameter {

    private String platformNo;

    private String requestNo;

    private String mode;

    private String notifyUrl;

    @XmlAttribute(name = "platformNo")
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

    @XmlElement(name = "mode")
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @XmlElement(name = "notifyUrl")
    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
