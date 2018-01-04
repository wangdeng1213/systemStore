<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>借款订单列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="borrowOrderInfoQueryObject" action="/borrowOrderInfo/query"
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

									<button class="btn" type="button" onclick="exportExcel('queryObjectForm','/borrowOrderInfo/export','/borrowOrderInfo/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('queryObjectForm','/borrowOrderInfo/exportPDF','/borrowOrderInfo/query');">
										导出PDF
									</button>
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

					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								借款金额:
							</label>
							<form:input path="borrow_money" placeholder="1000" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="borrow_order_id">----请选择----</form:option>
								<form:option value="user_id">借款人编号</form:option>
								<form:option value="borrow_money">借款金额</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="">
								借款时间:
							</label>
							<input type="text" id="registerDates1" name="borrow_times"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${borrowOrderInfoQueryObject.borrow_times[0] }">
							到
							<input type="text" id="registerDates2" name="borrow_times"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${borrowOrderInfoQueryObject.borrow_times[1] }">
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
				<p class="lead">借款订单列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
				<!--	<a href="#" class="btn btn-primary" onclick="gotoAdd('/borrowOrderInfo/add');">新增</a>
					<a href="#" class="btn" onclick="gotoImportExcel('/borrowOrderInfo/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/borrowOrderInfo/gotoPreviewExcel');">预览excel</a>-->
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
                           剩余还款额
                        </th>
                        <th>
                           借款状态
                        </th>
                        <th>
                            订单类型
                        </th>
                        <th>
                            客户端版本号
                        </th>
                        <th>
                           借款订单状态
                        </th>
                        <th>
                            IP地址
                        </th>
                        <th>
                            属性
                        </th>
                        <th>
                            真实姓名
                        </th>
                        <th>
                            收入金额
                        </th>
                        <th>
                            身份证号
                        </th>
                        <th>
                            借款期限ID
                        </th>

						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${borrowOrderInfoPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.user_id }
							</td>
							<td>
								${cur.borrow_title }
							</td>
							<td>
								${cur.borrow_money }
							</td>
							<td>
								${cur.borrow_description }
							</td>
							<td>
								${cur.borrow_time }
							</td>
							<td>
                            	${cur.borrow_term }
                            </td>
                            <td>
                            	${cur.surplus }
                            </td>
                            <td>
                            	${cur.success }
                            </td>
                            <td>
                            	${cur.order_type }
                            </td>
                            <td>
                            	${cur.client_version }
                            </td>
                            <td>
                            	<c:if test="${cur.loanorder_status=='0'}">已废弃</c:if>
                            	<c:if test="${cur.loanorder_status=='1'}">正在审核</c:if>
                            	<c:if test="${cur.loanorder_status=='2'}">筹款中</c:if>
                            	<c:if test="${cur.loanorder_status=='3'}">还款中</c:if>
                            	<c:if test="${cur.loanorder_status=='4'}">还款完成</c:if>
                            </td>
                            <td>
                            	${cur.ip }
                            </td>
                            <td>
                            	${cur.attribute }
                            </td>
                            <td>
                            	${cur.realname }
                            </td>
                            <td>
                                ${cur.income_money}
                            </td>
                            <td>
                                ${cur.id_card}
                            </td>
                            <td>
                                 ${cur.period_id}
                             </td>

							<td>
								<a href="<c:url value='/borrowOrderInfo/${cur.borrow_order_id}/update'/>"><i class="icon-edit" rel="tooltip" data-placement="bottom" title="修改"></i></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/borrowOrderInfo/${cur.borrow_order_id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据"><i class="icon-trash" rel="tooltip" data-placement="bottom" title="删除"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="borrowTranPage" url="/borrowTran/query"></pager:legend>
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