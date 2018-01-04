package com.peanut.p2p.security.model.query;

import com.peanut.data.query.anotation.QueryEntity;
import com.peanut.data.query.anotation.QueryField;
import com.peanut.data.query.component.QueryObject;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.security.model.entity.SysLog;

/**
 * Created by my on 2015/5/18.
 */
@QueryEntity(entityClazz = SysLog.class,alias = "syslog")
public class SysLogQueryObject extends QueryObject{

    private static final long serialVersionUID = 4726254501256522994L;
    @QueryField(name = "id",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer id;
    @QueryField(name = "user",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String user;//操作人
    @QueryField(name = "source",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String source;//操作源
    @QueryField(name = "target",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String target;//操作目标
    @QueryField(name = "type",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String type;//操作类型
    @QueryField(name = "result",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String result;//操作结果
    @QueryField(name = "content",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String content;//操作内容
    @QueryField(name = "ip",logicType = LogicType.and,genericOperator = GenericOperator.LIKE)
    private String ip;//操作ip
    @QueryField(name = "sysTime",logicType = LogicType.and,genericOperator = GenericOperator.BETWEEN)
    private String[] sysTimes;//操作时间
    @QueryField(name = "loginid",logicType = LogicType.and,genericOperator = GenericOperator.EQ)
    private Integer loginid;

    private Integer act_status;

    public Integer getAct_status() {
        return act_status;
    }

    public void setAct_status(Integer act_status) {
        this.act_status = act_status;
    }

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String[] getSysTimes() {
        return sysTimes;
    }

    public void setSysTimes(String[] sysTimes) {
        this.sysTimes = sysTimes;
    }
}
