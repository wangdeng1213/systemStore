package com.peanut.p2p.xml;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * Created by ln on 2015/6/16.
 */


public class Acount {
    private String targetUserType;

    private Long targetPlatformUserNo;

    private BigDecimal amount;

    private String bizType;

    @XmlElement(name = "targetUserType")
    public String getTargetUserType() {
        return targetUserType;
    }

    public void setTargetUserType(String targetUserType) {
        this.targetUserType = targetUserType;
    }
    @XmlElement(name = "targetPlatformUserNo")
    public Long getTargetPlatformUserNo() {
        return targetPlatformUserNo;
    }

    public void setTargetPlatformUserNo(Long targetPlatformUserNo) {
        this.targetPlatformUserNo = targetPlatformUserNo;
    }
    @XmlElement(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    @XmlElement(name = "bizType")
    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
