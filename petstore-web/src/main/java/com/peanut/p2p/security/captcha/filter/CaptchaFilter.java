/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.captcha.filter;

import com.google.code.kaptcha.Constants;
import com.peanut.p2p.context.SessionContext;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 安文涛
 * @version 1.0
 */
public class CaptchaFilter implements Filter {
    private static final String CONFIG_CAPTCHAPARAMETER_NAME = "captchaParameterName";

    private static final String DEFAULT_CAPTCHA_PARAMETER_NAME = "j_captcha";

    private static final String CONFIG_FAIL_URL = "failUrl";

    private String captchaParameterName = DEFAULT_CAPTCHA_PARAMETER_NAME;

    private String failUrl;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String sessionCaptchaKey = (String) SessionContext.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String captchaParameter = request.getParameter(captchaParameterName);

        if (captchaParameter.equalsIgnoreCase(sessionCaptchaKey)) {
            filterChain.doFilter(request, response);
        } else {
            if (StringUtils.isBlank(failUrl)) {
                failUrl = request.getHeader("Referer");
                response.sendRedirect(failUrl);
            } else {
                response.sendRedirect(request.getContextPath() + failUrl);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (StringUtils.isNotBlank(filterConfig
                .getInitParameter(CONFIG_CAPTCHAPARAMETER_NAME))) {
            captchaParameterName = filterConfig
                    .getInitParameter(CONFIG_CAPTCHAPARAMETER_NAME);
        }

        if (StringUtils.isNotBlank(filterConfig
                .getInitParameter(CONFIG_FAIL_URL))) {
            failUrl = filterConfig.getInitParameter(CONFIG_FAIL_URL);
        }
    }
}