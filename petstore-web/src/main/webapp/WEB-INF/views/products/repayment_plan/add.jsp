<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>应付收益计划信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="repayment_planModel"
			method="POST" action="/repayment_plan/add">
			<fieldset>
				<legend>
					新增应付收益计划信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label" for="product_id">
						产品ID:
					</label>
					<div class="controls">
						<form:input path="product_id"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="repayment_time">
						应付收益计划时间:
					</label>
					<div class="controls">
					    <form:input path="repayment_time" data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
                                                                              	placeholder="日期:2012-12-21"   />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="finish">
						是否结束:
					</label>
					<div class="controls">
						<form:input path="finish" />
					</div>
				</div>
				<div class="control-group">
                	<label class="control-label" for="days">
                		 天数:
                	</label>
                	<div class="controls">
                		<form:input path="days" />
                	</div>
                </div>
                	<div class="control-group">
                             <label class="control-label" for="actual_repayment_time">
                                	实际收益时间:
                              </label>
                              <div class="controls">
                                	<form:input path="actual_repayment_time"  data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
                                                                                placeholder="日期:2012-12-21"  />
                              </div>
                   </div>
                  <div class="control-group">
					<label class="control-label" for="description">
						描述:
					</label>
					<div class="controls">
						<form:textarea path="description"  />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<a class="btn" href="/repayment_plan/query">取消</a>
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
		$(document).ready(function(){
			$('#repayment_time').datepicker({
				format:'yyyy-mm-dd'
			});
			$('#actual_repayment_time').datepicker({
				format:'yyyy-mm-dd'
			});
		});
	</script>


</body>