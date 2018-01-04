<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>银行信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="bankModel"
			method="PUT" action="/bank/${bankModel.bank_id}/update" enctype="multipart/form-data" id="bankForm">
			<form:input path="bank_id" value="${bank_id}"/>
			<form:input path="picId" value="${picId}" />
			<fieldset>
				<legend>
					修改银行信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label" for="bank_name">
						银行名称:
					</label>
					<div class="controls">
						<form:input path="bank_name"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="bank_address">
						银行地址:
					</label>
					<div class="controls">
						<form:input path="bank_address"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="bank_no">
						银行编号:
					</label>
					<div class="controls">
						<form:input path="bank_no"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="bank_phone">
						银行电话:
					</label>
					<div class="controls">
						<form:input path="bank_phone"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						银行图片:
					</label>
					<div class="controls">
						<input type="file" name="content" id="content"   />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="bank_branch">
						开户行:
					</label>
					<div class="controls">
						<form:input path="bank_branch"  />
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
                $("#bankForm").validate({
                   rules:{
                   bank_name: "required",
                   bank_address: "required",
                   bank_no: "required",
                   bank_phone: "required",
                   content: "required",
                   bank_branch: "required"
                   },
                   messages:{
                   bank_name: "请您输入银行名称",
                   bank_address: "请您输入银行地址",
                   bank_no: "请您输入银行编号",
                   bank_phone: "请您输入银行电话",
                   content: "请您选择银行图片",
                   bank_branch: "请您选择开户行"
                   }

                });
             });
	</script>


</body>