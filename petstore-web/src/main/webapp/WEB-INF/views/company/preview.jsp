<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>预览Excel文件</title>
</head>
<body>
	<div class="container-fluid">
		<form action="/company/previewExcel" class="form-horizontal" method="POST"
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
						<a class="btn" href="/company">取消</a>
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
								公司名称
							</th>
							<th>
								电子邮箱
							</th>
							<th>
								电话
							</th>
							<th>
								注册时间
							</th>
							<th>
								人数
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
									${cur.name }
								</td>
								<td>
									${cur.email }
								</td>
								<td>
									${cur.phone }
								</td>
								<td>
									${cur.registerDate }
								</td>
								<td>
									${cur.persons }
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
</body>