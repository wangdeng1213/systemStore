<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>借款统计列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="borrowStatQueryObject" action="/borrowStat/query"
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

									<button class="btn" type="button" onclick="exportExcel('queryObjectForm','/borrowStat/export','/borrowStat/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('queryObjectForm','/borrowStat/exportPDF','/borrowStat/query');">
										导出PDF
									</button>
								</div>
							</div>
						</div>
					</legend>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								标的编号:
							</label>
							<form:input path="product_id" placeholder="123" />
						</div>
					<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="stat_id">----请选择----</form:option>
								<form:option value="product_id">标的编号</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6" >
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
				<p class="lead">借款统计列表</p>
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
						<th>
							实际还款总额
						</th>
						<th>
							还款期数
						</th>
						<th>
							满标日期
						</th>
						<th>
							到账日期
						</th>
						<th>
                        	借款利息
                        </th>
                        <th>
                          逾期费
                        </th>
                        <th>
                           提前还款违约金
                        </th>
                        <th>
                            借款管理费
                        </th>
                        <th>
                           待还本金
                        </th>
                        <th>
                           待还利息
                        </th>
                        <th>
                            待还逾期费用
                        </th>
                        <th>
                            待还借款管理费
                        </th>
                        <th>
                            已还本金
                        </th>
                        <th>
                            已还利息
                        </th>
                        <th>
                            已交逾期费用
                        </th>
                        <th>
                            已交提前还款违约金
                        </th>
                        <th>
                           已交借款管理费
                        </th>
                        <th>
                            总逾期天数
                         </th>
                         <th>
                            此合同为实际借款金额到账最终借款合同
                         </th>

						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${borrowStatPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.product_id }
							</td>
							<td>
								${cur.acutal_rep_total }
							</td>
							<td>
								${cur.rep_terms }
							</td>
							<td>
								${cur.finish_time }
							</td>
							<td>
								${cur.arrive_date }
							</td>
							<td>
                            	${cur.cost_money }
                            </td>
                            <td>
                            	${cur.demurrage }
                            </td>
                            <td>
                            	${cur.early_repayment_default_payment }
                            </td>
                            <td>
                            	${cur.loan_management_fee }
                            </td>
                            <td>
                            	${cur.principal }
                            </td>
                            <td>
                            	${cur.interest }
                            </td>
                            <td>
                            	${cur.late_fee }
                            </td>
                            <td>
                            	${cur.management_fee }
                            </td>
                            <td>
                            	${cur.a_principal }
                            </td>
                            <td>
                                ${cur.a_interest}
                            </td>
                            <td>
                                ${cur.a_late_fee}
                            </td>
                            <td>
                                 ${cur.t_default_payment}
                             </td>
                             <td>
                                 ${cur.a_loan_management_fee}
                              </td>
                              <td>
                                 ${cur.overdue_days}
                              </td>
                              <td>
                                 ${cur.constract_id}
                              </td>

							<td>
								<a href="<c:url value='/borrowStat/${cur.stat_id}/update'/>"><i class="icon-edit" rel="tooltip" data-placement="bottom" title="修改"></i></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/borrowStat/${cur.stat_id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据"><i class="icon-trash" rel="tooltip" data-placement="bottom" title="删除"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="borrowStatPage" url="/borrowStat/query"></pager:legend>
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