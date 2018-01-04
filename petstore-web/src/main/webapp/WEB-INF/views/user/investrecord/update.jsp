<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>修改投资记录信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="investRecordModel"
				method="PUT" action="/user/investrecord/${id}/update">
			<fieldset>
				<legend>
					修改投资记录信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="id">
						投资记录主键:
					</label>
					<div class="controls">
						<form:input path="id" readonly="true" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="productId">
						标的ID:
					</label>
					<div class="controls">
						<form:input path="productId"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:
					</label>
					<div class="controls">
						<form:input path="userId" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="investMoney">
						投资金额:
					</label>
					<div class="controls">
						<form:input id="investMoney" path="investMoney"/>
					</div>
				</div>
								<div class="control-group">
                					<label class="control-label" for="income">
                						投资收益:
                					</label>
                					<div class="controls">
                						<form:input path="income" />
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
                                       <form:input  id="date" path="investTime"  />
                                 </div>
                </div>
				<div class="control-group">
					<label class="control-label" for="repayTime">
						收益时间:
					</label>
					<div class="controls">
						<form:input id="date" path="repayTime" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="finish">
						是否结束:
					</label>
					<div class="controls">
                	   <form:select id="finish" path="finish">
                	       <form:option value="1" select="selected">是</form:option>
                	       <form:option value="0">否</form:option>
                	   </form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="orderId">
						订单ID:
					</label>
					<div class="controls">
						<form:input path="orderId" />
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
                     			$('#date').datepicker({
                     				format:'yyyy-mm-dd'
                     			});
                     		});
	</script>
</body>