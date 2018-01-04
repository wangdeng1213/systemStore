<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>合同信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="contractModel"
			method="POST" action="/contract/add">
			<form:input path="id" value="${id}"  />
			<fieldset>
				<legend>
					新增合同信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label" for="contract_sort">
						合同类别:
					</label>
					<div class="controls">
						<form:input path="contract_sort"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="contract_item">
						合同类型:
					</label>
					<div class="controls">
						<form:input path="contract_item"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="borrow_id">
						借款表ID:
					</label>
					<div class="controls">
						<form:input path="borrow_id"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="tender_id">
						投资表ID:
					</label>
					<div class="controls">
						<form:input path="tender_id"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="borrow_userid">
						借款人:
					</label>
					<div class="controls">
						<form:input path="borrow_userid"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="tender_userid">
						投资人:
					</label>
					<div class="controls">
						<form:input path="tender_userid"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="contract_code">
						合同编号:
					</label>
					<div class="controls">
						<form:input path="contract_code"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="contract_wyh">
						合同唯一号:
					</label>
					<div class="controls">
						<form:input path="contract_wyh"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="file_name">
						文件名称:
					</label>
					<div class="controls">
						<form:input path="file_name"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="file_display_name">
						文件显示名称:
					</label>
					<div class="controls">
						<form:input path="file_display_name"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="file_path">
						文件路径:
					</label>
					<div class="controls">
						<form:input path="file_path"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="file_type">
						文件类型:
					</label>
					<div class="controls">
						<form:input path="file_type"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="file_size">
						文件大小:
					</label>
					<div class="controls">
						<form:input path="file_size"  />
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
        <script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" ></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-zh-CN.js" type="text/javascript"></script>
	<script type="text/javascript">
	</script>


</body>