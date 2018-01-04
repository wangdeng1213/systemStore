/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.realm.controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.pagination.page.Page;
import com.peanut.security.realm.entity.queryObject.UserQueryObject;
import com.peanut.security.realm.entity.role.Role;
import com.peanut.security.realm.entity.user.User;
import com.peanut.security.realm.entity.user.UserGroup;
import com.peanut.security.realm.service.RoleService;
import com.peanut.security.realm.service.UserGroupService;
import com.peanut.security.realm.service.UserService;
import com.peanut.workflow.exception.SyncUserException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String USER_PAGE_MODEL_NAME = "userPage";

    private static final String USER_QUERY_MODEL_NAME = "userQueryObject";

    private static final String ALL_ROLES_MODEL = "allRolesModel";

    private static final String ALL_USERGROUPS_MODEL = "allUserGroupsModel";

    private static final String USER_MODEL_NAME = "userModel";

    private static final String PREVIEW_LIST_MODEL_NAME = "previewList";

    private static final int DEFAULT_PDF_PAGE_SIZE = 10;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserGroupService userGroupService;

//	@Resource
//	private DefaultExcelService defaultExcelService;

//	@Resource
//	private IValidateUtil validateUtil;

//	@Resource
//	private ExcelBuilder excelBuilder;

//	@Resource
//	private DefaultPDFService defaultPDFService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @Resource
    private com.peanut.workflow.activiti.user.UserService workflowUserService;

    @ModelAttribute(USER_QUERY_MODEL_NAME)
    public UserQueryObject gotoIndex() {
        return new UserQueryObject();
    }

    @ModelAttribute(ALL_ROLES_MODEL)
    public List<Role> getAllRoles() {
        return roleService.queryAllRoles();
    }

    @ModelAttribute(ALL_USERGROUPS_MODEL)
    public List<UserGroup> getAllUserGroups() {
        return userGroupService.queryAllUserGroups();
    }

    @RequestMapping(value = "/admin/user/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(USER_QUERY_MODEL_NAME) UserQueryObject userQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(userQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<User> userPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(USER_PAGE_MODEL_NAME, userPage);
        model.addAttribute(USER_QUERY_MODEL_NAME, userQueryObject);
        return "admin/user/index";
    }

    @RequestMapping(value = "/admin/user/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(USER_MODEL_NAME)) {
            model.addAttribute(USER_MODEL_NAME, new User());
        }
        return "admin/user/add";
    }

    @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(USER_MODEL_NAME) @Valid User user,
            BindingResult result,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds,
            @RequestParam(value = "userGroupIds", defaultValue = StringUtils.EMPTY) Integer[] userGroupIds) {
        if (result.hasErrors()) {
            model.addAttribute(USER_MODEL_NAME, user);
            return gotoAdd(model);
        }

        userService.doSaveUser(user, roleIds, userGroupIds);
        try {
            List<String> roleIdStrList = Lists.transform(Lists.newArrayList(roleIds), new Function<Integer, String>() {
                @Override
                public String apply(Integer roleId) {
                    Role role = roleService.queryById(roleId);
                    return String.valueOf(role.getPeanutRole());
                }
            });
            workflowUserService.syncUser(String.valueOf(user.getId()), StringUtils.EMPTY, user.getUserName(), user.getEmail(), user.getPassword(), Lists.newArrayList(roleIdStrList));
        } catch (SyncUserException e) {
            logger.error("sync user:{} to workflow error!", user);
        }
        return "admin/user/success";
    }

    @RequestMapping(value = "/admin/user/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(USER_MODEL_NAME)) {
            User user = userService.queryById(id);
            model.addAttribute(USER_MODEL_NAME, user);
        }
        return "admin/user/update";
    }

    @RequestMapping(value = "/admin/user/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(USER_MODEL_NAME) @Valid User user,
            BindingResult result,
            Model model,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] userRoleIds,
            @RequestParam(value = "userGroupIds", defaultValue = StringUtils.EMPTY) Integer[] userGroupIds) {
        if (result.hasErrors()) {
            model.addAttribute(USER_MODEL_NAME, user);
            return gotoUpdate(user.getId(), model);
        }

        userService.doUpdateUser(user, userRoleIds, userGroupIds);
        try {
            List<String> roleIdStrList = Lists.transform(Lists.newArrayList(userRoleIds), new Function<Integer, String>() {
                @Override
                public String apply(Integer roleId) {
                    Role role = roleService.queryById(roleId);
                    return String.valueOf(role.getPeanutRole());
                }
            });
            workflowUserService.syncUser(String.valueOf(user.getId()), StringUtils.EMPTY, user.getUserName(), user.getEmail(), user.getPassword(), Lists.newArrayList(roleIdStrList));
        } catch (SyncUserException e) {
            logger.error("sync user:{} to workflow error!", user);
        }

        return "admin/user/success";
    }

    @RequestMapping(value = "/admin/user/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        userService.doDeleteUser(id);
        return "admin/user/success";
    }

    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.DELETE)
    public String batchDelete(
            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
        userService.doDeleteUser(batchDeleteIds);

        for (Integer id : batchDeleteIds) {
            User user = userService.queryById(id);
            try {
                workflowUserService.delete(String.valueOf(user.getId()), Lists.transform(user.getRoles(), new Function<Role, String>() {
                    @Override
                    public String apply(Role role) {
                        return role.getPeanutRole();
                    }
                }));
            } catch (SyncUserException e) {
                logger.error("delete user:{} to workflow error", user);
            }
        }
        return "admin/user/success";
    }

