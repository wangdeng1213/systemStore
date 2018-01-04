<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>个人银行流水记录信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userAccountRecordModel"
				method="PUT" action="/user/useraccountrecord/${id}/update">
			<fieldset>
				<legend>
					个人银行流水记录信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="id">
						流水记录主键:${userAccountRecordModel.id}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:${userAccountRecordModel.userId}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="accountId">
						个人账户ID:${userAccountRecordModel.accountId}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="rechanrgeMoney">
						充值金额:${userAccountRecordModel.rechanrgeMoney}
					</label>

				</div>
				<div class="control-group">
                	<label class="control-label" for="rechanrgeType">
                			取款金额:${userAccountRecordModel.rechanrgeType}
                	</label>

                </div>
                <div class="control-group">
                	<label class="control-label" for="rechanrgeTime">
                			充值日期:${userAccountRecordModel.rechanrgeTime}
                	</label>
                </div>
                <div class="control-group">
                    <label class="control-label" for="rechanrgeReceiveTime">
                              取款日期:${userAccountRecordModel.rechanrgeReceiveTime}
                     </label>
                </div>
				<div class="control-group">
					<label class="control-label" for="description">
						备注:${userAccountRecordModel.description}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="updateTime">
						最后修改时间:${userAccountRecordModel.updateTime}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="updateBy">
						最后修改人:${userAccountRecordModel.updateBy}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="bankName">
						银行名称:${userAccountRecordModel.bankName}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="bankNo">
						银行账号:${userAccountRecordModel.bankNo}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="bankAddress">
						银行地址:${userAccountRecordModel.bankAddress}
					</label>

				</div>
	            <div class="control-group">
					<label class="control-label" for="openBankName">
						开户行名称:${userAccountRecordModel.openBankName}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="bankTel">
						银行电话:${userAccountRecordModel.bankTel}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="createTime">
						创建时间:${userAccountRecordModel.createTime}
					</label>
                </div>
          	</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">

	</script>
</body>