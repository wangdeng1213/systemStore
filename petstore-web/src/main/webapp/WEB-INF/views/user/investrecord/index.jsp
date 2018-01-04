<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>投资记录列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="investRecordQueryObject" action="/user/investrecord/query"
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
							<label class="control-label">
								标的名称:
							</label>
							<form:input path="productName" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="userId">
								用户ID:
							</label>
							<form:input path="userId" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="productId">标的ID</form:option>
								<form:option value="userId">用户ID</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								投资金额:
							</label>
							<form:input path="investMoney" />
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
							<label class="control-label" for="registerDates1">
								投资时间:
							</label>
							<input type="text" id="investTimes1" name="investTimes"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${investRecordQueryObject.investTimes[0] }">
							到
							<input type="text" id="investTimes2" name="investTimes"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${investRecordQueryObject.investTimes[1] }">
						</div>
					    <div class="span6">
					  	    <button class="btn btn-primary" type="submit">查询</button>
					  	</div>
					</div>
				</fieldset>
			</form:form>
		</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead"><font size="5"><strong>投资记录列表</strong></font></p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
				<!--	<a href="#" class="btn btn-primary" onclick="gotoAdd('/user/investrecord/add');">新增</a>
				<a href="#" class="btn" onclick="gotoImportExcel('/company/import');">导入excel</a>
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
                             标的名称
                          </th>
						<th>
						    投资人ID
						</th>
						<th>
							投资金额
						</th>
						<th>
							投资收益
						</th>

						<th>
                            投资时间
                        </th>

                         <th>是否结束</th>


                         <th>
                            总期数
                         </th>
                         <th>已收收益</th>
                         <th>待收收益</th>
                         <th>当前期数</th>
                         <th>下一期数</th>
                         <th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${investRecordPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								<a href="/user/investrecord/${cur.id}/info" target="_blank">${cur.productId }</a>
							</td>
                            <td>
                                  ${cur.productName }
                             </td>
							<td>
								${cur.userId }
							</td>
							<td>
								${cur.investMoney }元
							</td>
							<td>
								${cur.income }元
							</td>

                            <td>
                              <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cur.investTime }"></fmt:formatDate>
                             </td>

                             <td>
								<c:choose>
									<c:when test="${cur.finish == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose>
                             </td>


                             <td>${cur.term }</td>
                             <td>${cur.currentIncome }</td>
                             <td>${cur.dueIn}</td>
                             <td>${cur.currentTerm }</td>
                             <td>${cur.nextTerm }</td>
							<td>
								<a href="<c:url value='/user/investrecord/${cur.id}/update'/>">修改</a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/user/investrecord/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="investRecordPage" url="/user/investrecord/query"></pager:legend>
		</div>
	</div>	
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap/bootstrap-popover.js"></script>
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
		    $('#investTimes1').datepicker({
				format:'yyyy-mm-dd'
			});
			$('#investTimes2').datepicker({
				format:'yyyy-mm-dd'
			});
		});
	</script>
</body>