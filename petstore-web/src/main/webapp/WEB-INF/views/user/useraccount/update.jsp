<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>修改个人账户信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userAccountModel"
				method="PUT" action="/user/useraccount/${id}/update">
			<fieldset>
				<legend>
					修改个人账户信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
				<div class="control-group">
            					<label class="control-label" for="id">
            						账户主键:
            					</label>
            					<div class="controls">
            						<form:input path="id" placeholder="账户主键:最少1个字符" />
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
            					<label class="control-label" for="totalMoney">
            						充值总额:
            					</label>
            					<div class="controls">
            						<form:input path="totalMoney" />
            					</div>
            				</div>
            				<div class="control-group">
            					<label class="control-label" for="currentMoney">
            						余额:
            					</label>
            					<div class="controls">
            						<form:input id="currentMoney" path="currentMoney"/>
            					</div>
            				</div>
            				<div class="control-group">
                            	<label class="control-label" for="collectedMoney">
                            		收益金额:
                            	</label>
                            	<div class="controls">
                            		<form:input path="collectedMoney"  />
                            	</div>
                            </div>
                            <div class="control-group">
                            	<label class="control-label" for="frozenMoney">
                            		冻结资金:
                            	</label>
                            	<div class="controls">
                            		<form:input path="frozenMoney"/>
                            	</div>
                            </div>
                            <div class="control-group">
                                 <label class="control-label" for="drawMoney">
                                      提取金额:
                                 </label>
                                 <div class="controls">
                                      <form:input path="drawMoney"/>
                                 </div>
                            </div>
            				<div class="control-group">
            					<label class="control-label" for="createTime">
            						创建时间:
            					</label>
            					<div class="controls">
            						<form:input id="createdate" path="createTime"/>
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
    	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
    	<script src="/static/js/bootstrap/2.3.2/bootstrap/bootstrap-popover.js"></script>
    	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
    	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
    	<script src="/static/js/p2p/1.0.0/document.min.js"></script>
    	<script type="text/javascript">

    	</script>
</body>

