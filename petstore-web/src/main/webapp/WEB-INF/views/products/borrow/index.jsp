<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>借款列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="borrowQueryObject" action="/borrow/query"
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

							<!--		<button class="btn" type="button" onclick="exportExcel('queryObjectForm','/borrowOrderInfo/export','/borrowOrderInfo/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('queryObjectForm','/borrowOrderInfo/exportPDF','/borrowOrderInfo/query');">
										导出PDF
									</button>-->
								</div>
							</div>
						</div>
					</legend>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								借款人编号:
							</label>
							<form:input path="user_id" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label">
								借款状态:
							</label>
							<form:select path="deal_status">
							    <form:option value="">----请选择----</form:option>
							    <form:option value="">资料填写完毕</form:option>
							    <form:option value=""></form:option>
							    <form:option value=""></form:option>
							    <form:option value=""></form:option>
							</form:select>
						</div>

					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								借款标题:
							</label>
							<form:input path="borrow_title" placeholder="如：扩大经营" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="user_id">借款人编号</form:option>
								<form:option value="borrow_term">借款期限</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								借款时间:
							</label>
							<input type="text" id="registerDates1" name="borrow_times"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${borrowQueryObject.borrow_times[0] }">
							到
							<input type="text" id="registerDates2" name="borrow_times"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${borrowQueryObject.borrow_times[1] }">
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
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">借款列表</p>
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
							借款人编号
						</th>
						<th>
							借款标题
						</th>
						<th>
							借款金额
						</th>
						<th>
							借款描述
						</th>
						<th>
							借款时间
						</th>
						<th>
                        	借款期限
                        </th>
                        <th>
                           借款状态
                        </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${borrowPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.user_id }
							</td>
							<td>
								<a href="/borrow/${cur.id}/info">${cur.borrow_title }</a>
							</td>
							<td>
								${cur.borrow_money }元
							</td>
							<td>
								${cur.borrow_description }
							</td>
							<td>
								${cur.borrow_time }
							</td>
							<td>
                            	${cur.borrow_term }个月
                            </td>
                            <td><a href="<c:url value='/borrow/${cur.id}/approval'/>">
                            	<c:choose><c:when test="${cur.deal_status == '-3'}"><span></span></c:when>
                                <c:otherwise><span><button type="button" class="btn btn-primary">风控审核</button></span></c:otherwise></c:choose></a>
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="borrowPage" url="/borrow/query"></pager:legend>
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