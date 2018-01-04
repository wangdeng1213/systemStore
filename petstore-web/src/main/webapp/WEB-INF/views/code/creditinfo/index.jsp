<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>信用档案列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="creditInfoQueryObject" action="/creditInfo/query"
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
                          <div class="span6" >
                     			<label class="control-label" for="credit_rating">
                     					信用等级:
                     			</label>
                     			<form:input path="credit_rating" />
                     	 </div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="">----请选择----</form:option>
								<form:option value="id">信用档案ID</form:option>
								<form:option value="credit_rating">信用等级</form:option>
							</form:select>
						</div>
					</div>
				    <div class="row-fluid">

					     <div class="span6"  style="text-align: right">
								<button class="btn btn-primary" type="submit">
                            										查询
                            	</button>
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
				</fieldset>
			</form:form>
		</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">信用档案列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('/creditInfo/add');">新增</a>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<table class="table table-striped" >
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							信用等级
						</th>
						<th>
							信用总分
						</th>
						<th>
							可用额度
						</th>
						<th>
							申请借款次数
						</th>
						<th>
							信用额度
						</th>

						<th>逾期金额
						</th>
						<th>成功借款次数</th>
						<th>借款总额</th>
						<th>逾期次数</th>
						<th>还清笔数</th>
						<th>待还本息</th>
						<th>严重逾期次数</th>
						<th>正常还款次数</th>
						<th>借款人ID</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="tab">
					<c:forEach items="${creditInfoPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
                            <td>${cur.credit_rating           }</td>
                            <td>${cur.credit_score  }</td>
                            <td>${cur.credit_available  }
                            </td>
                            <td>${cur.borrow_app_times  }</td>
                            <td>${cur.credit_lines  }</td>
                            <td>${cur.overdue_amount  }</td>
                            <td>${cur.successful_loan_times  }</td>
                            <td>${cur.total_loan  }</td>
                            <td>${cur.overdue_times  }</td>
                            <td>${cur.pay_off  }</td>
                            <td>${cur.to_pay  }</td>
                            <td>${cur.serious_overdue  }</td>
                            <td>${cur.normal_times  }</td>
                            <td>${cur.user_id  }</td>
							<td>
								<a href="<c:url value='/creditInfo/${cur.id}/update'/>"><span class="up">修改</span></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/creditInfo/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="creditInfoPage" url="/creditInfo/query"></pager:legend>
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
			$("[rel=tooltip]").tooltip();
			$("a[id^=trash]").popover({html : true}).click(function(e) {
		        e.preventDefault();
		    });

		});
	</script>
</body>