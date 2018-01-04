<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>充值记录列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
            						modelAttribute="accountRechargeQueryObject" action="/accountRecharge/query"
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
							<label class="control-label" for="">
								交易号:
							</label>
							<form:input path="trade_no" placeholder="" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="">
								充值人ID:
							</label>
							<form:input path="user_id" placeholder="32" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="">
								充值金额:
							</label>
							<form:input path="money" placeholder="1000" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="trade_no">交易号</form:option>
								<form:option value="user_id">充值人ID</form:option>
								<form:option value="money">充值金额</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="">
								提交时间:
							</label>
							<input type="text" id="registerDates1" name="addtimes"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${accountRechargeQueryObject.addtimes[0] }">
							到
							<input type="text" id="registerDates2" name="addtimes"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${accountRechargeQueryObject.addtimes[1] }">
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
						<div class="span6">
							<label class="control-label">
								实际到账时间:
							</label>
							<input type="text" id="registerDates1" name=""
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${accountRechargeQueryObject.actual_times[0] }">
							到
							<input type="text" id="registerDates2" name=""
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${accountRechargeQueryObject.actual_times[1] }">
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
				<p class="lead">充值记录列表</p>
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
							交易号
						</th>
						<th>
							充值人ID
						</th>
						<th>
							状态
						</th>
						<th>
							充值金额(元)
						</th>
						<th>
							手续费(元)
						</th>
						<th>
							提交时间
						</th>
						<th>
							提交IP
						</th>
						<th>
							通知时间
						</th>
					    <th>
							通知类型
						</th>
						<th>
							充值流水号
						</th>
						<th>
							实际到账金额(元)
						</th>
						<th>
							实际到账时间
						</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${accountRechargePage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.trade_no}
							</td>
							<td>
								${cur.user_id}
							</td>
							<td>
								${cur.status}
							</td>
							<td>
								${cur.money}元
							</td>
							<td>
							<c:if test="${not empty cur.fee}">${cur.fee}元</c:if>
							</td>
							<td>
								${cur.addtime}
							</td>
							<td>
								${cur.addip}
							</td>
							<td>
								${cur.notifytime}
							</td>
							<td>
								${cur.notifytype}
							</td>
							<td>
								${cur.depositid}
							</td>
							<td>
								${cur.amountln}元
							</td>
							<td>
								${cur.actual_time}
							</td>
							<td>
								${cur.remark}
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="accountRechargePage" url="/accountRecharge/query"></pager:legend>
		</div>
	</div>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>

</body>