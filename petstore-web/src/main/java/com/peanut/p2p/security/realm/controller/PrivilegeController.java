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
import com.peanut.security.realm.entity.privilege.Privilege;
import com.peanut.security.realm.entity.queryObject.PrivilegeQueryObject;
import com.peanut.security.realm.entity.resource.*;
import com.peanut.security.realm.entity.resource.enums.PrivilegeType;
import com.peanut.security.realm.entity.role.Role;
import com.peanut.security.realm.service.PrivilegeService;
import com.peanut.security.realm.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class PrivilegeController {
    private static final String PRIVILEGE_QUERY_MODEL_NAME = "privilegeQueryObject";

    private static final String ALL_ROLES_MODEL = "allRolesModel";

    private static final String PRIVILEGE_PAGE_MODEL_NAME = "privilegePage";

    private static final String MENU_MODEL_NAME = "menuModel";

    private static final String ALL_POSSIBLE_PARENT_MENUS_MODEL_NAME = "allPossibleParentMenusModel";

    private static final String REQUEST_METHODS_MODEL = "requestMethodsModel";

    private static final String OPERATION_MODEL_NAME = "operationModel";

    private static final String ALL_POSSIBLE_PARENT_OPERATIONS_MODEL_NAME = "allPossibleParentOperationsModel";

    private static final String FILE_MODEL_NAME = "fileModel";

    private static final String METHOD_MODEL_NAME = "methodModel";

    private static final String PAGEELEMENT_MODEL_NAME = "pageElementModel";

    private static final String PREVIEW_LIST_MODEL_NAME = "previewList";

    private static final int DEFAULT_PDF_PAGE_SIZE = 10;

    @Resource
    private RoleService roleService;

    @Resource
    private PageService pageService;

    @Resource
    private PrivilegeService privilegeService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

//	@Resource
//	private DefaultExcelService defaultExcelService;

//	@Resource
//	private IValidateUtil validateUtil;

//	@Resource
//	private ExcelBuilder excelBuilder;

//	@Resource
//	private DefaultPDFService defaultPDFService;

    @ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME)
    public PrivilegeQueryObject gotoMenus() {
        return new PrivilegeQueryObject();
    }

    @ModelAttribute(ALL_ROLES_MODEL)
    public List<Role> getAllRoles() {
        return roleService.queryAllRoles();
    }

    @RequestMapping(value = "/admin/resource/menu/query", method = RequestMethod.GET)
    public String menusIndex(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject,
            Model model) {
        privilegeQueryObject.setPrivilegeType(PrivilegeType.MENU);

        QueryInfo queryInfo = queryInfoBuilder
                .buildQueryInfo(privilegeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Privilege> menuPage = pageService
                .queryDefaultPageSizePage(queryInfo);
        model.addAttribute(PRIVILEGE_PAGE_MODEL_NAME, menuPage);
        model.addAttribute(PRIVILEGE_QUERY_MODEL_NAME, privilegeQueryObject);
        return "admin/resource/menu/index";
    }

    @RequestMapping(value = "/admin/resource/menu/add", method = RequestMethod.GET)
    public String gotoAddMenu(Model model) {
        if (!model.containsAttribute(MENU_MODEL_NAME)) {
            model.addAttribute(MENU_MODEL_NAME, new Menu());
            model.addAttribute(ALL_POSSIBLE_PARENT_MENUS_MODEL_NAME,
                    privilegeService.queryAllPossibleParentMenus());
        }
        return "admin/resource/menu/add";
    }

    @RequestMapping(value = "/admin/resource/menu/add", method = RequestMethod.POST)
    public String addMenu(
            Model model,
            @ModelAttribute(MENU_MODEL_NAME) @Valid Menu menu,
            BindingResult result,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(MENU_MODEL_NAME, menu);
            return gotoAddMenu(model);
        }
        privilegeService.doSaveMenu(menu, roleIds);
        return "admin/resource/menu/success";
    }

    @RequestMapping(value = "/admin/resource/menu/{id}/update", method = RequestMethod.GET)
    public String gotoUpdateMenu(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(MENU_MODEL_NAME)) {
            Menu menu = privilegeService.queryMenuById(id);
            model.addAttribute(MENU_MODEL_NAME, menu);
            model.addAttribute(ALL_POSSIBLE_PARENT_MENUS_MODEL_NAME,
                    privilegeService.queryAllPossibleParentMenus(id));
        }
        return "admin/resource/menu/update";
    }

    @RequestMapping(value = "/admin/resource/menu/{id}/update", method = RequestMethod.PUT)
    public String updateMenu(
            @ModelAttribute(MENU_MODEL_NAME) @Valid Menu menu,
            BindingResult result,
            Model model,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(MENU_MODEL_NAME, menu);
            return gotoUpdateMenu(menu.getId(), model);
        }
        privilegeService.doUpdateMenu(menu, roleIds);
        return "admin/resource/menu/success";
    }

    @RequestMapping(value = "/admin/resource/menu/{id}/delete", method = RequestMethod.DELETE)
    public String deleteMenu(@PathVariable("id") Integer id) {
        privilegeService.doDeleteMenu(id);
        return "admin/resource/menu/success";
    }

    @RequestMapping(value = "/admin/resource/menu/import", method = RequestMethod.GET)
    public String gotoImportMenu() {
        return "admin/resource/menu/import";
    }

	@RequestMapping(value = "/admin/resource/menu/import", method = RequestMethod.POST)
	public String importMenuFile(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request)
			throws Exception {
//		privilegeService
//				.doImportMenuExcel(excel.getInputStream(), validateUtil);
//
//		if (validateUtil.getErrorMessage() != null) {
//			model.addAttribute("errorMessage", validateUtil.getErrorMessage());
//			return gotoImportMenu();
//		}

              for(int i = 0;i<files.length;i++){
                  System.out.println("fileName---------->" + files[i].getOriginalFilename());

                     if(!files[i].isEmpty()){

                         int pre = (int) System.currentTimeMillis();
                                try {
                                   //拿到输出流，同时重命名上传的文件
                                   FileOutputStream os = new FileOutputStream("E:/" + new Date().getTime() + files[i].getOriginalFilename());
                                  //拿到上传文件的输入流
                                    FileInputStream in = (FileInputStream) files[i].getInputStream();
                                    //以写字节的方式写文件
                                      int b = 0;
                                   while((b=in.read()) != -1){
                                              os.write(b);
                                        }
                                    os.flush();
                                   os.close();
                                   in.close();
                                    int finaltime = (int) System.currentTimeMillis();
                                   System.out.println(finaltime - pre);

                                 } catch (Exception e) {
                                      e.printStackTrace();
                                      System.out.println("上传出错");
                                  }
                       }
                  }



        return "admin/resource/menu/success";
	}

