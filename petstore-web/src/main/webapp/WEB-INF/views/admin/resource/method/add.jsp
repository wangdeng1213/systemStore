<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>新增受保护方法信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/bootstrap-multiselect.css"/>
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="methodModel"
			method="POST" action="/admin/resource/method/add">
			<fieldset>
				<legend>
					新增受保护方法信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="name">
						方法名:
					</label>
					<div class="controls">
						<form:input path="name" placeholder="受保护方法名称" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="className">
						所在类名:
					</label>
					<div class="controls">
						<form:input path="className" placeholder="方法所在类名" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="rolesSelect">
						角色:
					</label>
					<div class="controls">
						<select id="rolesSelect" name="roleIds" multiple="multiple">
							<c:forEach items="${allRolesModel}" var="cur">
								<option value="${cur.id }">${cur.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<a class="btn" href="/admin/resource/method/query">取消</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-multiselect.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#rolesSelect').multiselect();
        });
    </script>
</body>