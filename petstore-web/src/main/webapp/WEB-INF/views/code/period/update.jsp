<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>借款期限信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="periodModel"
			method="PUT" action="/period/${id}/update" id="periodForm">
			<form:input path="id" value="${id}"  />
			<fieldset>
				<legend>
					修改借款期限信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label">
						借款期限:
					</label>
					<div class="controls">
						<form:input path="loan_term"  />月
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						月综合费率:
					</label>
					<div class="controls">
						<form:input path="month_rate"  />%
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
            $("#periodForm").validate({
               rules:{
               loan_term: "required",
               month_rate: "required"
               },
               messages:{
               loan_term: "请您输入借款期限",
               month_rate: "请您输入月综合费率"
               }

            });
         });
	</script>


</body>