//	@RequestMapping(value = "/admin/resource/menu/export", method = RequestMethod.GET)
//	public void exportMenuExcel(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultExcelService.exportExcel(
//				"/exportTemplete/admin/resource/menuExport.properties",
//				queryInfo);
//	}

//	@RequestMapping(value = "/admin/resource/menu/gotoPreviewMenuExcel", method = RequestMethod.GET)
//	public String gotoPreviewMenuExcel(Model model) {
//		if (!model.containsAttribute(PREVIEW_LIST_MODEL_NAME)) {
//			model.addAttribute(PREVIEW_LIST_MODEL_NAME, new ArrayList<Menu>());
//		}
//		return "admin/resource/menu/preview";
//	}

//	@RequestMapping(value = "/admin/resource/menu/previewExcel", method = RequestMethod.POST)
//	public String previewMenuExcel(Model model,
//			@RequestParam MultipartFile excel) throws IOException {
//		List<Menu> previewList = excelBuilder.buildImport(excel
//				.getInputStream(), Menu.class, defaultExcelService
//				.getSheetBuilder().getContentStrategy().getStartRowIndex());
//
//		model.addAttribute(PREVIEW_LIST_MODEL_NAME, previewList);
//		return gotoPreviewMenuExcel(model);
//	}

//	@RequestMapping(value = "/admin/resource/menu/exportPDF", method = RequestMethod.GET)
//	public void exportMenuPDF(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultPDFService.exportPDF(
//				"/exportTemplete/admin/resource/menuExport.properties",
//				DEFAULT_PDF_PAGE_SIZE, queryInfo);
//	}

    @ModelAttribute(REQUEST_METHODS_MODEL)
    public List<RequestMethod> getRequestMethods() {
        return new LinkedList<RequestMethod>(Arrays.asList(RequestMethod
                .values()));
    }

    @RequestMapping(value = "/admin/resource/operation/query", method = RequestMethod.GET)
    public String operationsIndex(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject,
            Model model) {
        privilegeQueryObject.setPrivilegeType(PrivilegeType.OPERATION);

        QueryInfo queryInfo = queryInfoBuilder
                .buildQueryInfo(privilegeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Privilege> operationPage = pageService
                .queryDefaultPageSizePage(queryInfo);
        model.addAttribute(PRIVILEGE_PAGE_MODEL_NAME, operationPage);
        model.addAttribute(PRIVILEGE_QUERY_MODEL_NAME, privilegeQueryObject);
        return "admin/resource/operation/index";
    }

    @RequestMapping(value = "/admin/resource/operation/add", method = RequestMethod.GET)
    public String gotoAddOperation(Model model) {
        if (!model.containsAttribute(OPERATION_MODEL_NAME)) {
            model.addAttribute(OPERATION_MODEL_NAME, new Operation());
            model.addAttribute(ALL_POSSIBLE_PARENT_OPERATIONS_MODEL_NAME,
                    privilegeService.queryAllPossibleParentOperations());
        }
        return "admin/resource/operation/add";
    }

    @RequestMapping(value = "/admin/resource/operation/add", method = RequestMethod.POST)
    public String addOperation(
            Model model,
            @ModelAttribute(OPERATION_MODEL_NAME) @Valid Operation operation,
            BindingResult result,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(OPERATION_MODEL_NAME, operation);
            return gotoAddOperation(model);
        }
        privilegeService.doSaveOperation(operation, roleIds);
        return "admin/resource/operation/success";
    }

    @RequestMapping(value = "/admin/resource/operation/{id}/update", method = RequestMethod.GET)
    public String gotoUpdateOperation(@PathVariable("id") Integer id,
                                      Model model) {
        if (!model.containsAttribute(OPERATION_MODEL_NAME)) {
            Operation operation = privilegeService.queryOperationById(id);
            model.addAttribute(OPERATION_MODEL_NAME, operation);
            model.addAttribute(ALL_POSSIBLE_PARENT_OPERATIONS_MODEL_NAME,
                    privilegeService.queryAllPossibleParentOperations(id));
        }
        return "admin/resource/operation/update";
    }

    @RequestMapping(value = "/admin/resource/operation/{id}/update", method = RequestMethod.PUT)
    public String updateOperation(
            @ModelAttribute(OPERATION_MODEL_NAME) @Valid Operation operation,
            BindingResult result,
            Model model,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(OPERATION_MODEL_NAME, operation);
            return gotoUpdateOperation(operation.getId(), model);
        }
        privilegeService.doUpdateOperation(operation, roleIds);
        return "admin/resource/operation/success";
    }

    @RequestMapping(value = "/admin/resource/operation/{id}/delete", method = RequestMethod.DELETE)
    public String deleteOperation(@PathVariable("id") Integer id) {
        privilegeService.doDeleteOperation(id);
        return "admin/resource/operation/success";
    }

    @RequestMapping(value = "/admin/resource/operation/import", method = RequestMethod.GET)
    public String gotoImportOperation() {
        return "admin/resource/operation/import";
    }

