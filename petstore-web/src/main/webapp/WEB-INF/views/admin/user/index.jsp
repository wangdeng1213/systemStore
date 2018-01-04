<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="authorize" uri="http://www.peanut.com/authorize"%>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/bootstrap-toggle-buttons.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="userQueryObjectForm" cssClass="form-inline"
						modelAttribute="userQueryObject" action="/admin/user/query"
						method="GET">
				<fieldset>
					<legend>
					    <div class="row-fluid">
                            1222222222
					    </div>
					    <div class="row-fluid">

					    </div>
						<div class="row-fluid">
							<div class="span7">
							查询条件
							</div>
							<div class="span5" style="text-align: right">
								<div class="btn-group">

				                              <authorize:authorize privilegeType="pageElement" resource="searchBtn" >
                                   <button id="searchBtn" class="btn btn-primary" type="submit">
                                   查询    </button>  </authorize:authorize>
									<button class="btn" type="button" onclick="exportExcel('userQueryObjectForm','/admin/user/export','/admin/user/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('userQueryObjectForm','/admin/user/exportPDF','/admin/user/query');">
										导出PDF
									</button>
								</div>
							</div>
						</div>
					</legend>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="userName">
								用户名称:
							</label>
							<form:input path="userName" placeholder="用户名称:模糊查询" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="idNumber">
								工作证号:
							</label>
							<form:input path="idNumber" placeholder="工作证号:精确查询" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="orders[0].orderType">
								排序类型:
							</label>
							<form:select path="orders[0].orderType">
								<form:option value="asc">正序</form:option>
								<form:option value="desc">倒序</form:option>
							</form:select>
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="">----请选择----</form:option>
								<form:option value="id">添加时间</form:option>
								<form:option value="userName">用户名称</form:option>
								<form:option value="idNumber">工作证号</form:option>
							</form:select>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
		<div class="row-fluid">
			<div class="span4">
				<p class="lead">用户列表</p>
			</div>
			<div class="span8" style="text-align: right">
				<div class="btn-group">

					<a href="#" class="btn btn-primary" onclick="gotoAdd('/admin/user/add');">新增</a>
					<a href="#" class="btn" onclick="gotoImportExcel('/admin/user/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/admin/user/gotoPreviewExcel');">预览excel</a>
					<a href="#" id="trashBatch" class="btn" rel="popover" data-placement="left" data-content='<form:form id="batchDeleteForm" action="/admin/user/delete" method="DELETE"><input id="batchDeleteIds" name="batchDeleteIds" type="hidden"/><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="button" class="btn btn-primary" onclick="batchDelete()">是</button><a class="btn" href="#" onclick="hidePopover(trashBatch)">否</a></div></div></form:form>' title="请确定是否删除数据">批量删除</a>
				</div>
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
							状态
						</th>
						<th>
							操作
						</th>
						<th width="5%">
    						全选
    						<input type="checkbox" id="checkAll">
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.userName }
                               <auth:isActiveUser user="${cur}">
									<i class="icon-user"></i>
								</auth:isActiveUser>
							</td>
							<td>
								${cur.idNumber }
							</td>
							<td>
								<auth:userGroups user="${cur}"/>
							</td>
							<td>
								<auth:roles user="${cur}"/>
							</td>
							<td>
								<c:choose>
									<c:when test="${cur.enabled == true}">
										<span class="badge badge-success">已激活</span>
									</c:when>
									<c:otherwise>
										<span class="badge">未激活</span>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<a href="<c:url value='/admin/user/${cur.id}/update'/>"><i class="icon-edit" rel="tooltip" data-placement="bottom" title="修改"></i></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/admin/user/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hidePopover(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据"><i class="icon-trash" rel="tooltip" data-placement="bottom" title="删除"></i></a>
							</td>
							<td>
						    	<div toggle-buttons-name="normal-toggle-button">
    								<input type="checkbox" name="checkUser" value="${cur.id }">
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="userPage" url="/admin/user/query"></pager:legend>
		</div>
	</div>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-toggleButtons.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/p2p/1.0.0/extension.min.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>
	<script type="text/javascript">
		function batchDelete(){
			if (getCheckedValues("checkUser").length <= 0) {
				$("#trashBatch").popover('hide');
				return;
			}
			$("#batchDeleteIds").val(getCheckedValues("checkUser"));
			$("#batchDeleteForm").submit();
		}
		$(document).ready(function(){
			$("#checkAll").click(function(){
					var toggleState = false;
					if($(this).attr("checked") == "checked"){
						toggleState = true;
					}
					changeToggleButton('normal-toggle-button',toggleState);
			});
			$("div[toggle-buttons-name=normal-toggle-button]").toggleButtons({
				height:20,
				width:70
			});
			$("[rel=tooltip]").tooltip();
			$("a[id^=trash]").popover({html : true}).click(function(e) {
		        e.preventDefault();
		    });
		});
	</script>
</body>