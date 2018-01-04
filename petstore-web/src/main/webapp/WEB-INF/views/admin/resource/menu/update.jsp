<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>修改菜单信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/bootstrap-multiselect.css"/>
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="menuModel"
			method="PUT" action="/admin/resource/menu/${id}/update">
			<fieldset>
				<legend>
					修改菜单信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div id="sonMenu" class="control-group">
					<label class="control-label" for="name">
						名称:
					</label>
					<div class="controls">
						<form:input path="name" placeholder="菜单名称" />
					</div>
				</div>
				<c:if test="${not empty menuModel.parentMenu.id}">
					<div class="control-group">
						<label class="control-label" for="parentMenu.id">
							父菜单:
						</label>
						<div class="controls">
						    <select name="parentMenu.id">
						         <option value="">--请选择--</option>
						         <c:forEach items="${allPossibleParentMenusModel}" var="cur">
						         	<option value="${cur.id }" <c:if test="${cur.id == menuModel.parentMenu.id}">selected</c:if>>${cur.name }</option>
						         </c:forEach>
						    </select>
						</div>
					</div>
				</c:if>
				<div class="control-group">
					<label class="control-label" for="url">
						URL名称:
					</label>
					<div class="controls">
						<form:input path="url" placeholder="URL名称" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="rolesSelect">
						角色:
					</label>
					<div class="controls">
						<select id="rolesSelect" name="roleIds" multiple="multiple">
							<c:forEach items="${allRolesModel}" var="cur">
								<option value="${cur.id }" <c:forEach items="${menuModel.privilege.roles}" var="curRole"><c:if test="${cur.id == curRole.id }">selected</c:if></c:forEach>>${cur.name }</option>
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
						<c:if test="${(empty menuModel.parentMenu.id) && (not empty allPossibleParentMenusModel)}">
							<a class="btn" href="#" onclick="addParentMenu('sonMenu');">添加父菜单</a>
						</c:if>
						<a class="btn" href="/admin/resource/menu/query">取消</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-multiselect.js"></script>
     <script type="text/javascript">
	     function addParentMenu(id){
	    	 $("#"+id).after(
	    	     '<div class="control-group">'+
						'<label class="control-label" for="parentMenu.id">'+
							'父菜单:'+
						'</label>'+
						'<div class="controls">'+
						    '<select name="parentMenu.id">'+
						    	'<option value="">-- 请选择 --</option>'+
						    	'<c:forEach items="${allPossibleParentMenusModel}" var="cur">'+
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