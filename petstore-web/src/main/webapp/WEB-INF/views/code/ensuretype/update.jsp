<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>保障方式信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="ensureTypeModel"
			method="PUT" action="/ensureType/update" id="ensureTypeForm">
			<form:input path="id" value="${id}"  />
			<fieldset>
				<legend>
					修改保障方式信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label" for="name">
						保障方式名称:
					</label>
					<div class="controls">
						<form:input path="name"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						激活状态:
					</label>
					<div class="controls">
						<form:select path="act_status">
						   <form:option value="1">已激活</form:option>
						   <form:option value="0">未激活</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	<script type="text/javascript">
	         $(document).ready(function(){
                $("#ensureTypeForm").validate({
                   rules:{
                   name: "required"
                   },
                   messages:{
                   name: "请您输入保障方式名称"
                   }

                });
             });
	</script>


</body>