//	@RequestMapping(value = "/admin/resource/operation/import", method = RequestMethod.POST)
//	public String importOperationExcel(Model model,
//			@RequestParam MultipartFile excel) throws Exception {
//		privilegeService.doImportOperationExcel(excel.getInputStream(),
//				validateUtil);
//
//		if (validateUtil.getErrorMessage() != null) {
//			model.addAttribute("errorMessage", validateUtil.getErrorMessage());
//			return gotoImportOperation();
//		}
//
//		return "admin/resource/operation/success";
//	}

//	@RequestMapping(value = "/admin/resource/operation/export", method = RequestMethod.GET)
//	public void exportOperationExcel(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultExcelService.exportExcel(
//				"/exportTemplete/admin/resource/operationExport.properties",
//				queryInfo);
//	}

//	@RequestMapping(value = "/admin/resource/operation/gotoPreviewOperationExcel", method = RequestMethod.GET)
//	public String gotoPreviewOperationExcel(Model model) {
//		if (!model.containsAttribute(PREVIEW_LIST_MODEL_NAME)) {
//			model.addAttribute(PREVIEW_LIST_MODEL_NAME,
//					new ArrayList<Operation>());
//		}
//		return "admin/resource/operation/preview";
//	}

//	@RequestMapping(value = "/admin/resource/operation/previewExcel", method = RequestMethod.POST)
//	public String previewOperationExcel(Model model,
//			@RequestParam MultipartFile excel) throws IOException {
//		List<Operation> previewList = excelBuilder.buildImport(excel
//				.getInputStream(), Operation.class, defaultExcelService
//				.getSheetBuilder().getContentStrategy().getStartRowIndex());
//
//		model.addAttribute(PREVIEW_LIST_MODEL_NAME, previewList);
//		return gotoPreviewMenuExcel(model);
//	}

