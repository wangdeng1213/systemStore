<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>还款计划详细信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">

			<fieldset>
				<legend>
					还款计划详细信息
				</legend>
			</fieldset>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">还款计划详细信息</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
				</div>
			</div>
		</div>
			<div class="row-fluid">
    			<table class="table table-striped">
    				<thead>
    					<tr>
    						<th>
    							#
    						</th>
    						<th>
    							标的编号
    						</th>
    						<th>应还总额(元)</th>
    						<th>
    							应还本金(元)
    						</th>
    						<th>应还利息(元)</th>
    						<th>
    							应还期数
    						</th>
    						<th>
    							应还款时间
    						</th>

    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach items="${boRepaymentDetailModel}" var="cur" varStatus="s">
    						<tr>
    							<td>
    								${s.index+1 }
    							</td>
    							<td>
    							    ${cur.product_id }
    							</td>

    							<td>
    								${cur.repayment_money }
    							</td>
    							<td>${cur.principal_fee}</td>
    							<td> ${cur.interest_fee}
    							</td>
    							<td>${cur.term}</td>
    							<td>
    								${cur.repayment_time }
    							</td>
    						</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    		</div>
 				<div class="control-group">
 					<label class="control-label"></label>
 					<div class="controls">
 						<button type="button" class="btn btn-primary" onclick="history.go(-1);">
 							返回
 						</button>
 					</div>
 				</div>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){

		});

	</script>
</body>