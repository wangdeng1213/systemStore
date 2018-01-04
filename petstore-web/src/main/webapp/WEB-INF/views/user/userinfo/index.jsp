<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>用户信息列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="userInfoQueryObject" action="/user/userinfo/query"
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
							<label class="control-label" for="userName">
							   用户名:
							</label>
							<form:input path="userName" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="name">
								真实姓名:
							</label>
							<form:input path="name" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="userName">用户名</form:option>
								<form:option value="sex">性别</form:option>
								<form:option value="idcard">身份证</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								性  别:
							</label>
							<form:select path="sex">
							    <form:option value="">----请选择----</form:option>
							    <form:option value="1">男</form:option>
							    <form:option value="2">女</form:option>
							</form:select>
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
                        <div class="span5" style="text-align: right">
								<div class="btn-group">
									<button class="btn btn-primary" type="submit">
										查询
									</button>
								<!--	<button class="btn" type="button" onclick="exportExcel('queryObjectForm','/user/userinfo/export','/user/user_privilege/query');">
										导出Excel
									</button>
									<button class="btn" type="button" onclick="exportPDF('queryObjectForm','/user/userinfo/exportPDF','/user/user_privilege/query');">
										导出PDF
									</button>-->
								</div>
					     </div>
                       </div>
				</fieldset>
			</form:form>
		</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead"><font size="5"><strong>用户信息列表</strong></font></p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<!--<a href="#" class="btn btn-primary" onclick="gotoAdd('/user/userinfo/add');">新增</a>-->
					<!--<a href="#" class="btn" onclick="gotoImportExcel('/company/import');">导入excel</a>
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
							用户名
						</th>

						<th>
							真实姓名
						</th>
						<th>
							性别
						</th>
						<th>
							证件类型
						</th>
						<th>
                            身份证
                        </th>
                        <th>
                            相关证件
                         </th>
                         <th>
                            地址
                         </th>
						<th>
                            手机
                        </th>
                        <th>
                            电话
                         </th>
                         <th>
                            EMAIL
                         </th>
                         <th>
                            QQ
                         </th>

                         <th>生日</th>
                         <th>激活状态</th>
                         <th>手机认证</th>
                         <th>身份认证</th>
                         <th>邮箱认证</th>
                         <th>最后修改人</th>
                         <th>最后修改时间</th>
                         <th>备注</th>


					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userInfoPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								<a href="/user/userinfo/${cur.id}/info" target="_blank">${cur.userName }</a>
							</td>

							<td>
								${cur.name }
							</td>
							<td>
								<c:choose>
									<c:when test="${cur.sex == 2}">
										<span>女</span>
									</c:when>
									<c:otherwise>
										<span>男</span>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${cur.idcardType == 1}">
										<span>身份证</span>
									</c:when>
									<c:otherwise>
										<span>港澳台通行证</span>
									</c:otherwise>
								</c:choose>
                            </td>
                            <td>
                                 ${cur.idcard }
                             </td>
                             <td>
                                 ${cur.releDocuments }
                             </td>
                             <td>
                                 ${cur.address }
                             </td>
                             <td>${cur.mobilephone }</td>
                              <td>${cur.telephone }</td>
                               <td>${cur.email }</td>
                                <td>${cur.qq }</td>

                                 <td>${cur.birthday }</td>
                                  <td>
								<c:choose>
									<c:when test="${cur.actStatus == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose>                            </td>
                                   <td>
								<c:choose>
									<c:when test="${cur.phoneAuth == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose>                                   </td>
                                    <td>
								<c:choose>
									<c:when test="${cur.idcardAuth == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose>                                     </td>
                                     <td>
								<c:choose>
									<c:when test="${cur.emailAuth == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose>                                     </td>
                                      <td>${cur.updateBy }</td>
                                       <td>${cur.updateTime }</td>
                                       <td>${cur.descriptions }</td>

							<td>
								<a href="<c:url value='/user/userinfo/${cur.id}/update'/>">修改</a></td>
							<td><a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/user/userinfo/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<pager:legend bean="userInfoPage" url="/user/userinfo/query"></pager:legend>
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
		});

	</script>
</body>