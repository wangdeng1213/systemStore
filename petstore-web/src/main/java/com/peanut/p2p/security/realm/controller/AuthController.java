/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.realm.controller;

import com.peanut.p2p.editor.EnumEditor;
import com.peanut.p2p.security.realm.controller.enums.LoginError;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class AuthController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "errorCode", defaultValue = StringUtils.EMPTY) LoginError loginError,
            Model model) {
        if (loginError != null) {
            loginError.handleError(messageSource, model);
        }

        return "admin/auth/login";
    }

    @RequestMapping(value = "/auth/accessDenied", method = RequestMethod.GET)
    public String accessDenied() {
        return "errors/error";
    }

    @RequestMapping(value = "/auth/checkPassword", method = RequestMethod.GET)
    public String gotoCheckPassword() {
        return "admin/auth/checkPassword";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LoginError.class, new EnumEditor(
                LoginError.class));
    }
}