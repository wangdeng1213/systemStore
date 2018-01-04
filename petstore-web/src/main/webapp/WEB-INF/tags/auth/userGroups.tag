<%@ tag description="用户组名" pageEncoding="UTF-8"%>
<%@ tag import="com.peanut.security.springSecurity.utils.AuthUtils"%>
<%@ attribute name="separator" type="java.lang.String"
	rtexprvalue="true" required="false" description="输出分隔符"%>
<%@ attribute name="user"
	type="com.peanut.security.realm.entity.user.User"
	rtexprvalue="true" required="true" description="用户"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty separator}">
	<%
		separator = ",";
	%>
</c:if>
<c:out value="<%=AuthUtils.getUserGroupNames(separator,user) %>" />