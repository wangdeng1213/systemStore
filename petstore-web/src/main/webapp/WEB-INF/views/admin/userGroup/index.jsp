<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>
<head>
    <title>用户组列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="userGroupQueryObjectForm" cssClass="form-inline"
						modelAttribute="userGroupQueryObject" action="/admin/userGroup/query"
						method="GET">
				<fieldset>
					<legend>
						<div class="row-fluid">
							<div class="span7">
							查询条件
							</div>
							<div class="span5" style="text-align: right">
								<button class="btn btn-primary" type="submit">
									查询
								</button>
							</div>
						</div>	
					</legend>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="name">
								用户组名称:
							</label>
							<form:input path="name" placeholder="用户组名称:模糊查询" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="parentName">
								父用户组名称:
							</label>
							<form:input path="parentName" placeholder="父用户组名称:模糊查询" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="orders[0].orderType">
								排序类型:
							</label>
							<form:select path="orders[0].orderType">
								<form:option value="">----请选择----</form:option>
								<form:option value="asc">正序</form:option>
								<form:option value="desc">倒序</form:option>
							</form:select>
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="name">用户名称</form:option>
								<form:option value="parentUserGroup.name">父用户组名称</form:option>
							</form:select>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">用户组列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<a href="#" class="btn btn-primary" onclick="gotoAdd('/admin/userGroup/add');">新增</a>
			</div>
		</div>
		<div class="row-fluid">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							用户组名称
						</th>
						<th>
							父用户组名称
						</th>
						<th>
							角色
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userGroupPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.name }
							</td>
							<td>
								${cur.parentUserGroup.name }							
							</td>
							<td>
								<auth:roles userGroup="${cur}"></auth:roles>							
							</td>
							<td>
								<a href="<c:url value='/admin/userGroup/${cur.id}/update'/>"><i class="icon-edit" rel="tooltip" data-placement="bottom" title="修改"></i></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/admin/userGroup/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据"><i class="icon-trash" rel="tooltip" data-placement="bottom" title="删除"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="userGroupPage" url="/admin/userGroup/query"></pager:legend>
		</div>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
    <script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script type="text/javascript">
		function hideTrash(id){
			$(id).popover('hide');
		}
		$(document).ready(function(){
			$("[rel=tooltip]").tooltip();
			$("a[id^=trash]").popover({html : true}).click(function(e) {
		        e.preventDefault();
		    });
		});
	</script>
</body>