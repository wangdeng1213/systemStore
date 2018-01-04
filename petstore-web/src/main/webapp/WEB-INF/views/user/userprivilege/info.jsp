<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>用户特权信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userPrivilegeModel"
				method="PUT" action="/user/userprivilege/${id}/update">
			<fieldset>
				<legend>
					用户特权信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<!--<div class="control-group">
					<label class="control-label" for="id">
						特权主键: ${userPrivilegeModel.id}
					</label>
					<div class="controls">
						<form:input path="id" placeholder="特权主键:最少1个字符" />
					</div>
				</div>-->
				<div class="control-group">
					<label class="control-label" for="levelNo">
						等级: ${userPrivilegeModel.levelNo}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="credit">
						信誉: ${userPrivilegeModel.credit}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="activity">
						活动: ${userPrivilegeModel.activity}
					</label>

				</div>

                <div class="control-group">
                        <label class="control-label" for="description">
                            备注: ${userPrivilegeModel.description}
                        </label>

                </div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID: ${userPrivilegeModel.userId}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户名: ${userInfoModel.userName}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						真实姓名: ${userInfoModel.name}
					</label>
				</div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">

	</script>
</body>