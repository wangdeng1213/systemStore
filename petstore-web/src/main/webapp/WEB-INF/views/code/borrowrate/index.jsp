<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>借款利率列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="borrowRateQueryObject" action="/borrowRate/query"
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
								<form:option value="id">借款费率ID</form:option>
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
				<p class="lead">借款费率列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('/borrowRate/add');">新增</a>
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
							借款利率ID
						</th>
						<th>
							信用等级
						</th>
						<th>
							信用分数区间
						</th>
						<th>
							月综合费率
						</th>
						<th>
							期初服务费率
						</th>

						<th>状态
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="tab">
					<c:forEach items="${borrowRatePage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
                            <td>${cur.id           }</td>
                            <td>${cur.credit_rating  }</td>
                            <td>${cur.credit_score_range  }
                            </td>
                            <td>${cur.month_rate  }</td>
                            <td>${cur.first_ser_rate  }</td>
                            <td><c:if test="${cur.act_status==1}">已激活</c:if>
                                <c:if test="${cur.act_status==0}">未激活</c:if>
                            </td>
							<td>
								<a href="<c:url value='/borrowRate/${cur.id}/update'/>"><span class="up">修改</span></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/borrowRate/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="borrowRatePage" url="/borrowRate/query"></pager:legend>
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