/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.products.model.entity.Product;
import com.peanut.p2p.products.model.entity.Riskinfo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author weizhenkun
 * @version 1.0
 */
@QueryEntity(entityClazz = Riskinfo.class, alias = "riskinfo")
public class RiskinfoQueryObject extends QueryObject {

    private static final long serialVersionUID = -7164822555217426819L;
    @QueryField(name = "id", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private Integer id; //product_id
    @QueryField(name = "riskname", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String riskname; //product_code
    @QueryField(name = "riskinfos", logicType = LogicType.and, genericOperator = GenericOperator.EQ)
    private String riskinfos; //product_name

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRiskname() {
        return riskname;
    }

    public void setRiskname(String riskname) {
        this.riskname = riskname;
    }

    public String getRiskinfos() {
        return riskinfos;
    }

    public void setRiskinfos(String riskinfos) {
        this.riskinfos = riskinfos;
    }
}