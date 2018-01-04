<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>个人账户信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userAccountModel">
			<fieldset>
				<legend>
					个人账户信息
				</legend>
				<div class="control-group">
					<label class="control-label" for="id">
						账户主键: ${userAccountModel.id}
					</label>
             	</div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:  ${userAccountModel.userId}
					</label>
             	</div>
				<div class="control-group">
					<label class="control-label" for="totalMoney">
						充值总额: ${userAccountModel.totalMoney}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="currentMoney">
						余额: ${userAccountModel.currentMoney}
					</label>

				</div>
				<div class="control-group">
                		<label class="control-label" for="collectedMoney">
                		收益金额: ${userAccountModel.collectedMoney}
                		</label>

                </div>
                <div class="control-group">
                		<label class="control-label" for="frozenMoney">
                			冻结资金: ${userAccountModel.frozenMoney}
                		</label>
                </div>
                <div class="control-group">
                    <label class="control-label" for="drawMoney">
                            提取金额: ${userAccountModel.drawMoney}
                    </label>

                </div>
				<div class="control-group">
					<label class="control-label" for="createTime">
						创建时间: ${userAccountModel.createTime}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="payPassword">
						支付密码: ${userAccountModel.payPassword}
					</label>

				</div>

			</fieldset>
		</form:form>
	</div>
        <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
    	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
    	<script src="/static/js/bootstrap/2.3.2/bootstrap/bootstrap-popover.js"></script>
    	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
    	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
    	<script src="/static/js/p2p/1.0.0/document.min.js"></script>
    	<script type="text/javascript">

    	</script>
</body>