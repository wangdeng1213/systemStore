<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>用户收益信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userRepaymentModel"
				method="PUT" action="/user/userrepayment/${id}/update">
			<fieldset>
				<legend>
					用户收益信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="beginTime">
						起始时间:${userRepaymentModel.beginTime}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:${userRepaymentModel.userId}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户名:${userInfoModel.userName}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="name">
						真实姓名:${userInfoModel.name}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="productId">
						标的ID:${userRepaymentModel.productId}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="productId">
						标的名称:${productModel.productName}
					</label>
				</div>
				<div class="control-group">
                	<label class="control-label" for="incomeMoney">
                		收益金额:${userRepaymentModel.incomeMoney}
                	</label>
                </div>
                <div class="control-group">
                	<label class="control-label" for="incomeTime">
                		收益时间:${userRepaymentModel.incomeTime}
                	</label>
                </div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">

	</script>
</body>