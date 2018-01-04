<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>银行列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="bankQueryObject" action="/bank/query"
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
                     			<label class="control-label" for="bank_id">
                     					银行ID:
                     			</label>
                     			<form:input path="bank_id" />
                     	 </div>
						<div class="span6"  style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="bank_id">----请选择----</form:option>
								<form:option value="bank_id">银行ID</form:option>
								<form:option value="bank_name">银行名称</form:option>
							</form:select>
						</div>
					</div>
				    <div class="row-fluid">
                         <div class="span6" >
                     			<label class="control-label" for="bank_name">
                     					银行名称:
                     			</label>
                     			<form:input path="bank_name" />
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
					     <div class="span6" style="text-align: right">
								<button class="btn btn-primary" type="submit">
                            										查询
                            	</button>
					    </div>
				</div>
				</fieldset>
			</form:form>
		</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">银行列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('/bank/add');">新增</a>
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
							银行ID
						</th>
						<th>
							银行名称
						</th>
						<th>
							银行地址
						</th>
						<th>
							银行编号
						</th>
						<th>
							银行电话
						</th>
						<th>
							银行图片
						</th>
						<th>开户行
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="tab">
					<c:forEach items="${bankPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
                            <td>${cur.bank_id           }</td>
                            <td>${cur.bank_name  }</td>
                            <td>${cur.bank_address  }</td>
                            <td>${cur.bank_no  }</td>
                            <td>${cur.bank_phone  }</td>
                            <td><img src="/bank/${cur.picId}/show" width="100px" height="50px"></img>
                            </td>
                            <td>${cur.bank_branch  }</td>
							<td>
								<a href="<c:url value='/bank/${cur.bank_id}/update'/>"><span class="up">修改</span></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/bank/${cur.bank_id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="bankPage" url="/bank/query"></pager:legend>
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