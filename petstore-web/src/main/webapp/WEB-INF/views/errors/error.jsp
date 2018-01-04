<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	Integer statusCode = (Integer) request
			.getAttribute("javax.servlet.error.status_code");
	String message = (String) request
			.getAttribute("javax.servlet.error.message");
	String servletName = (String) request
			.getAttribute("javax.servlet.error.servlet_name");
	String uri = (String) request
			.getAttribute("javax.servlet.error.request_uri");
	Throwable t = (Throwable) request
			.getAttribute("javax.servlet.error.exception");
	if (t == null) {
		t = (Throwable) request.getAttribute("exception");
	}
	Class<?> exception = (Class<?>) request
			.getAttribute("javax.servlet.error.exception_type");
	String exceptionName = "";
	if (exception != null) {
		exceptionName = exception.getName();
	}
	if (statusCode == null) {
		statusCode = 0;
	}
	if (statusCode == 500) {
		LOGGER.error(statusCode + "|" + message + "|" + servletName
				+ "|" + uri + "|" + exceptionName + "|"
				+ request.getRemoteAddr(), t);
	} else if (statusCode == 404) {
		LOGGER.error(statusCode + "|" + message + "|" + servletName
				+ "|" + uri + "|" + request.getRemoteAddr());
	}

	String queryString = request.getQueryString();
	String url = uri
			+ (queryString == null || queryString.length() == 0 ? ""
					: "?" + queryString);
	url = url.replaceAll("&amp;", "&").replaceAll("&", "&amp;");

	if (t != null) {
		LOGGER.error("error", t);
	}
%>
<html>
	<head>
		<title>页面<%=statusCode%>错误</title>
	</head>
	<body style="text-align: center">
		<img src="/static/img/smile.jpg" height="70%" width="60%"/>
		<br>
		<br>
		<%
			if (statusCode == 404) {
				out.println("对不起,此功能暂不开放.<br/><br/>");

			} else {
				out.println("对不起,此功能暂不开放.<br/><br/>");
			}
		%>
		<a href="javascript:void(0);" onclick="history.go(-1)">返回刚才页面</a>
	</body>
</html>
<%!private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
			.getLogger("DAILY_ALL");%>