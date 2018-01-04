<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>新增用户组信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/bootstrap-multiselect.css"/>
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userGroupModel"
			method="POST" action="/admin/userGroup/add">
			<fieldset>
				<legend>
					新增用户组信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div id="sonGroup" class="control-group">
					<label class="control-label" for="name">
						名称:
					</label>
					<div class="controls">
						<form:input path="name" placeholder="用户组名称" />
					</div>
				</div>
				<c:if test="${not empty userGroupModel.parentUserGroup.id}">
					<div class="control-group">
						<label class="control-label" for="parentUserGroup.id">
							父用户组:
						</label>
						<div class="controls">
						    <select name="parentUserGroup.id">
						         <option value="">--请选择--</option>
						         <c:forEach items="${allPossibleUserGroupsModel}" var="cur">
						         	<option value="${cur.id }" <c:if test="${cur.id == userGroupModel.parentUserGroup.id}">selected</c:if>>${cur.name }</option>
						         </c:forEach>
						    </select>
						</div>
					</div>
				</c:if>
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
						<c:if test="${(empty userGroupModel.parentUserGroup.id) && (not empty allPossibleUserGroupsModel)}">
							<a class="btn" href="#" onclick="addParentGroup('sonGroup');">添加父用户组</a>
						</c:if>
						<a class="btn" href="/admin/userGroup/query">取消</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-multiselect.js"></script>
     <script type="text/javascript">
	     function addParentGroup(id){
	    	 $("#"+id).after(
	    	     '<div class="control-group">'+
						'<label class="control-label" for="parentUserGroup.id">'+
							'父用户组:'+
						'</label>'+
						'<div class="controls">'+
						    '<select name="parentUserGroup.id">'+
						    	'<option value="">-- 请选择 --</option>'+
						    	'<c:forEach items="${allPossibleUserGroupsModel}" var="cur">'+
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