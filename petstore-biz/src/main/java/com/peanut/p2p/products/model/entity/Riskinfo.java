/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@Entity
@Table(name = "riskinfo")
public class Riskinfo extends BaseEntity {

    private static final long serialVersionUID = 4768008164024531089L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;//
    @Column(name = "education")
    private String education;//最高学历
    @Column(name = "hometown")
    private String hometown;//籍贯
    @Column(name = "hkszd")
    private String hkszd;//户口所在地
    @Column(name = "jzdz")
    private String jzdz;//居住地址
    @Column(name = "jzdyb")
    private String jzdyb;//居住地邮编
    @Column(name = "jzddh")
    private String jzddh;//居住地电话
    @Column(name = "hyzk")
    private String hyzk;//婚姻状况1：已婚2：未婚3：离异4：丧偶
    @Column(name = "ywzn")
    private String ywzn;//有无子女1：有2：无
    @Column(name = "zxqsxm")
    private String zxqsxm;//直系亲属姓名
    @Column(name = "zxqsgx")
    private String zxqsgx;//直系亲属关系
    @Column(name = "zxqssj")
    private String zxqssj;//直系亲属手机
    @Column(name = "qtlxrxm")
    private String qtlxrxm;//其他联系人姓名
    @Column(name = "qtlxrgx")
    private String qtlxrgx;//其他联系人关系
    @Column(name = "qtlxrsj")
    private String qtlxrsj;//其他联系人手机
    @Column(name = "zyzt")
    private String zyzt;//职业状态
    @Column(name = "dwmc")
    private String dwmc;//单位名称
    @Column(name = "zw")
    private String zw;//职位
    @Column(name = "ysr")
    private String ysr;//月收入
    @Column(name = "gzyx")
    private String gzyx;//工作邮箱
    @Column(name = "gzcs")
    private String gzcs;//工作城市
    @Column(name = "gsdz")
    private String gsdz;//公司地址
    @Column(name = "gslb")
    private String gslb;//公司类别
    @Column(name = "gshy")
    private String gshy;//公司行业
    @Column(name = "gsgm")
    private String gsgm;//公司规模
    @Column(name = "zxdwgznx")
    private String zxdwgznx;//在现单位工作年限
    @Column(name = "gsdh")
    private String gsdh;//公司电话
    @Column(name = "sfyf")
    private String sfyf;//是否有房
    @Column(name = "ywfd")
    private String ywfd;//有无房贷
    @Column(name = "sfyc")
    private String sfyc;//是否有车
    @Column(name = "sfrz")
    private String sfrz;//身份认证ID
    @Column(name = "gzrz")
    private String gzrz;//工作认证ID
    @Column(name = "xyrz")
    private String xyrz;//信用认证ID
    @Column(name = "srrz")
    private String srrz;//收人认证ID
    @Column(name = "fcrz")
    private String fcrz;//房产认证ID
    @Column(name = "gcrz")
    private String gcrz;//购车认证ID
    @Column(name = "jhrz")
    private String jhrz;//结婚认证ID
    @Column(name = "xlrz")
    private String xlrz;//学历认证ID
    @Column(name = "zcrz")
    private String zcrz;//职称认证ID
    @Column(name = "sjrz")
    private String sjrz;//手机认证ID
    @Column(name = "jzrz")
    private String jzrz;//居住认证ID
    @Column(name = "zshyj")
    private String zshyj;//总的审核意见
    @Column(name = "zshzt")
    private String zshzt;//总的审核状态
    @Column(name = "act_status")
    private Long act_status;//激活状态
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getHkszd() {
        return hkszd;
    }

    public void setHkszd(String hkszd) {
        this.hkszd = hkszd;
    }

    public String getJzdz() {
        return jzdz;
    }

    public void setJzdz(String jzdz) {
        this.jzdz = jzdz;
    }

    public String getJzdyb() {
        return jzdyb;
    }

    public void setJzdyb(String jzdyb) {
        this.jzdyb = jzdyb;
    }

    public String getJzddh() {
        return jzddh;
    }

