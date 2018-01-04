<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>前台注册用户列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="internetUserQueryObject" action="/user/internetUser/query"
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
								登录名称:
							</label>
							<form:input path="userName" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								用户ID:
							</label>
							<form:input path="id" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								真实姓名:
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
						<div class="span6">
							<label class="control-label">
								注册时间:
							</label>
							<input type="text" id="investTimes1" name="registerDates"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${internetUserQueryObject.registerDates[0] }">
							到
							<input type="text" id="investTimes2" name="registerDates"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${internetUserQueryObject.registerDates[1] }">
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
				<p class="lead"><font size="5"><strong>前台注册用户列表</strong></font></p>
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
							用户ID
						</th>
						<th>
                            登录名称
                          </th>
						<th>
						    真实姓名
						</th>
						<th>
							邮箱
						</th>
						<th>
							手机号码
						</th>
						<th>注册时间</th>

                         <th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${internetUserPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.id }
							</td>
                            <td>
                                  ${cur.userName }
                             </td>
							<td>
								${cur.name }
							</td>
							<td>
								${cur.email }
							</td>
							<td>
								${cur.mobilephone }
							</td>

                            <td>
                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:dd" value="${cur.registerDate }"></fmt:formatDate>
                             </td>
							<td>
							<!--	<a href="<c:url value='/user/internetUser/${cur.id}/update'/>">修改</a>-->
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/user/internetUser/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="internetUserPage" url="/user/internetUser/query"></pager:legend>
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