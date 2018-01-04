<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>交易列表</title>
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
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="product_id">
								标 的 ID:
							</label>
							<form:input path="product_id"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="user_id">
								用 户 ID:
							</label>
							<form:input path="user_id" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="transaction_id">----请选择----</form:option>
								<form:option value="product_id">标的ID</form:option>
								<form:option value="user_id">用户ID</form:option>
								<form:option value="invest_money">投资金额</form:option>
							</form:select>

						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="invest_money">
								投资金额:
							</label>
							<form:input path="invest_money" />
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
						<div class="span6" style="text-align: right"><button class="btn btn-primary" type="submit">查询</button></div>
					</div>
				</fieldset>
			</form:form>
		</div>
	<div class="row-fluid">
		<div class="row-fluid">
			<p class="lead"><font size="5"><strong>交易列表</strong></font></p>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
				<!--	<a href="#" class="btn" onclick="gotoImportExcel('/company/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/company/gotoPreviewExcel');">预览excel</a>-->
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
							备注
						</th>
						<th>
							投资时间
						</th>
						<th>银行名称</th>
						<th>银行账号</th>
						<th>到款时间</th>
						<th>到款金额(元)</th>
						<th>订单编号</th>
						<th>合同编号</th>
						<th>交易状态</th>
						<th>订单ID</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transactionPage.records}" var="cur" varStatus="s">
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
							<td>${cur.description}</td>
							<td>${cur.invest_time}</td>
							<td>${cur.bank_name}</td><td>${cur.bank_no}</td><td>${cur.bank_time}</td>
							<td>${cur.bank_money}</td>
							<td>${cur.order_no}</td>
							<td>${cur.contract_no}</td>
							<td><c:if test="${cur.deal_status == 1}">成功</c:if>
							<c:if test="${cur.deal_status == 0}">失败</c:if>
							</td>
							<td>${cur.order_id}</td>
							<td>
								<!--<a href="<c:url value='/transaction/${cur.transaction_id}/update'/>">修改</a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/transaction/${cur.transaction_id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>-->
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="transactionPage" url="/transaction/query"></pager:legend>
		</div>
	</div>	
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>
	<script type="text/javascript">
		function hideTrash(id){
			$(id).popover('hide');
		}
		$(document).ready(function(){
			$("#email").autoMail({
					emails:['qq.com','163.com','126.com','sina.com','sohu.com','yahoo.cn','gmail.com','hotmail.com','live.cn']
				});
			$('#registerDates1').datepicker({
				format:'yyyy-mm-dd'
			});
			$('#registerDates2').datepicker({
				format:'yyyy-mm-dd'
			});
			$("[rel=tooltip]").tooltip();
			$("a[id^=trash]").popover({html : true}).click(function(e) {
		        e.preventDefault();
		    });
		});
	</script>
</body>