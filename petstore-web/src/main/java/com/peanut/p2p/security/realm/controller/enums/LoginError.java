/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.realm.controller.enums;

import com.peanut.p2p.context.SessionContext;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

/**
 * @author 安文涛
 * @version 1.0
 */
public enum LoginError {
    badCredentials {
        @Override
        public void handleError(MessageSource messageSource, Model model) {
            model.addAttribute("loginErrorModel", ((Exception) SessionContext
                    .getSession()
                    .getAttribute("SPRING_SECURITY_LAST_EXCEPTION"))
                    .getMessage());
        }
    },
    badCaptcha {
        @Override
        public void handleError(MessageSource messageSource, Model model) {
            model.addAttribute("loginErrorModel", messageSource.getMessage(
                    "badCaptcha", null, null));
        }
    },
    invalidSession {
        @Override
        public void handleError(MessageSource messageSource, Model model) {
            model.addAttribute("loginErrorModel", messageSource.getMessage(
                    "invalidSession", null, null));
        }
    },
    concurrentSessionExpired {
        @Override
        public void handleError(MessageSource messageSource, Model model) {
            model.addAttribute("loginErrorModel", messageSource.getMessage(
                    "concurrentSessionExpired", null, null));
        }
    };

    public abstract void handleError(MessageSource messageSource, Model model);
}