//	@RequestMapping(value = "/admin/resource/operation/exportPDF", method = RequestMethod.GET)
//	public void exportOperationPDF(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultPDFService.exportPDF(
//				"/exportTemplete/admin/resource/operationExport.properties",
//				DEFAULT_PDF_PAGE_SIZE, queryInfo);
//	}

    @RequestMapping(value = "/admin/resource/file/query", method = RequestMethod.GET)
    public String filesIndex(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject,
            Model model) {
        privilegeQueryObject.setPrivilegeType(PrivilegeType.FILE);

        QueryInfo queryInfo = queryInfoBuilder
                .buildQueryInfo(privilegeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<File> filePage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(PRIVILEGE_PAGE_MODEL_NAME, filePage);
        model.addAttribute(PRIVILEGE_QUERY_MODEL_NAME, privilegeQueryObject);
        return "admin/resource/file/index";
    }

    @RequestMapping(value = "/admin/resource/file/add", method = RequestMethod.GET)
    public String gotoAddFile(Model model) {
        if (!model.containsAttribute(FILE_MODEL_NAME)) {
            model.addAttribute(FILE_MODEL_NAME, new File());
        }
        return "admin/resource/file/add";
    }

    @RequestMapping(value = "/admin/resource/file/add", method = RequestMethod.POST)
    public String addFile(
            Model model,
            @ModelAttribute(FILE_MODEL_NAME) @Valid File file,
            BindingResult result,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(FILE_MODEL_NAME, file);
            return gotoAddFile(model);
        }
        privilegeService.doSaveFile(file, roleIds);
        return "admin/resource/file/success";
    }

    @RequestMapping(value = "/admin/resource/file/{id}/update", method = RequestMethod.GET)
    public String gotoUpdateFile(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(FILE_MODEL_NAME)) {
            File file = privilegeService.queryFileById(id);
            model.addAttribute(FILE_MODEL_NAME, file);
        }
        return "admin/resource/file/update";
    }

    @RequestMapping(value = "/admin/resource/file/{id}/update", method = RequestMethod.PUT)
    public String updateFile(
            @ModelAttribute(FILE_MODEL_NAME) @Valid File file,
            BindingResult result,
            Model model,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(FILE_MODEL_NAME, file);
            return gotoUpdateFile(file.getId(), model);
        }
        privilegeService.doUpdateFile(file, roleIds);
        return "admin/resource/file/success";
    }

    @RequestMapping(value = "/admin/resource/file/{id}/delete", method = RequestMethod.DELETE)
    public String deleteFile(@PathVariable("id") Integer id) {
        privilegeService.doDeleteFile(id);
        return "admin/resource/file/success";
    }

    @RequestMapping(value = "/admin/resource/file/import", method = RequestMethod.GET)
    public String gotoImportFile() {
        return "admin/resource/file/import";
    }

//	@RequestMapping(value = "/admin/resource/file/import", method = RequestMethod.POST)
//	public String importFileExcel(Model model, @RequestParam MultipartFile excel)
//			throws Exception {
//		privilegeService
//				.doImportFileExcel(excel.getInputStream(), validateUtil);
//
//		if (validateUtil.getErrorMessage() != null) {
//			model.addAttribute("errorMessage", validateUtil.getErrorMessage());
//			return gotoImportFile();
//		}
//
//		return "admin/resource/file/success";
//	}

