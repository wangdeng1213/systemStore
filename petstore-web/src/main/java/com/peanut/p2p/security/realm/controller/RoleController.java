/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.realm.controller;

import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.editor.EnumEditor;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.security.realm.PeanutRole;
import com.peanut.pagination.page.Page;
import com.peanut.security.realm.entity.queryObject.RoleQueryObject;
import com.peanut.security.realm.entity.role.Role;
import com.peanut.security.realm.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class RoleController {
    private static final String ROLE_PAGE_MODEL_NAME = "rolePage";

    private static final String ROLE_QUERY_MODEL_NAME = "roleQueryObject";

    private static final String ROLE_MODEL_NAME = "roleModel";

    private static final String URP_ROLES_MODEL_NAME = "urpRolesModel";

    @Resource
    private PageService pageService;

    @Resource
    private RoleService roleService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @ModelAttribute(ROLE_QUERY_MODEL_NAME)
    public RoleQueryObject getRoleQueryObject() {
        return new RoleQueryObject();
    }

    @ModelAttribute(URP_ROLES_MODEL_NAME)
    public List<PeanutRole> getUrpRoles() {
        List<PeanutRole> urpRoles = new LinkedList<PeanutRole>((Arrays.asList(PeanutRole
                .values())));
        urpRoles.remove(PeanutRole.ROLE_ALL);
        return urpRoles;
    }

    @RequestMapping(value = "/admin/role/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(ROLE_QUERY_MODEL_NAME) RoleQueryObject roleQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(roleQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Role> rolePage = pageService.queryDefaultPageSizePage(queryInfo);

        model.addAttribute(ROLE_PAGE_MODEL_NAME, rolePage);
        model.addAttribute(ROLE_QUERY_MODEL_NAME, roleQueryObject);

        return "admin/role/index";
    }

    @RequestMapping(value = "/admin/role/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(ROLE_MODEL_NAME)) {
            model.addAttribute(ROLE_MODEL_NAME, new Role());
        }
        return "admin/role/add";
    }

    @RequestMapping(value = "/admin/role/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(ROLE_MODEL_NAME) @Valid Role role,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(ROLE_MODEL_NAME, role);
            return gotoAdd(model);
        }
        roleService.doSaveRole(role);
        return "admin/role/success";
    }

    @RequestMapping(value = "/admin/role/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(ROLE_MODEL_NAME)) {
            Role role = roleService.queryById(id);
            model.addAttribute(ROLE_MODEL_NAME, role);
        }
        return "admin/role/update";
    }

    @RequestMapping(value = "/admin/role/{id}/update", method = RequestMethod.PUT)
    public String update(@ModelAttribute(ROLE_MODEL_NAME) @Valid Role role,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ROLE_MODEL_NAME, role);
            return gotoUpdate(role.getId(), model);
        }
        roleService.doUpdateRole(role);
        return "admin/role/success";
    }

    @RequestMapping(value = "/admin/role/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        roleService.doDeleteRole(id);
        return "admin/role/success";
    }

    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PeanutRole.class,
                new EnumEditor(PeanutRole.class));
        binder.registerCustomEditor(OrderType.class, new EnumEditor(
                OrderType.class));
    }
}