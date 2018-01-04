<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>计划还款列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="boRepaymentPlanQueryObject" action="/boRepaymentPlan/query"
						method="GET">
				<fieldset>
					<legend>
						<div class="row-fluid">
							<div class="span7">
							查询条件
							</div>
							<div class="span5" style="text-align: right">
								<div class="btn-group">
									<button class="btn btn-primary" type="submit">
										查询
									</button>
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
							<label class="control-label">
								标的名称:
							</label>
							<form:input path="product_name" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="product_id">标的编号</form:option>
								<form:option value="user_id">用户编号</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								借款人名称:
							</label>
							<form:input path="name" />
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
					   <div class="span6" style="text-align: right">
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
				<p class="lead">计划还款列表</p>
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
						<th>标的名称</th>
						<th>
							借款人编号
						</th>
						<th>借款人名称</th>
						<th>
							借款期限
						</th>
						<th>
							开始还款时间
						</th>
						<th>
							借款总额(元)
						</th>
						<th>月综合费率%</th>
						<th>
                        	应还总额(元)
                        </th>
						<th>每期应还款额(元)</th>
						<th>结束时间</th>
						<th>还款类型</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boRepaymentPlanPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
							${cur.product_id }
							</td>
							<td><a href="/boRepaymentPlan/${cur.product_id }/info">${cur.product_name}</a></td>
							<td>
								${cur.user_id }
							</td>
							<td>${cur.name}</td>
							<td> ${cur.loan_term}月
							</td>
							<td>
								${cur.repayment_startperiod }
							</td>
							<td>
							   ${cur.total_money }元
							</td>
							<td>${cur.month_rate}</td>
							<td>
								${cur.rep_total_money }元
							</td>
							<td>
								${cur.terminal_money }元
							</td>
							<td>
                            	${cur.finish_time }
                            </td>
                            <td>
                            	${cur.repayment_type }
                            </td>
							<td>
							<!--	<a href="<c:url value='/boRepaymentPlan/${cur.id}/update'/>">修改</a>-->
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/boRepaymentPlan/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据"><i class="icon-trash" rel="tooltip" data-placement="bottom" title="删除"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="boRepaymentPlanPage" url="/boRepaymentPlan/query"></pager:legend>
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