<%@ tag description="当前用户角色名" pageEncoding="UTF-8"%>
<%@ tag import="com.peanut.security.springSecurity.utils.AuthUtils"%>
<%@ attribute name="separator" type="java.lang.String"
	rtexprvalue="true" required="false" description="输出分隔符"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty separator}">
	<%
		separator = ",";
	%>
</c:if>
<c:out value="<%=AuthUtils.getRoleNames(separator) %>" />