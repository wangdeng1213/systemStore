<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>新增个人账户信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form id="uaAddObjectForm" cssClass="form-horizontal" modelAttribute="userAccountModel"
			method="POST" action="/user/useraccount/add">
			<fieldset>
				<legend>
					新增个人账户信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
			<!--	<div class="control-group">
					<label class="control-label" for="id">
						账户主键:
					</label>
					<div class="controls">
						<form:input path="id" />
					</div>
				</div>-->
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:
					</label>
					<div class="controls">
						<form:input path="userId" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="totalMoney">
						充值总额:
					</label>
					<div class="controls">
						<form:input path="totalMoney"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="currentMoney">
						余额:
					</label>
					<div class="controls">
						<form:input id="currentMoney" path="currentMoney" />
					</div>
				</div>
				<div class="control-group">
                	<label class="control-label" for="collectedMoney">
                			收益金额:
                	</label>
                	<div class="controls">
                			<form:input path="collectedMoney" />
                	</div>
                </div>
                <div class="control-group">
                	<label class="control-label" for="frozenMoney">
                			冻结资金:
                	</label>
                	<div class="controls">
                			<form:input path="frozenMoney"/>
                	</div>
                </div>
                <div class="control-group">
                          <label class="control-label" for="drawMoney">
                               提取金额:
                          </label>
                          <div class="controls">
                                <form:input path="drawMoney"/>
                          </div>
                 </div>
				<div class="control-group">
					<label class="control-label" for="createTime">
						创建时间:
					</label>
					<div class="controls">
						<form:input id="createdate"path="createTime"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="payPassword">
						支付密码:
					</label>
					<div class="controls">
						<form:input type="password" path="payPassword" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
							<button type="button"  class="btn btn-primary" onclick="history.go(-1)">
                                                							返回
                                                </button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
              $(document).ready(function(){
                     			// alert("hello");
                       			$("#uaAddObjectForm").validate({
                       			   rules:{
                                    userId: "required",
                                    totalMoney: {
                                    required: true,
                                    number: true
                                    },
                                    currentMoney: "number",
                                    collectedMoney: "number",
                                    frozenMoney: "number",
                                    drawMoney: "number",
                                    createTime: {
                                     required: true,
                                     dateISO: true
                                    },
                                    payPassword:{
                                     required: true,
                                     minlength: 5,
                                     maxlength: 8
                                    }},
                                    messages:{
                                      userId: "请输入用户ID",
                                      totalMoney:{
                                      required: "请输入金额",
                                      number: "请输入正确的金额"
                                      },
                                      currentMoney: "请输入正确的金额",
                                      collectedMoney: "请输入正确的金额",
                                      frozenMoney: "请输入正确的金额",
                                      drawMoney: "请输入正确的金额",
                                      createTime: {
                                       required: "请输入创建时间",
                                       dateISO: "请输入正确的时间"
                                      },
                                      payPassword: {
                                       required: "请输入支付密码",
                                       minlength: jQuery.format("支付密码不能小于{0}个字符"),
                                       maxlength: jQuery.format("支付密码不能大于{0}个字符")
                                      }
                                    }});
                                     $('#createdate').datepicker({
                                           format:'yyyy-mm-dd'
                                     });
                       		});
	</script>
</body>