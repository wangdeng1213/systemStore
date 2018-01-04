
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>新增债权转让</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
        <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
        <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="transferModel"
			method="POST" action="/transfer/add">
			<input type="hidden" name="productId" value="${pid}"/>
			<fieldset>
				<legend>
					新增债权转让信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label" >
						代理商:
					</label>
					<div class="controls">
					<select id="agent" name="agent" >
						<c:forEach items="${allAgentModel}" var="cur">
							<option value="${cur.id }">${cur.name }</option>
						</c:forEach>
					</select>
				      </div>
			    </div>

				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							下一步
						</button>
						<button type="button" class="btn btn-primary" onclick="history.go(-1)">
                        							返回
                        </button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>


        <script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" ></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-zh-CN.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){

		});
	</script>
</body>






























