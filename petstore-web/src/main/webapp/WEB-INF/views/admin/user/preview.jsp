<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>预览Excel文件</title>
</head>
<body>
	<div class="container-fluid">
		<form action="/admin/user/previewExcel" class="form-horizontal" method="POST"
			enctype="multipart/form-data">
			<fieldset>
				<legend>
					预览Excel文件
				</legend>
				<div class="control-group">
					<label class="control-label" for="excel">
						 文件<i class="icon-folder-open"></i>
					</label>
					<div class="controls">
						<input type="file" id="excel" name="excel" />
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
		</form>
		<c:if test="${!empty previewList}">
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
								密码
							</th>
							<th>
								工作证号
							</th>
							<th>
								是否激活
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${previewList}" var="cur" varStatus="s">
							<tr>
								<td>
									${s.index+1 }
								</td>
								<td>
									${cur.userName }
								</td>
								<td>
									${cur.password }
								</td>
								<td>
									${cur.idNumber }
								</td>
								<td>
									${cur.enabled }
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
</body>