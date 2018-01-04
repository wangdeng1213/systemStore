<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>修改用户收益信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userRepaymentModel"
				method="PUT" action="/user/userrepayment/${id}/update">
			<fieldset>
				<legend>
					修改用户收益信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="id">
						收益主键:
					</label>
					<div class="controls">
						<form:input path="id" placeholder="收益主键:最少1个字符" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="beginTime">
						起始时间:
					</label>
					<div class="controls">
						<form:input path="beginTime" placeholder="起始时间" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:
					</label>
					<div class="controls">
						<form:input path="userId" placeholder="用户ID" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="productId">
						标的ID:
					</label>
					<div class="controls">
						<form:input id="productId" path="productId"/>
					</div>
				</div>
								<div class="control-group">
                					<label class="control-label" for="incomeMoney">
                						收益金额:
                					</label>
                					<div class="controls">
                						<form:input path="incomeMoney" placeholder="收益金额" />
                					</div>
                				</div>
                				<div class="control-group">
                					<label class="control-label" for="incomeTime">
                						收益时间:
                					</label>
                					<div class="controls">
                						<form:input path="incomeTime" placeholder="收益时间"/>
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

	</script>
</body>