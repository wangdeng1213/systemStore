/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.data.jpa.support;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.beanRegister.MethodAccessChecker;
import com.peanut.security.realm.entity.resource.Method;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
public class MethodAccessCheckerImpl implements MethodAccessChecker {
    @Resource
    private IBaseDao baseDao;

    private static List<String> methodNames;

    @Override
    @PostConstruct
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<String> getMethods() {
        methodNames = new LinkedList<String>();

        List<Method> methods = baseDao
                .findEntitiesByJPQL("from com.peanut.security.realm.entity.resource.Method method");
        for (Method method : methods) {
            String methodName = new StringBuffer(method.getClassName().length()
                    + method.getName().length() + 1).append(
                    method.getClassName()).append(".").append(method.getName())
                    .toString();
            methodNames.add(methodName);
        }

        return methodNames;
    }

    private boolean isCreatePermissionCheck(String methodNameToCheck) {
        for (String methodName : methodNames) {
            if (methodName.equals(methodNameToCheck)) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    @Override
    public String buildAccessChecker(String methodName) {
        String methodAccessCheckerBody = StringUtils.EMPTY;

        if (isCreatePermissionCheck(methodName)) {
            methodAccessCheckerBody = "if(!com.peanut.security.springSecurity.utils.AuthUtils.hasPermission(com.peanut.security.realm.entity.resource.enums.PrivilegeType.METHOD, \""
                    + methodName
                    + "\", null,null)){throw new org.springframework.security.access.AccessDeniedException(\"Access is denied\");}";
        }

        return methodAccessCheckerBody;
    }
}