<%@ tag import="com.peanut.security.springSecurity.utils.AuthUtils"%>
<%@ tag description="角色名" pageEncoding="UTF-8"%>
<%@ attribute name="separator" type="java.lang.String"
	rtexprvalue="true" required="false" description="输出分隔符"%>
<%@ attribute name="user"
	type="com.peanut.security.realm.entity.user.User"
	rtexprvalue="true" required="false" description="用户"%>
<%@ attribute name="userGroup"
	type="com.peanut.security.realm.entity.user.UserGroup"
	rtexprvalue="true" required="false" description="用户组"%>
<%@ attribute name="privilege"
	type="com.peanut.security.realm.entity.privilege.Privilege"
	rtexprvalue="true" required="false" description="权限"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty separator}">
	<%
		separator = ",";
	%>
</c:if>
<c:choose>
	<c:when test="${not empty user}">
		<c:out value="<%=AuthUtils.getRoleNames(separator,user) %>" />
	</c:when>
	<c:when test="${not empty userGroup}">
		<c:out value="<%=AuthUtils.getRoleNames(separator,userGroup) %>" />
	</c:when>
	<c:when test="${not empty privilege}">
		<c:out value="<%=AuthUtils.getRoleNames(separator,privilege) %>" />
	</c:when>
	<c:otherwise>
		<c:out value="" />
	</c:otherwise>
</c:choose>