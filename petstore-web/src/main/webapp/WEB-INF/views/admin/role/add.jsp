<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>新增角色信息</title>
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="roleModel"
			method="POST" action="/admin/role/add">
			<fieldset>
				<legend>
					新增角色信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="name">
						名称:
					</label>
					<div class="controls">
						<form:input path="name" placeholder="角色名称" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="peanutRole">
						URP角色名称:
					</label>
					<div class="controls">
						<form:select path="peanutRole">
							<form:option value="" label="--请选择--"/>
							<form:options items="${urpRolesModel}" />
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<a class="btn" href="/admin/role/query">取消</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>