//	@RequestMapping(value = "/admin/resource/file/export", method = RequestMethod.GET)
//	public void exportFileExcel(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultExcelService.exportExcel(
//				"/exportTemplete/admin/resource/fileExport.properties",
//				queryInfo);
//	}

//	@RequestMapping(value = "/admin/resource/file/gotoPreviewFileExcel", method = RequestMethod.GET)
//	public String gotoPreviewFileExcel(Model model) {
//		if (!model.containsAttribute(PREVIEW_LIST_MODEL_NAME)) {
//			model.addAttribute(PREVIEW_LIST_MODEL_NAME, new ArrayList<File>());
//		}
//		return "admin/resource/file/preview";
//	}

//	@RequestMapping(value = "/admin/resource/file/previewExcel", method = RequestMethod.POST)
//	public String previewFileExcel(Model model,
//			@RequestParam MultipartFile excel) throws IOException {
//		List<File> previewList = excelBuilder.buildImport(excel
//				.getInputStream(), File.class, defaultExcelService
//				.getSheetBuilder().getContentStrategy().getStartRowIndex());
//
//		model.addAttribute(PREVIEW_LIST_MODEL_NAME, previewList);
//		return gotoPreviewMenuExcel(model);
//	}

//	@RequestMapping(value = "/admin/resource/file/exportPDF", method = RequestMethod.GET)
//	public void exportFilePDF(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultPDFService.exportPDF(
//				"/exportTemplete/admin/resource/fileExport.properties",
//				DEFAULT_PDF_PAGE_SIZE, queryInfo);
//	}

    @RequestMapping(value = "/admin/resource/method/query", method = RequestMethod.GET)
    public String methodsIndex(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject,
            Model model) {
        privilegeQueryObject.setPrivilegeType(PrivilegeType.METHOD);

        QueryInfo queryInfo = queryInfoBuilder
                .buildQueryInfo(privilegeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Method> methodPage = pageService
                .queryDefaultPageSizePage(queryInfo);
        model.addAttribute(PRIVILEGE_PAGE_MODEL_NAME, methodPage);
        model.addAttribute(PRIVILEGE_QUERY_MODEL_NAME, privilegeQueryObject);
        return "admin/resource/method/index";
    }

    @RequestMapping(value = "/admin/resource/method/add", method = RequestMethod.GET)
    public String gotoAddMethod(Model model) {
        if (!model.containsAttribute(METHOD_MODEL_NAME)) {
            model.addAttribute(METHOD_MODEL_NAME, new Method());
        }
        return "admin/resource/method/add";
    }

    @RequestMapping(value = "/admin/resource/method/add", method = RequestMethod.POST)
    public String addMethod(
            Model model,
            @ModelAttribute(METHOD_MODEL_NAME) @Valid Method method,
            BindingResult result,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(METHOD_MODEL_NAME, method);
            return gotoAddMenu(model);
        }
        privilegeService.doSaveMethod(method, roleIds);
        return "admin/resource/method/success";
    }

    @RequestMapping(value = "/admin/resource/method/{id}/update", method = RequestMethod.GET)
    public String gotoUpdateMethod(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(METHOD_MODEL_NAME)) {
            Method method = privilegeService.queryMethodById(id);
            model.addAttribute(METHOD_MODEL_NAME, method);
        }
        return "admin/resource/method/update";
    }

    @RequestMapping(value = "/admin/resource/method/{id}/update", method = RequestMethod.PUT)
    public String updateMethod(
            @ModelAttribute(METHOD_MODEL_NAME) @Valid Method method,
            BindingResult result,
            Model model,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(METHOD_MODEL_NAME, method);
            return gotoUpdateMethod(method.getId(), model);
        }
        privilegeService.doUpdateMethod(method, roleIds);
        return "admin/resource/method/success";
    }

    @RequestMapping(value = "/admin/resource/method/{id}/delete", method = RequestMethod.DELETE)
    public String deleteMethod(@PathVariable("id") Integer id) {
        privilegeService.doDeleteMethod(id);
        return "admin/resource/method/success";
    }

