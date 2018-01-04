<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>新增页面操作信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/bootstrap-multiselect.css"/>
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="operationModel"
			method="POST" action="/admin/resource/operation/add">
			<fieldset>
				<legend>
					新增页面操作信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div id="sonOperation" class="control-group">
					<label class="control-label" for="name">
						名称:
					</label>
					<div class="controls">
						<form:input path="name" placeholder="页面操作名称" />
					</div>
				</div>
				<c:if test="${not empty operationModel.parentOperation.id}">
					<div class="control-group">
						<label class="control-label" for="parentOperation.id">
							父操作:
						</label>
						<div class="controls">
						    <select name="parentOperation.id">
						         <option value="">--请选择--</option>
						         <c:forEach items="${allPossibleParentOperationsModel}" var="cur">
						         	<option value="${cur.id }" <c:if test="${cur.id == operationModel.parentOperation.id}">selected</c:if>>${cur.name }</option>
						         </c:forEach>
						    </select>
						</div>
					</div>
				</c:if>
				<div class="control-group">
					<label class="control-label" for="prefixUrl">
						URL名称:
					</label>
					<div class="controls">
						<form:input path="prefixUrl" placeholder="URL名称" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="requestMethod">
						HTTP方法名称:
					</label>
					<div class="controls">
						<form:select path="requestMethod">
							<form:option value="" label="--请选择--"/>
							<form:options items="${requestMethodsModel}" />
						</form:select>
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
						<c:if test="${(empty operationModel.parentOperation.id) && (not empty allPossibleParentOperationsModel)}">
							<a class="btn" href="#" onclick="addParentOperation('sonOperation');">添加父菜单</a>
						</c:if>
						<a class="btn" href="/admin/resource/operation/query">取消</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-multiselect.js"></script>
     <script type="text/javascript">
	     function addParentOperation(id){
	    	 $("#"+id).after(
	    	     '<div class="control-group">'+
						'<label class="control-label" for="parentOperation.id">'+
							'父操作:'+
						'</label>'+
						'<div class="controls">'+
						    '<select name="parentOperation.id">'+
						    	'<option value="">-- 请选择 --</option>'+
						    	'<c:forEach items="${allPossibleParentOperationsModel}" var="cur">'+
						    	    '<option value="${cur.id }">${cur.name }</option>'+
						    	'</c:forEach>'+
						    '</select>'+
						'</div>'+
				 '</div>');
	     }
	     $(document).ready(function(){
			$('#rolesSelect').multiselect();
		});
     </script>
</body>