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
import com.peanut.pagination.page.Page;
import com.peanut.security.realm.entity.queryObject.UserGroupQueryObject;
import com.peanut.security.realm.entity.role.Role;
import com.peanut.security.realm.entity.user.UserGroup;
import com.peanut.security.realm.service.RoleService;
import com.peanut.security.realm.service.UserGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class UserGroupController {
    private static final String USER_GROUP_PAGE_MODEL_NAME = "userGroupPage";

    private static final String USER_GROUP_QUERY_MODEL_NAME = "userGroupQueryObject";

    private static final String ALL_ROLES_MODEL = "allRolesModel";

    private static final String USER_GROUP_MODEL_NAME = "userGroupModel";

    private static final String ALL_POSSIBLE_USER_GROUPS_MODEL = "allPossibleUserGroupsModel";

    @Resource
    private UserGroupService userGroupService;

    @Resource
    private RoleService roleService;

    @Resource
    private PageService pageService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @ModelAttribute(USER_GROUP_QUERY_MODEL_NAME)
    public UserGroupQueryObject getUserGroupQueryObject() {
        return new UserGroupQueryObject();
    }

    @ModelAttribute(ALL_ROLES_MODEL)
    public List<Role> getAllRoles() {
        return roleService.queryAllRoles();
    }

    @RequestMapping(value = "/admin/userGroup/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(USER_GROUP_QUERY_MODEL_NAME) UserGroupQueryObject userGroupQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder
                .buildQueryInfo(userGroupQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<UserGroup> userGroupPage = pageService
                .queryDefaultPageSizePage(queryInfo);
        model.addAttribute(USER_GROUP_PAGE_MODEL_NAME, userGroupPage);
        model.addAttribute(USER_GROUP_QUERY_MODEL_NAME, userGroupQueryObject);
        return "admin/userGroup/index";
    }

    @RequestMapping(value = "/admin/userGroup/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(USER_GROUP_MODEL_NAME)) {
            model.addAttribute(USER_GROUP_MODEL_NAME, new UserGroup());
            model.addAttribute(ALL_POSSIBLE_USER_GROUPS_MODEL, userGroupService
                    .queryAllPossibleParentUserGroups());
        }
        return "admin/userGroup/add";
    }

    @RequestMapping(value = "/admin/userGroup/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(USER_GROUP_MODEL_NAME) @Valid UserGroup userGroup,
            BindingResult result,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(USER_GROUP_MODEL_NAME, userGroup);
            return gotoAdd(model);
        }
        userGroupService.doSaveUserGroup(userGroup, roleIds);
        return "admin/userGroup/success";
    }

    @RequestMapping(value = "/admin/userGroup/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(USER_GROUP_MODEL_NAME)) {
            UserGroup userGroup = userGroupService.queryUserGroupById(id);
            model.addAttribute(USER_GROUP_MODEL_NAME, userGroup);
            model.addAttribute(ALL_POSSIBLE_USER_GROUPS_MODEL, userGroupService
                    .queryAllPossibleParentUserGroups(id));
        }
        return "admin/userGroup/update";
    }

    @RequestMapping(value = "/admin/userGroup/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(USER_GROUP_MODEL_NAME) @Valid UserGroup userGroup,
            BindingResult result,
            Model model,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(USER_GROUP_MODEL_NAME, userGroup);
            return gotoUpdate(userGroup.getId(), model);
        }
        userGroupService.doUpdateUserGroup(userGroup, roleIds);
        return "admin/userGroup/success";
    }

    @RequestMapping(value = "/admin/userGroup/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        userGroupService.doDeleteUserGroup(id);
        return "admin/userGroup/success";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder
                .registerCustomEditor(Enum.class, new EnumEditor(
                        OrderType.class));
    }
}