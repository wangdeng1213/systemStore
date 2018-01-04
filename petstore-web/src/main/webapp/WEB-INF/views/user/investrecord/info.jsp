<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>投资记录信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="investRecordModel"
				method="PUT" action="/user/investrecord/${id}/update">
			<fieldset>
				<legend>
					投资记录信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="productId">
						标的ID:${investRecordModel.productId}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:${investRecordModel.userId}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="investMoney">
						投资金额:${investRecordModel.investMoney}
					</label>
				</div>
								<div class="control-group">
                					<label class="control-label" for="income">
                						投资收益:${investRecordModel.income}
                					</label>
                				</div>
                				<div class="control-group">
                					<label class="control-label" for="description">
                						备注:${investRecordModel.description}
                					</label>
                				</div>
                <div class="control-group">
                                <label class="control-label" for="investTime">
                                     投资时间:${investRecordModel.investTime}
                                </label>

                </div>
				<div class="control-group">
					<label class="control-label" for="repayTime">
						收益时间:${investRecordModel.repayTime}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="finish">
						是否结束:${investRecordModel.finish}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="orderId">
						订单ID:${investRecordModel.orderId}
					</label>
				</div>

			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
            $(document).ready(function(){
                     			$('#date').datepicker({
                     				format:'yyyy-mm-dd'
                     			});
                     		});
	</script>
</body>