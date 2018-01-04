<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>延時页面</title>
       <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
        <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
        <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
        <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
        <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="/static/css/pager/pager.css" />
        <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
        <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
    		<div class="row-fluid">

              <fieldset>
              <div class="control-group">&nbsp;</div><div class="control-group">&nbsp;</div>

				<form:form id="queryObjectForm" cssClass="form-inline"
                    						modelAttribute="transferModel" action="/product/${transferModel.productId}/Delay"
                    						method="POST">
                    	  <input type="hidden" name="id" value="${transferModel.productId}">
     		               <div class="control-group">
     		                  <div class="span4">
             					<label class="control-label">
             						延时结束时间:
             					</label>
             						<form:input path="endTime"  id="delayTime"/>
             				 </div>
            			</div>
 				<div class="control-group">
 					<label class="control-label"></label>
 					<div class="controls">
 						<button type="submit" class="btn btn-primary">
 							确认延时
 						</button>
 						<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
 					</div>
 				</div>
 			  </fieldset>
             </form:form>
          <script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
          <script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
          <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
          <script src="/static/js/bootstrap/2.3.2/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" ></script>
          <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-zh-CN.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		       $('#delayTime').datetimepicker({
                timeFormat: "HH:mm:00",
                dateFormat: "yy-mm-dd",
                minDate: 0
                });
		});
	</script>

</body>