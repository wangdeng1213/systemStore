<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>风控列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="RiskinfoQueryObject" action="/riskinfo/query"
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
                     			<label class="control-label" for="">
                     					风控名称:
                     			</label>
                     			<form:input path="" />
                     	 </div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="id">风控ID</form:option>
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
				<p class="lead">风控列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('/riskinfo/add');">新增</a>
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
							风控ID
						</th>
						<th>
							最高学历
						</th>
						<th>籍贯</th>
						<th>户口所在地</th>
						<th>居住地址</th>
						<th>居住地邮编</th>
						<th>居住地电话</th>
						<th>婚姻状况</th>
						<th>有无子女</th>
						<th>直系亲属姓名</th>
						<th>直系亲属关系</th>
						<th>直系亲属手机</th>
						<th>其他联系人姓名</th>
						<th>其他联系人关系</th>
						<th>其他联系人手机</th>
						<th>职业状态</th>
						<th>单位名称</th>
						<th>职位</th>
						<th>月收入</th>
						<th>工作邮箱</th>
						<th>工作城市</th>
						<th>公司地址</th>
						<th>公司类别</th>
						<th>公司行业</th>
						<th>公司规模</th>
						<th>在现单位工作年限</th>
						<th>公司电话</th>
						<th>是否有房</th>
						<th>有无房贷</th>
						<th>是否有车</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="tab">
					<c:forEach items="${RiskinfoPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
                            <td>${cur.id           }</td>
                            <td>${cur.education           }</td>
                            <td>${cur.hometown           }</td>
                            <td>${cur.hkszd           }</td>
                             <td>${cur.jzdz           }</td>
                           <td>${cur.jzdyb           }</td>
                            <td>${cur.jzddh           }</td>
                           <td><c:if test="${cur.hyzk == 1}">已婚</c:if>
                                               		<c:if test="${cur.hyzk == 2}">未婚</c:if>
                                               		<c:if test="${cur.hyzk == 3}">离异</c:if>
                                               		<c:if test="${cur.hyzk == 4}">丧偶</c:if>
                           </td>
                            <td><c:if test="${cur.ywzn == 1}">有</c:if>
                                                		<c:if test="${cur.ywzn == 2}">无</c:if>
                            </td>
                           <td>${cur.zxqsxm           }</td>
                            <td>${cur.zxqsgx           }</td>
                            <td>${cur.zxqssj           }</td>
                             <td>${cur.qtlxrxm           }</td>
                           <td>${cur.qtlxrgx           }</td>
                            <td>${cur.qtlxrsj           }</td>
                           <td>${cur.zyzt           }</td>
                            <td>${cur.dwmc           }</td>
                           <td>${cur.zw           }</td>
                            <td>${cur.ysr           }</td>
                           <td>${cur.gzyx           }</td>
                            <td>${cur.gzcs           }</td>
                            <td>${cur.gsdz           }</td>
                             <td>${cur.gslb           }</td>
                           <td>${cur.gshy           }</td>
                            <td>${cur.gsgm           }</td>
                           <td>${cur.zxdwgznx           }</td>
                            <td>${cur.gsdh           }</td>
                           <td><c:if test="${cur.sfyf == 1}">有</c:if>
                                                		<c:if test="${cur.sfyf == 2}">无</c:if></td>
                            <td><c:if test="${cur.ywfd == 1}">有</c:if>
                                                 		<c:if test="${cur.ywfd == 2}">无</c:if></td>
                            <td><c:if test="${cur.sfyc == 1}">有</c:if>
                                                 		<c:if test="${cur.sfyc == 2}">无</c:if></td>
							<td>
								<a href="<c:url value='/riskinfo/${cur.id}/update'/>">修改</span></a>
									<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/riskinfo/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="RiskinfoPage" url="/riskinfo/query"></pager:legend>
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