//	@RequestMapping(value = "/admin/resource/method/import", method = RequestMethod.GET)
//	public String gotoImportMethod() {
//		return "admin/resource/method/import";
//	}

//	@RequestMapping(value = "/admin/resource/method/import", method = RequestMethod.POST)
//	public String importMethodExcel(Model model,
//			@RequestParam MultipartFile excel) throws Exception {
//		privilegeService.doImportMethodExcel(excel.getInputStream(),
//				validateUtil);
//
//		if (validateUtil.getErrorMessage() != null) {
//			model.addAttribute("errorMessage", validateUtil.getErrorMessage());
//			return gotoImportMethod();
//		}
//
//		return "admin/resource/method/success";
//	}

//	@RequestMapping(value = "/admin/resource/method/export", method = RequestMethod.GET)
//	public void exportMethodExcel(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultExcelService.exportExcel(
//				"/exportTemplete/admin/resource/methodExport.properties",
//				queryInfo);
//	}

//	@RequestMapping(value = "/admin/resource/method/gotoPreviewMethodExcel", method = RequestMethod.GET)
//	public String gotoPreviewMethodExcel(Model model) {
//		if (!model.containsAttribute(PREVIEW_LIST_MODEL_NAME)) {
//			model
//					.addAttribute(PREVIEW_LIST_MODEL_NAME,
//							new ArrayList<Method>());
//		}
//		return "admin/resource/method/preview";
//	}

//	@RequestMapping(value = "/admin/resource/method/previewExcel", method = RequestMethod.POST)
//	public String previewMethodExcel(Model model,
//			@RequestParam MultipartFile excel) throws IOException {
//		List<Method> previewList = excelBuilder.buildImport(excel
//				.getInputStream(), Method.class, defaultExcelService
//				.getSheetBuilder().getContentStrategy().getStartRowIndex());
//
//		model.addAttribute(PREVIEW_LIST_MODEL_NAME, previewList);
//		return gotoPreviewMenuExcel(model);
//	}

//	@RequestMapping(value = "/admin/resource/method/exportPDF", method = RequestMethod.GET)
//	public void exportMethodPDF(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultPDFService.exportPDF(
//				"/exportTemplete/admin/resource/methodExport.properties",
//				DEFAULT_PDF_PAGE_SIZE, queryInfo);
//	}

    @RequestMapping(value = "/admin/resource/pageElement/query", method = RequestMethod.GET)
    public String pageElementsIndex(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject,
            Model model) {
        privilegeQueryObject.setPrivilegeType(PrivilegeType.PAGEELEMENT);

        QueryInfo queryInfo = queryInfoBuilder
                .buildQueryInfo(privilegeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<PageElement> pageElementPage = pageService
                .queryDefaultPageSizePage(queryInfo);
        model.addAttribute(PRIVILEGE_PAGE_MODEL_NAME, pageElementPage);
        model.addAttribute(PRIVILEGE_QUERY_MODEL_NAME, privilegeQueryObject);
        return "admin/resource/pageElement/index";
    }

    @RequestMapping(value = "/admin/resource/pageElement/add", method = RequestMethod.GET)
    public String gotoAddPageElement(Model model) {
        if (!model.containsAttribute(PAGEELEMENT_MODEL_NAME)) {
            model.addAttribute(PAGEELEMENT_MODEL_NAME, new PageElement());
        }
        return "admin/resource/pageElement/add";
    }

    @RequestMapping(value = "/admin/resource/pageElement/add", method = RequestMethod.POST)
    public String addPageElement(
            Model model,
            @ModelAttribute(PAGEELEMENT_MODEL_NAME) @Valid PageElement pageElement,
            BindingResult result,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(PAGEELEMENT_MODEL_NAME, pageElement);
            return gotoAddMenu(model);
        }
        privilegeService.doSavePageElement(pageElement, roleIds);
        return "admin/resource/pageElement/success";
    }

    @RequestMapping(value = "/admin/resource/pageElement/{id}/update", method = RequestMethod.GET)
    public String gotoUpdatePageElement(@PathVariable("id") Integer id,
                                        Model model) {
        if (!model.containsAttribute(PAGEELEMENT_MODEL_NAME)) {
            PageElement pageElement = privilegeService.queryPageElementById(id);
            model.addAttribute(PAGEELEMENT_MODEL_NAME, pageElement);
        }
        return "admin/resource/pageElement/update";
    }

    @RequestMapping(value = "/admin/resource/pageElement/{id}/update", method = RequestMethod.PUT)
    public String updatePageElement(
            @ModelAttribute(PAGEELEMENT_MODEL_NAME) @Valid PageElement pageElement,
            BindingResult result,
            Model model,
            @RequestParam(value = "roleIds", defaultValue = StringUtils.EMPTY) Integer[] roleIds) {
        if (result.hasErrors()) {
            model.addAttribute(PAGEELEMENT_MODEL_NAME, pageElement);
            return gotoUpdateMethod(pageElement.getId(), model);
        }
        privilegeService.doUpdatePageElement(pageElement, roleIds);
        return "admin/resource/pageElement/success";
    }

    @RequestMapping(value = "/admin/resource/pageElement/{id}/delete", method = RequestMethod.DELETE)
    public String deletePageElement(@PathVariable("id") Integer id) {
        privilegeService.doDeletePageElement(id);
        return "admin/resource/pageElement/success";
    }