//	@RequestMapping(value = "/admin/user/import", method = RequestMethod.GET)
//	public String gotoImport() {
//		return "admin/user/import";
//	}
//
//	@RequestMapping(value = "/admin/user/import", method = RequestMethod.POST)
//	public String importExcel(Model model, @RequestParam MultipartFile excel)
//			throws Exception {
//		defaultExcelService.importExcel(excel.getInputStream(), User.class,
//				validateUtil);
//
//		if (validateUtil.getErrorMessage() != null) {
//			model.addAttribute("errorMessage", validateUtil.getErrorMessage());
//			return gotoImport();
//		}
//
//		return "/admin/user/success";
//	}

//	@RequestMapping(value = "/admin/user/export", method = RequestMethod.GET)
//	public void exportExcel(HttpServletResponse response,
//			@ModelAttribute("userQueryObject") UserQueryObject userQueryObject) {
//		QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(userQueryObject);
//
//		defaultExcelService.exportExcel(
//				"/exportTemplete/admin/userExport.properties", queryInfo);
//	}

//	@RequestMapping(value = "/admin/user/gotoPreviewExcel", method = RequestMethod.GET)
//	public String gotoPreview(Model model) {
//		if (!model.containsAttribute(PREVIEW_LIST_MODEL_NAME)) {
//			model.addAttribute(PREVIEW_LIST_MODEL_NAME, new ArrayList<User>());
//		}
//		return "/admin/user/preview";
//	}

//	@RequestMapping(value = "/admin/user/previewExcel", method = RequestMethod.POST)
//	public String preview(Model model, @RequestParam MultipartFile excel)
//			throws IOException {
//		List<User> previewList = excelBuilder.buildImport(excel
//				.getInputStream(), User.class, defaultExcelService
//				.getSheetBuilder().getContentStrategy().getStartRowIndex());
//
//		model.addAttribute(PREVIEW_LIST_MODEL_NAME, previewList);
//		return gotoPreview(model);
//	}

//	@RequestMapping(value = "/admin/user/exportPDF", method = RequestMethod.GET)
//	public void exportPDF(HttpServletResponse response,
//			@ModelAttribute() UserQueryObject userQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder.buildQueryInfo(userQueryObject);
//
//		defaultPDFService.exportPDF(
//				"/exportTemplete/admin/userExport.properties",
//				DEFAULT_PDF_PAGE_SIZE, queryInfo);
//	}

//	@RequestMapping(value = "/admin/user/allActiveUsers")
//	public String getAllActiveUsers(Model model) {
//		model.addAttribute("allActiveUsers", AuthUtil.getAllActiveUser());
//		return "admin/user/allActiveUsers";
//	}
//
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder
//				.registerCustomEditor(Enum.class, new EnumEditor(
//						OrderType.class));
//	}
}