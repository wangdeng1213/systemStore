<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>新增用户特权信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form  id="addObjectForm" cssClass="form-horizontal" modelAttribute="userPrivilegeModel"
			method="POST" action="/user/userprivilege/add">
			<fieldset>
				<legend>
					新增用户特权信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
			 <!-- <div class="control-group">
					<label class="control-label" for="id">
						特权主键:
					</label>
					<div class="controls">
						<form:input path="id" />
					</div>
				</div>-->
				<div class="control-group">
					<label class="control-label" for="levelNo">
						等级:
					</label>
					<div class="controls">
						<form:input path="levelNo" class="required digits"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="credit">
						信誉:
					</label>
					<div class="controls">
						<form:input path="credit" class="required"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="activity">
						活动:
					</label>
					<div class="controls">
						<form:input id="activity" path="activity" class="required"/>
					</div>
				</div>
								<div class="control-group">
                					<label class="control-label" for="attribute1">
                						预留字段1:
                					</label>
                					<div class="controls">
                						<form:input path="attribute1" placeholder="预留字段1" />
                					</div>
                				</div>
                				<div class="control-group">
                					<label class="control-label" for="attribute2">
                						预留字段2:
                					</label>
                					<div class="controls">
                						<form:input path="attribute2" placeholder="预留字段2"/>
                					</div>
                				</div>
                <div class="control-group">
                          <label class="control-label" for="description">
                                 备注:
                          </label>
                          <div class="controls">
                               <form:input path="description" placeholder="备注" />
                          </div>
                </div>
				<div class="control-group">
					<label class="control-label" for="userId">
						用户ID:
					</label>
					<div class="controls">
						<form:input path="userId" placeholder="用户ID" class="required" />
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
                 $().ready(function(){
                        $("#addObjectForm").validate();

                   });
	</script>
</body>