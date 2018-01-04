<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>新增公司信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="companyModel"
			method="POST" action="/company/add">
			<fieldset>
				<legend>
					新增公司信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="name">
						名称:
					</label>
					<div class="controls">
						<form:input path="name" placeholder="公司名称:最少两个字符" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email">
						邮箱:
					</label>
					<div class="controls">
						<form:input path="email" placeholder="邮箱:xxx@xxx.com" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="phone">
						电话:
					</label>
					<div class="controls">
						<form:input path="phone" placeholder="公司电话:010-12345678" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="registerDate">
						注册日期:
					</label>
					<div class="controls">
						<form:input id="registerDate" path="registerDate"
						    data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
							placeholder="公司注册日期:2012-12-21" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="persons">
						人数:
					</label>
					<div class="controls">
						<form:input path="persons" placeholder="公司注册人数" />
					</div>
				</div>
				<div id="dialog" title="Dialog Title">34</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<a class="btn" href="/petstore-web/company">取消</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	<script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#registerDate').datepicker({
				format:'yyyy-mm-dd'
			});
			$("#dialog").dialog();
		});


	</script>
</body>