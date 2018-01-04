<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>修改用户信息</title>
    <link rel="stylesheet" href="/css/bootstrap/bootstrap-multiselect.css"/>
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userModel"
			method="PUT" action="/admin/user/${id}/update">
			<fieldset>
				<legend>
					修改用户信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="userName">
						名称:
					</label>
					<div class="controls">
						<form:input path="userName" placeholder="用户名称" />
						<form:hidden path="password" placeholder="用户密码" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="idNumber">
						证件号:
					</label>
					<div class="controls">
						<form:input path="idNumber" placeholder="工作证或是学生证号码" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="rolesSelect">
						角色:
					</label>
					<div class="controls">
						<select id="rolesSelect" name="roleIds" multiple="multiple">
							<c:forEach items="${allRolesModel}" var="cur">
								<option value="${cur.id }" <c:forEach items="${userModel.roles}" var="curRole"><c:if test="${cur.id == curRole.id }">selected</c:if></c:forEach>>${cur.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userGroupsSelect">
						用户组:
					</label>
					<div class="controls">
						<select id="userGroupsSelect" name="userGroupIds" multiple="multiple">
							<c:forEach items="${allUserGroupsModel}" var="cur">
								<option value="${cur.id }" <c:forEach items="${userModel.userGroups}" var="curUserGroup"><c:if test="${cur.id == curUserGroup.id }">selected</c:if></c:forEach>>${cur.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="enabled">
						是否激活:
					</label>
					<div class="controls">
						<form:select path="enabled">
							<form:option value="true"></form:option>
							<form:option value="false"></form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<a class="btn" href="/admin/user/query">取消</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	<script src="/js/bootstrap/bootstrap-multiselect.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#rolesSelect').multiselect();
			$('#userGroupsSelect').multiselect();
		});
	</script>
</body>