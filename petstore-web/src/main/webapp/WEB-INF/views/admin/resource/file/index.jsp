<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>
<head>
      <title>文件列表</title>
      <link rel="stylesheet" href="/static/css/pager/pager.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="privilegeQueryObjectForm" cssClass="form-inline"
						modelAttribute="privilegeQueryObject" action="/admin/resource/file/query"
						method="GET">
				<fieldset>
					<legend>
						<div class="row-fluid">
							<div class="span7">
							查询条件
							</div>
							<div class="span5" style="text-align: right">
								<div class="btn-group">
									<button class="btn btn-primary" type="submit">
										查询
									</button>
									<button class="btn" type="button" onclick="exportExcel('privilegeQueryObjectForm','/admin/resource/file/export','/admin/resource/file/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('privilegeQueryObjectForm','/admin/resource/file/exportPDF','/admin/resource/file/query');">
										导出PDF
									</button>
								</div>
							</div>
						</div>	
					</legend>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="fileName">
								文件名:
							</label>
							<form:input path="fileName" placeholder="文件名:模糊查询" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="fileLocation">
								文件路径:
							</label>
							<form:input path="fileLocation" placeholder="文件路径:模糊查询" />
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
								<form:option value="file.id">----请选择----</form:option>
								<form:option value="file.name">文件名</form:option>
								<form:option value="file.location">文件路径</form:option>
							</form:select>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">受保护文件列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('/admin/resource/file/add');">新增</a>
					<a href="#" class="btn" onclick="gotoImportExcel('/admin/resource/file/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/admin/resource/file/gotoPreviewFileExcel');">预览excel</a>
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
							文件名
						</th>
						<th>
							文件路径
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
					<c:forEach items="${privilegePage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.file.name }
							</td>
							<td>
								${cur.file.location }
							</td>
							<td>
								<auth:roles privilege="${cur}"/>
							</td>
							<td>
								<a href="<c:url value='/admin/resource/file/${cur.file.id}/update'/>"><i class="icon-edit" rel="tooltip" data-placement="bottom" title="修改"></i></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/admin/resource/file/${cur.file.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据"><i class="icon-trash" rel="tooltip" data-placement="bottom" title="删除"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="privilegePage" url="/admin/resource/file/query"></pager:legend>
		</div>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
    <script src="/static/js/p2p/1.0.0/p2p.js"></script>
    <script src="/static/js/p2p/1.0.0/document.min.js"></script>
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