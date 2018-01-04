/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.realm.controller;

import com.peanut.p2p.context.SessionContext;
import com.peanut.p2p.util.FileOperateUtil;

import com.peanut.security.realm.entity.resource.File;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author my
 * @version 1.0
 */
@Controller
public class FileOperateController {

  // private static final String FILE_QUERY_MODEL_NAME = "fileQueryObject";

  // private static final String FILE_PAGE_MODEL_NAME = "filePage";

   private static final String FILE_MODEL_NAME = "fileModel";
   @RequestMapping(value = "/file/toUpload", method = RequestMethod.GET)
   public String gotoUpload(Model model) {
      if (!model.containsAttribute(FILE_MODEL_NAME)) {
         model.addAttribute(FILE_MODEL_NAME, new File());
      }
      return "file/upload";
   }

   @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
   public String upload(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request) throws Exception {
      Map<String, Object> map = new HashMap<String, Object>();
      // 别名
      String[] alaises = ServletRequestUtils.getStringParameters(request,
              "alais");
      String[] params = new String[] { "alais" };
      Map<String, Object[]> values = new HashMap<String, Object[]>();
      values.put("alais", alaises);

      List<Map<String, Object>> result = FileOperateUtil.upload(request,
              params, values);
      map.put("result", result);
      return "file/success";
   }
   @RequestMapping(value = "/file/download", method = RequestMethod.GET)
   public String download( Model model,
                           @ModelAttribute(FILE_MODEL_NAME) @Valid File file,
                           BindingResult result) throws Exception {
//          String storeName = "201205051340364510870879724.zip";
//          String realName = "Java设计模式.zip";
//          String contentType = "application/octet-stream";
      HttpServletRequest request = SessionContext.getRequest();
      HttpServletResponse response = SessionContext.getResponse();
 //     FileOperateUtil.download(request,response,storeName,contentType,realName);
     return "file/success";
   }
}