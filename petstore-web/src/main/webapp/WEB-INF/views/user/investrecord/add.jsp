<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>新增投资记录信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form id="inAddObjectForm" cssClass="form-horizontal" modelAttribute="investRecordModel"
			method="POST" action="/user/investrecord/add">
			<fieldset>
				<legend>
					新增投资记录信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<!--<div class="control-group">
					<label class="control-label" for="id">
						投资记录主键:
					</label>
					<div class="controls">
						<form:input path="id" />
					</div>
				</div>-->
				<div class="control-group">
					<label class="control-label" for="productId">
						标的ID:
					</label>
					<div class="controls">
						<form:input path="productId" class="required"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:
					</label>
					<div class="controls">
						<form:input path="userId"  class="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="investMoney">
						投资金额:
					</label>
					<div class="controls">
						<form:input id="investMoney" path="investMoney"  class="required"/>
					</div>
				</div>
				<div class="control-group">
                	<label class="control-label" for="income">
                		投资收益:
                	</label>
                	<div class="controls">
                		<form:input path="income"   class="required"/>
                	</div>
                </div>
                				<div class="control-group">
                					<label class="control-label" for="description">
                						备注:
                					</label>
                					<div class="controls">
                						<form:input path="description"/>
                					</div>
                				</div>
                <div class="control-group">
                                <label class="control-label" for="investTime">
                                     投资时间:
                                </label>
                                <div class="controls">
                                       <form:input id="datebtn1" path="investTime"
                                           data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
                                           placeholder="投资时间:2012-12-21"  class="required"/>
                                 </div>
                </div>
				<div class="control-group">
					<label class="control-label" for="repayTime">
						收益时间:
					</label>
					<div class="controls">
						<form:input id="datebtn2" path="repayTime"  data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
                         placeholder="收益时间:2012-12-21"  class="required"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="finish">
						是否结束:
					</label>
					<div class="controls">
						<form:input path="finish"  class="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="orderId">
						订单ID:
					</label>
					<div class="controls">
						<form:input path="orderId"  class="required"/>
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
           			$('#datebtn1').datepicker({
           				format:'yyyy-mm-dd'
           			});
           			$('#datebtn2').datepicker({
                        format:'yyyy-mm-dd'
                    });
                    $("#inAddObjectForm").validate();
           		});
	</script>
</body>