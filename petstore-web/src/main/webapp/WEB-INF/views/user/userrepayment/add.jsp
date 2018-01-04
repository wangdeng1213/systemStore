<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>新增用户收益信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form id="addReObjectForm" cssClass="form-horizontal" modelAttribute="userRepaymentModel"
			method="POST" action="/user/userrepayment/add">
			<fieldset>
				<legend>
					新增用户收益信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<!--<div class="control-group">
					<label class="control-label" for="id">
						收益主键:
					</label>
					<div class="controls">
						<form:input path="id"  />
					</div>
				</div>-->
				<div class="control-group">
					<label class="control-label" for="beginTime">
						起始时间:
					</label>
					<div class="controls">
						<form:input id="date1" path="beginTime" class="required dateISO" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:
					</label>
					<div class="controls">
						<form:input path="userId" placeholder="用户ID"  class="required"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="productId">
						标的ID:
					</label>
					<div class="controls">
						<form:input id="productId" path="productId" class="required"/>
					</div>
				</div>
								<div class="control-group">
                					<label class="control-label" for="incomeMoney">
                						收益金额:
                					</label>
                					<div class="controls">
                						<form:input path="incomeMoney" class="required"/>
                					</div>
                				</div>
                				<div class="control-group">
                					<label class="control-label" for="incomeTime">
                						收益时间:
                					</label>
                					<div class="controls">
                						<form:input  id="date2" path="incomeTime" class="required dateISO" />
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
                                  $("#addReObjectForm").validate();
                                  $('#date1').datepicker({
                                     	format:'yyyy-mm-dd'
                                    });
                                  $('#date2').datepicker({
                                     	format:'yyyy-mm-dd'
                                     });

                    });



	</script>
</body>