//	@RequestMapping(value = "/admin/resource/pageElement/import", method = RequestMethod.GET)
//	public String gotoImportPageElement() {
//		return "admin/resource/pageElement/import";
//	}

//	@RequestMapping(value = "/admin/resource/pageElement/import", method = RequestMethod.POST)
//	public String importPageElementExcel(Model model,
//			@RequestParam MultipartFile excel) throws Exception {
//		privilegeService.doImportPageElementExcel(excel.getInputStream(),
//				validateUtil);
//
//		if (validateUtil.getErrorMessage() != null) {
//			model.addAttribute("errorMessage", validateUtil.getErrorMessage());
//			return gotoImportPageElement();
//		}
//
//		return "admin/resource/pageElement/success";
//	}

//	@RequestMapping(value = "/admin/resource/pageElement/export", method = RequestMethod.GET)
//	public void exportPageElementExcel(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultExcelService.exportExcel(
//				"/exportTemplete/admin/resource/pageElementExport.properties",
//				queryInfo);
//	}

    @RequestMapping(value = "/admin/resource/pageElement/gotoPreviewPageElementExcel", method = RequestMethod.GET)
    public String gotoPreviewPageElementExcel(Model model) {
        if (!model.containsAttribute(PREVIEW_LIST_MODEL_NAME)) {
            model.addAttribute(PREVIEW_LIST_MODEL_NAME,
                    new ArrayList<PageElement>());
        }
        return "admin/resource/pageElement/preview";
    }

//	@RequestMapping(value = "/admin/resource/pageElement/previewExcel", method = RequestMethod.POST)
//	public String previewPageElementExcel(Model model,
//			@RequestParam MultipartFile excel) throws IOException {
//		List<PageElement> previewList = excelBuilder.buildImport(excel
//				.getInputStream(), PageElement.class, defaultExcelService
//				.getSheetBuilder().getContentStrategy().getStartRowIndex());
//
//		model.addAttribute(PREVIEW_LIST_MODEL_NAME, previewList);
//		return gotoPreviewMenuExcel(model);
//	}

//	@RequestMapping(value = "/admin/resource/pageElement/exportPDF", method = RequestMethod.GET)
//	public void exportPageElementPDF(
//			HttpServletResponse response,
//			@ModelAttribute(PRIVILEGE_QUERY_MODEL_NAME) PrivilegeQueryObject privilegeQueryObject) {
//		QueryInfo queryInfo = QueryInfoBuilder
//				.buildQueryInfo(privilegeQueryObject);
//
//		defaultPDFService.exportPDF(
//				"/exportTemplete/admin/resource/pageElementExport.properties",
//				DEFAULT_PDF_PAGE_SIZE, queryInfo);
//	}

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(OrderType.class, new EnumEditor(
                OrderType.class));
        binder.registerCustomEditor(RequestMethod.class, new EnumEditor(
                RequestMethod.class));
    }
}