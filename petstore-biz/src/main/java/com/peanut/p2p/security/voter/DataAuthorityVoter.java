/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.voter;

import com.peanut.p2p.security.realm.PeanutRole;
import com.peanut.security.realm.entity.role.Role;
import com.peanut.security.realm.entity.user.User;
import com.peanut.security.springSecurity.utils.AuthUtils;
import com.peanut.security.voter.AuthorityVoter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
public class DataAuthorityVoter implements AuthorityVoter {
    @Override
    public boolean hasPermission(String... roles) {
        if (roles == null || roles.length == 0) {
            return Boolean.FALSE;
        }

        if (roles != null && roles.length == 1
                && roles[0].equals(PeanutRole.ROLE_ALL.name())) {
            return Boolean.TRUE;
        }

        User user = AuthUtils.getCurrentUser();
        List<String> urpRoleList = new ArrayList<String>(
                Arrays.asList(roles));
        System.out.println(urpRoleList+"________________________________");
        boolean hasPermission = Boolean.FALSE;
        for (Role role : user.getRoles()) {
            System.out.println(user.getRoles()+"++++++++++++++++++++++++++++++++++++");
            boolean hasPermissionTemp = Boolean.FALSE;

            if (urpRoleList.contains(role.getPeanutRole())) {
                hasPermission = Boolean.TRUE;
                hasPermissionTemp = Boolean.TRUE;
            }
            hasPermission = hasPermission && hasPermissionTemp;
        }
        return hasPermission;
    }
}