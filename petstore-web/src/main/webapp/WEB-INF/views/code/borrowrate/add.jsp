<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>借款利率信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="borrowRateModel"
			method="POST" action="/borrowRate/add" id="borrowRateForm">
			<form:input path="id" value="${id}"  />
			<fieldset>
				<legend>
					新增借款利率信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label">
						信用等级:
					</label>
					<div class="controls">
						<form:input path="credit_rating"  placeholder="信用等级：AA" />
					</div>
				</div>
				<form:errors cssStyle="color:red" path="credit_rating" />
				<div class="control-group">
					<label class="control-label" >
						信用分数区间:
					</label>
					<div class="controls">
						<form:input path="credit_score_range" placeholder="信用分数区间:50-60" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="month_rate">
						月综合费率:
					</label>
					<div class="controls">
						<form:input path="month_rate"   placeholder="月综合费率:0.66%" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="first_ser_rate">
						期初服务费:
					</label>
					<div class="controls">
						<form:input path="first_ser_rate"  placeholder="期初服务费:0.66%"  />
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
            $("#borrowRateForm").validate({
               rules:{
               credit_rating: "required",
               credit_score_range: "required",
               month_rate: "required",
               first_ser_rate: "required"
               },
               messages:{
               credit_rating: "请您输入信用等级",
               credit_score_range: "请您输入信用分数区间",
               month_rate: "请您输入月综合费率",
               first_ser_rate: "请您输入期初服务费"
               }

            });
         });

	</script>


</body>