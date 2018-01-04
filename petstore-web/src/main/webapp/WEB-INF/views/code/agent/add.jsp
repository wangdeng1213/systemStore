<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>借款人信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="agentModel"
			method="POST" action="/agent/add" id="agentForm">
			<form:input path="id" value="${id}"  />
			<fieldset>
				<legend>
					新增借款人信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label">
						借款人ID:
					</label>
					<div class="controls">
						<form:input path="userId" placeholder="11" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="name">
						借款人名称:
					</label>
					<div class="controls">
						<form:input path="name" placeholder="代理商名称：最少两个字符" />
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
            $("#agentForm").validate({
               rules:{
               userId:"required",
               name: "required"
               },
               messages:{
               userId:"请您输入借款人ID",
               name: "请您输入借款人名称"
               }

            });
         });
	</script>


</body>