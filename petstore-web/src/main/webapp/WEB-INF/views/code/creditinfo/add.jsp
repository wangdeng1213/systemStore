<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>信用档案信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="creditInfoModel"
			method="POST" action="/creditInfo/add">
			<form:input path="id" value="${id}"  />
			<fieldset>
				<legend>
					新增信用档案信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label" for="credit_rating">
						信用等级:
					</label>
					<div class="controls">
						<form:input path="credit_rating"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="credit_score">
						信用总分:
					</label>
					<div class="controls">
						<form:input path="credit_score"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="credit_available">
						可用额度:
					</label>
					<div class="controls">
						<form:input path="credit_available"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="borrow_app_times">
						申请借款次数:
					</label>
					<div class="controls">
						<form:input path="borrow_app_times"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="credit_lines">
						信用额度:
					</label>
					<div class="controls">
						<form:input path="credit_lines"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="overdue_amount">
						逾期金额:
					</label>
					<div class="controls">
						<form:input path="overdue_amount"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="successful_loan_times">
						成功借款次数:
					</label>
					<div class="controls">
						<form:input path="successful_loan_times"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="total_loan">
						借款总额:
					</label>
					<div class="controls">
						<form:input path="total_loan"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="overdue_times">
						逾期次数:
					</label>
					<div class="controls">
						<form:input path="overdue_times"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="pay_off">
						还清笔数:
					</label>
					<div class="controls">
						<form:input path="pay_off"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="to_pay">
						待还本息:
					</label>
					<div class="controls">
						<form:input path="to_pay"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="serious_overdue">
						严重逾期次数:
					</label>
					<div class="controls">
						<form:input path="serious_overdue"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="normal_times">
						正常还款次数:
					</label>
					<div class="controls">
						<form:input path="normal_times"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="user_id">
						借款人ID:
					</label>
					<div class="controls">
						<form:input path="user_id"  />
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