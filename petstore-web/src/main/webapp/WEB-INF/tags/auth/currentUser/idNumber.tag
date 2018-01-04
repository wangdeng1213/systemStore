<%@ tag description="证件号" pageEncoding="UTF-8"%>
<%@ tag import="com.peanut.security.springSecurity.utils.AuthUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:out value="<%=AuthUtils.getCurrentUser().getIdNumber() %>" />
