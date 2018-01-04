<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta http-equiv="refresh" content="2;url=<c:url value="/riskinfo/query"/>">
    <title>操作成功</title>
</head>
<body>
	<div style="text-align: center;margin-top:120px;">
		<a href="<c:url value='/riskinfo/query'/>">
			<img src="/static/img/okok.png"/>
		</a>
		<br/><h3>操作成功,2秒后返回！可点击图片返回</h3>
	</div>
</body>