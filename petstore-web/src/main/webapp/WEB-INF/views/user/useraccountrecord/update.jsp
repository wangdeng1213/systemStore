<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>修改个人银行流水记录信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userAccountRecordModel"
				method="PUT" action="/user/useraccountrecord/${id}/update">
			<fieldset>
				<legend>
					修改个人银行流水记录信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
					<label class="control-label" for="id">
						流水记录主键:
					</label>
					<div class="controls">
						<form:input path="id" placeholder="流水记录主键:最少1个字符" />
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
					<label class="control-label" for="accountId">
						个人账户ID:
					</label>
					<div class="controls">
						<form:input path="accountId" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="rechanrgeMoney">
						充值金额:
					</label>
					<div class="controls">
						<form:input id="activity" path="rechanrgeMoney"/>
					</div>
				</div>
								<div class="control-group">
                					<label class="control-label" for="rechanrgeType">
                						取款金额:
                					</label>
                					<div class="controls">
                						<form:input path="rechanrgeType" placeholder="预留字段1" />
                					</div>
                				</div>
                				<div class="control-group">
                					<label class="control-label" for="rechanrgeTime">
                						充值日期:
                					</label>
                					<div class="controls">
                						<form:input path="rechanrgeTime" placeholder="预留字段2"/>
                					</div>
                				</div>
                <div class="control-group">
                                                					<label class="control-label" for="rechanrgeReceiveTime">
                                                						取款日期:
                                                					</label>
                                                					<div class="controls">
                                                						<form:input path="rechanrgeReceiveTime" placeholder="备注" />
                                                					</div>
                                                </div>
				<div class="control-group">
					<label class="control-label" for="description">
						备注:
					</label>
					<div class="controls">
						<form:input path="description"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="updateTime">
						最后修改时间:
					</label>
					<div class="controls">
						<form:input path="updateTime"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="updateBy">
						最后修改人:
					</label>
					<div class="controls">
						<form:input path="updateBy"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="bankName">
						银行名称:
					</label>
					<div class="controls">
						<form:input path="bankName"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="bankNo">
						银行账号:
					</label>
					<div class="controls">
						<form:input path="bankNo"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="bankAddress">
						银行地址:
					</label>
					<div class="controls">
						<form:input path="bankAddress" />
					</div>
				</div>
				<div class="control-group">
                	<label class="control-label" for="openBankName">
                		 开户行名称:
                	</label>
                    <div class="controls">
                		<form:input path="openBankName" />
                	</div>
                </div>
				<div class="control-group">
					<label class="control-label" for="bankTel">
						银行电话:
					</label>
					<div class="controls">
						<form:input path="bankTel"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="createTime">
						创建时间:
					</label>
					<div class="controls">
						<form:input path="createTime" />
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