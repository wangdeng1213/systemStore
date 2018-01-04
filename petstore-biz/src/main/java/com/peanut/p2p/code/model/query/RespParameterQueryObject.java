package com.peanut.p2p.code.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.code.model.entity.RespParameter;

/**
 * Created by my on 2015/7/1.
 */
@QueryEntity(entityClazz = RespParameter.class,alias = "respPara")
public class RespParameterQueryObject extends QueryObject{

    private static final long serialVersionUID = 4112909029254497384L;
    @QueryField(name = "id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "platformNo",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String  platformNo;//商户编号
    @QueryField(name = "requestNo",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String requestNo;//请求流水号
    @QueryField(name = "service",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String service;//服务名称
    @QueryField(name = "code",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String code;//返回值
    @QueryField(name = "description",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String description;//描述信息

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
}