    public void setJzddh(String jzddh) {
        this.jzddh = jzddh;
    }

    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk;
    }

    public String getYwzn() {
        return ywzn;
    }

    public void setYwzn(String ywzn) {
        this.ywzn = ywzn;
    }

    public String getZxqsxm() {
        return zxqsxm;
    }

    public void setZxqsxm(String zxqsxm) {
        this.zxqsxm = zxqsxm;
    }

    public String getZxqsgx() {
        return zxqsgx;
    }

    public void setZxqsgx(String zxqsgx) {
        this.zxqsgx = zxqsgx;
    }

    public String getZxqssj() {
        return zxqssj;
    }

    public void setZxqssj(String zxqssj) {
        this.zxqssj = zxqssj;
    }

    public String getQtlxrxm() {
        return qtlxrxm;
    }

    public void setQtlxrxm(String qtlxrxm) {
        this.qtlxrxm = qtlxrxm;
    }

    public String getQtlxrgx() {
        return qtlxrgx;
    }

    public void setQtlxrgx(String qtlxrgx) {
        this.qtlxrgx = qtlxrgx;
    }

    public String getQtlxrsj() {
        return qtlxrsj;
    }

    public void setQtlxrsj(String qtlxrsj) {
        this.qtlxrsj = qtlxrsj;
    }

    public String getZyzt() {
        return zyzt;
    }

    public void setZyzt(String zyzt) {
        this.zyzt = zyzt;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getYsr() {
        return ysr;
    }

    public void setYsr(String ysr) {
        this.ysr = ysr;
    }

    public String getGzyx() {
        return gzyx;
    }

    public void setGzyx(String gzyx) {
        this.gzyx = gzyx;
    }

    public String getGzcs() {
        return gzcs;
    }

    public void setGzcs(String gzcs) {
        this.gzcs = gzcs;
    }

    public String getGsdz() {
        return gsdz;
    }

    public void setGsdz(String gsdz) {
        this.gsdz = gsdz;
    }

    public String getGslb() {
        return gslb;
    }

    public void setGslb(String gslb) {
        this.gslb = gslb;
    }

    public String getGshy() {
        return gshy;
    }

    public void setGshy(String gshy) {
        this.gshy = gshy;
    }

    public String getGsgm() {
        return gsgm;
    }

    public void setGsgm(String gsgm) {
        this.gsgm = gsgm;
    }

    public String getZxdwgznx() {
        return zxdwgznx;
    }

    public void setZxdwgznx(String zxdwgznx) {
        this.zxdwgznx = zxdwgznx;
    }

    public String getGsdh() {
        return gsdh;
    }

    public void setGsdh(String gsdh) {
        this.gsdh = gsdh;
    }

    public String getSfyf() {
        return sfyf;
    }

    public void setSfyf(String sfyf) {
        this.sfyf = sfyf;
    }

    public String getYwfd() {
        return ywfd;
    }

    public void setYwfd(String ywfd) {
        this.ywfd = ywfd;
    }

    public String getSfyc() {
        return sfyc;
    }

    public void setSfyc(String sfyc) {
        this.sfyc = sfyc;
    }

    public String getGzrz() {
        return gzrz;
    }

    public void setGzrz(String gzrz) {
        this.gzrz = gzrz;
    }

    public String getXyrz() {
        return xyrz;
    }

    public void setXyrz(String xyrz) {
        this.xyrz = xyrz;
    }

    public String getSrrz() {
        return srrz;
    }

    public void setSrrz(String srrz) {
        this.srrz = srrz;
    }

    public String getFcrz() {
        return fcrz;
    }

    public void setFcrz(String fcrz) {
        this.fcrz = fcrz;
    }

    public String getGcrz() {
        return gcrz;
    }

    public void setGcrz(String gcrz) {
        this.gcrz = gcrz;
    }

    public String getJhrz() {
        return jhrz;
    }

    public void setJhrz(String jhrz) {
        this.jhrz = jhrz;
    }

    public String getXlrz() {
        return xlrz;
    }

    public void setXlrz(String xlrz) {
        this.xlrz = xlrz;
    }

    public String getZcrz() {
        return zcrz;
    }

    public void setZcrz(String zcrz) {
        this.zcrz = zcrz;
    }

    public String getSjrz() {
        return sjrz;
    }

    public void setSjrz(String sjrz) {
        this.sjrz = sjrz;
    }

    public String getJzrz() {
        return jzrz;
    }

    public void setJzrz(String jzrz) {
        this.jzrz = jzrz;
    }

    public String getZshzt() {
        return zshzt;
    }

    public void setZshzt(String zshzt) {
        this.zshzt = zshzt;
    }

    public String getSfrz() {
        return sfrz;
    }

    public void setSfrz(String sfrz) {
        this.sfrz = sfrz;
    }

    public String getZshyj() {
        return zshyj;
    }

    public void setZshyj(String zshyj) {
        this.zshyj = zshyj;
    }

    public Long getAct_status() {
        return act_status;
    }

    public void setAct_status(Long act_status) {
        this.act_status = act_status;
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