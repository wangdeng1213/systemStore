package com.peanut.p2p.code.model.entity;

import com.peanut.entity.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * 合同
 * Created by my on 2015/4/11.
 */
@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {

    private static final long serialVersionUID = 1110103810807838362L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "contract_sort")
    private String contract_sort;//合同类型【01：借款合同；02：抵押合同；】
    @Column(name = "contract_item")
    private String contract_item;//合同类型【0101：借款人合同；0102：投资人合同】
    @Column(name = "borrow_id")
    private Integer borrow_id;//借款表ID
    @Column(name = "tender_id")
    private Integer tender_id;//投资表ID
    @Column(name = "borrow_userid")
    private Integer borrow_userid;//借款人
    @Column(name = "tender_userid")
    private Integer tender_userid;//投资人
    @Column(name = "contract_code")
    private String contract_code;//合同编号
    @Column(name = "contract_wyh")
    private String contract_wyh;//合同唯一号
    @Column(name = "file_name")
    private String file_name;//文件名称
    @Column(name = "file_display_name")
    private String file_display_name;//文件显示名称
    @Column(name = "file_path")
    private String file_path;//文件路径
    @Column(name = "file_type")
    private String file_type;//文件类型
    @Column(name = "file_size")
    private String file_size;//文件大小
    @Column(name = "act_status")
    private Integer act_status;//激活状态

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContract_sort() {
        return contract_sort;
    }

    public void setContract_sort(String contract_sort) {
        this.contract_sort = contract_sort;
    }

    public String getContract_item() {
        return contract_item;
    }

    public void setContract_item(String contract_item) {
        this.contract_item = contract_item;
    }

    public Integer getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(Integer borrow_id) {
        this.borrow_id = borrow_id;
    }

    public Integer getTender_id() {
        return tender_id;
    }

    public void setTender_id(Integer tender_id) {
        this.tender_id = tender_id;
    }

    public Integer getBorrow_userid() {
        return borrow_userid;
    }

    public void setBorrow_userid(Integer borrow_userid) {
        this.borrow_userid = borrow_userid;
    }

    public Integer getTender_userid() {
        return tender_userid;
    }

    public void setTender_userid(Integer tender_userid) {
        this.tender_userid = tender_userid;
    }

    public String getContract_code() {
        return contract_code;
    }

    public void setContract_code(String contract_code) {
        this.contract_code = contract_code;
    }

    public String getContract_wyh() {
        return contract_wyh;
    }

    public void setContract_wyh(String contract_wyh) {
        this.contract_wyh = contract_wyh;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_display_name() {
        return file_display_name;
    }

    public void setFile_display_name(String file_display_name) {
        this.file_display_name = file_display_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
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
