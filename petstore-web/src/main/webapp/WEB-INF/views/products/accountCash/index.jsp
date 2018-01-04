<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>提现记录列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
            						modelAttribute="accountCashQueryObject" action="/accountCash/query"
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

									<button class="btn" type="button" onclick="exportExcel('queryObjectForm','/actualRepayment/export','/actualRepayment/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('queryObjectForm','/actualRepayment/exportPDF','/actualRepayment/query');">
										导出PDF
									</button>
								</div>
							</div>
						</div>
					</legend>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								充值人ID:
							</label>
							<form:input path="user_id" placeholder="32" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								提现金额:
							</label>
							<form:input path="money" placeholder="1000" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="user_id">充值人ID</form:option>
								<form:option value="money">提现金额</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								状态:
							</label>
							<form:select path="status">
							    <form:option value="">----请选择----</form:option>
							    <form:option value="0">初始</form:option>
							    <form:option value="1">提现成功</form:option>
							    <form:option value="2">提现失败</form:option>
							</form:select>
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].orderType">
								排序类型:
							</label>
							<form:select path="orders[0].orderType">
								<form:option value="">----请选择----</form:option>
								<form:option value="asc">正序</form:option>
								<form:option value="desc">倒序</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
					   <div class="span6"  style="text-align: right">
					   			<button class="btn btn-primary" type="submit">
                                          查询
                                </button>
					   </div>
					</div>
				</fieldset>
            </form:form>
		</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">提现记录列表</p>
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
							充值人ID
						</th>
						<th>
							状态
						</th>
						<th>
							提现金额
						</th>
						<th>提现总额</th>
						<th>
							手续费
						</th>
						<th>所属银行</th>
						<th>支行</th>
						<th>
							提交时间
						</th>
						<th>
							提交IP
						</th>
						<th>
							通知时间
						</th>
						<th>银行卡号</th>
						<th>外部订单号</th>
						<th>
							提现流水号
						</th>
						<th>
							实际到账金额
						</th>
						<th>
							实际到账时间
						</th>
						<th>支付类型</th>
						<th>支付类型描述</th>
						<th>结果标识</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${accountCashPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.user_id}
							</td>
							<td>
								${cur.status}
							</td>
							<td>
								${cur.money}
							</td>
							<td>
								${cur.total}
							</td>

							<td>
								${cur.fee}
							</td>
							<td>${cur.bank}</td>
							<td>${cur.branch}</td>
							<td>
								${cur.addtime}
							</td>
							<td>
                            	${cur.addip}
                            </td>
							<td>
								${cur.notifytime}
							</td>
							<td>${cur.bankcardno}</td>
							<td>${cur.outbizno}</td>
                            <td>${cur.payno}</td>
							<td>
								${cur.amountln}
							</td>
							<td>
								${cur.actual_time}
							</td>
							<td>${cur.paytype}</td>
							<td>${cur.paytypemessage}</td>
							<td>${cur.resultcode}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="accountCashPage" url="/accountCash/query"></pager:legend>
		</div>
	</div>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>

</body>