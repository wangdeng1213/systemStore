/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 安文涛
 * @version 1.0
 */
public class SessionContext {
    private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();

    private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

    public static ThreadLocal<HttpServletRequest> getRequestLocal() {
        return requestLocal;
    }

    public static void setRequestLocal(
            ThreadLocal<HttpServletRequest> requestLocal) {
        SessionContext.requestLocal = requestLocal;
    }

    public static ThreadLocal<HttpServletResponse> getResponseLocal() {
        return responseLocal;
    }

    public static void setResponseLocal(
            ThreadLocal<HttpServletResponse> responseLocal) {
        SessionContext.responseLocal = responseLocal;
    }

    public static HttpServletRequest getRequest() {
        return requestLocal.get();
    }

    public static void setRequest(HttpServletRequest request) {
        requestLocal.set(request);
    }

    public static HttpServletResponse getResponse() {
        return responseLocal.get();
    }

    public static void setResponse(HttpServletResponse response) {
        responseLocal.set(response);
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }
}