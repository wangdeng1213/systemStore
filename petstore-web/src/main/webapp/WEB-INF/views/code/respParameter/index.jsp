<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>第三方返回参数列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="respQueryObject" action="/respParameter/query"
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
                     			<label class="control-label">
                     					请求流水号:
                     			</label>
                     			<form:input path="requestNo" />
                     	 </div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="">----请选择----</form:option>
								<form:option value="id">ID</form:option>
							</form:select>
						</div>
					</div>
				    <div class="row-fluid">
                         <div class="span6" >
                     			<label class="control-label">
                     					服务名称:
                     			</label>
                     			<form:input path="service" />
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
					    <div class="span6" style="text-align: right" >
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
				<p class="lead">第三方返回参数列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
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
							商户编号
						</th>
						<th>
							请求流水号
						</th>
						<th>
							服务名称
						</th>
						<th>返回值
						</th>
						<th>描述信息</th>
						<th>
							操作人
						</th>
						<th>
							传入参数
						</th>
						<th>
							notifyurl
						</th>
						<th>notify参数
						</th>
						<th>callbackurl</th>
						<th>callback参数</th>
						<th>时间</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="tab">
					<c:forEach items="${respPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
                            <td>${cur.platformNo          }</td>
                            <td>${cur.requestNo  }</td>
                            <td>${cur.service  }
                            </td>
                            <td>${cur.code}
                               </td>
                            <td>${cur.description}</td>
							<td>
								${cur.operator }
							</td>
                            <td>${cur.parameters          }</td>
                            <td>${cur.notifyurl  }</td>
                            <td>${cur.notifyparams  }
                            </td>
                            <td>${cur.callbackurl}
                               </td>
                            <td>${cur.callbackparams}</td>
                            <td>${cur.createtime}</td>
							<td>
						<!--		<a href="<c:url value='/respParameter/${cur.id}/update'/>"><span class="up">修改</span></a>-->
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="respPage" url="/respParameter/query"></pager:legend>
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