<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="com.peanut.security.springSecurity.utils.AuthUtils"%>
<%@ attribute name="user"
	type="com.peanut.security.realm.entity.user.User"
	rtexprvalue="true" required="true" description="用户"%>
<%
	if (AuthUtils.isActiveUser(user)) {
%>
<jsp:doBody />
<%
	}
%>