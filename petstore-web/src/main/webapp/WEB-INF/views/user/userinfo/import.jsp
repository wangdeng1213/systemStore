<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>导入Excel文件</title>
</head>
<body>
	<div class="container-fluid">
		<form action="/user/import" class="form-horizontal" method="POST"
			enctype="multipart/form-data">
			<fieldset>
				<legend>
					导入Excel文件
				</legend>
				<div class="control-group">
					<label class="control-label" for="excel">
						 文件<i class="icon-folder-open"></i>
					</label>
					<div class="controls">
						<input type="file" id="excel" name="file" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<a class="btn" href="/user/import">取消</a>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>