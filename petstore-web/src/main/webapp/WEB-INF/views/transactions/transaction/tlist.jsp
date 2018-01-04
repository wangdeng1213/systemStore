<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>交易状态列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="transactionQueryObject" action="/transaction/query"
						method="GET">
				<fieldset>
                <legend>
					    <div class="row-fluid">

					    </div>
					    <div class="row-fluid">

					    </div>
					    <div class="row-fluid">
							<div class="span7">
							查询条件
							</div>
							<div class="span5" style="text-align: right">
								<div class="btn-group">

									<button class="btn" type="button" onclick="exportExcel('queryObjectForm','/company/export','/company/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('queryObjectForm','/company/exportPDF','/company/query');">
										导出PDF
									</button>
								</div>
							</div>
						</div>
					</legend>
				</fieldset>
			</form:form>
		</div>
	<div class="row-fluid">
		<div class="row-fluid">
			<p class="lead"><font size="5"><strong>交易状态列表</strong></font></p>
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
							标的ID
						</th>
						<th>
							用户ID
						</th>
						<th>
							投资金额(元)
						</th>
						<th>
							投资时间
						</th>
						<th>订单编号</th>
						<th>交易状态</th>
						<th>订单ID</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transactionList}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.product_id }
							</td>
							<td>
								${cur.user_id }
							</td>
							<td>
								${cur.invest_money }元
							</td>
							<td>${cur.invest_time}</td>
							<td>${cur.order_no}</td>
							<td><c:if test="${cur.deal_status == 1}">成功</c:if>
							<c:if test="${cur.deal_status == 0}">失败</c:if>
							</td>
							<td>${cur.order_id}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<button type="button" class="btn btn-primary" onclick="history.go(-1);">
         							返回
         						</button>
		</div>
	</div>	
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>
	<script type="text/javascript">
	</script>
</body>