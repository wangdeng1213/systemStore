<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>
<head>
    <title>在线用户列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/flexiGrid/flexigrid.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span4">
				<p class="lead">在线用户列表</p>
			</div>
		</div>
		<div class="row-fluid">
			<table id="activeUsers">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							用户名称
						</th>
						<th>
							工作证号
						</th>
						<th>
							用户组
						</th>
						<th>
							角色
						</th>
						<th>
							上次活动时间
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allActiveUsers}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.key.user.userName }
							</td>
							<td>
								${cur.key.user.idNumber }
							</td>
							<td>
								<auth:userGroups user="${cur.key.user}"/>
							</td>
							<td>
								<auth:roles user="${cur.key.user}"/>
							</td>
							<td>
								${cur.value }
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
    <script type="text/javascript" src="/static/js/flexiGrid/flexigrid.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#activeUsers').flexigrid();
        });
    </script>
</body>