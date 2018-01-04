<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="authorize" uri="http://www.peanut.com/authorize"%>
<head>
    <title>未满标标的列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
    <link rel="stylesheet" href="/static/js/jquery-ui-1.11.4.custom/jquery-ui.css" />
    <link rel="stylesheet" href="/static/js/jquery-ui-1.11.4.custom/jquery-ui.min.css" />
    <link rel="stylesheet" href="/static/js/jquery-ui-1.11.4.custom/jquery-ui.theme.css" />
    <link rel="stylesheet" href="/static/js/jquery-ui-1.11.4.custom/jquery-ui.theme.min.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="productQueryObject" action="/product/queryList"
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
 							<label class="control-label" >
 								标的编号:
 							</label>
                                <form:input path="id" placeholder="2015-04-16 14:52:26" />

						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="yearRate">年化收益</form:option>
								<form:option value="preTime">发布时间</form:option>
								<form:option value="repaymentDate">还款日期</form:option>
								<form:option value="totalMoney">标的总额</form:option>
								<form:option value="loanTerm">借款期限</form:option>
							</form:select>
						</div>
					</div>
				    <div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="productTypeCod">
								标的类型:
							</label>
							<form:select path="productTypeCod" >
                             								<form:option value="">----请选择----</form:option>
                             								<form:option value="1">信用认证标</form:option>
                             								<form:option value="2">实地认证标</form:option>
                             								<form:option value="3">机构担保标</form:option>
                             								<form:option value="4">债权转让标</form:option>
                             							</form:select>
						</div>
					    <div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].orderType">
								排序类型:
							</label>
							<form:select path="orders[0].orderType">
								<form:option value="desc">正序</form:option>
								<form:option value="asc">倒序</form:option>
							</form:select>
					    </div>
					<div class="row-fluid">
					      <div class="span6" >
                     			<label class="control-label" >
                     					标的名称:
                     			</label>
                     			<form:input path="productName" placeholder="盛世E宝4" />
                     	 </div>
					     <div class="span6" style="text-align: right">
								<label class="control-label">
                                       标的种类:
                                </label>
 							<form:select path="type" placeholder="债权" >
 								<form:option value="">----请选择----</form:option>
 								<form:option value="Z">债权</form:option>
 								<form:option value="S">散标</form:option>
 								<form:option value="U">U计划</form:option>
 							</form:select>
					    </div>
				    </div>
					<div class="row-fluid">
					      <div class="span6" >
                     			<label class="control-label" >
                     					标的状态:
                     			</label>
 							<form:select path="statusCode" >
 								<form:option value="">----请选择----</form:option>
 								<form:option value="0">投标开始前</form:option>
 								<form:option value="1">投标中</form:option>
 								<form:option value="2">已满标</form:option>
 								<form:option value="3">还款中</form:option>
								<form:option value="4">已还清</form:option>
								<form:option value="5">转账处理中</form:option>
 							</form:select>
					    </div>
				    </div>
				    <div class="row-fluid">
                    		<div class="span6" style="text-align: right">
                    		 <authorize:authorize privilegeType="pageElement" resource="searchBtn" >
                    				<button class="btn btn-primary" type="submit">
                                                查询
                                    </button>
                               </authorize:authorize>
                    		</div>
                     </div>
				</fieldset>
			</form:form>
		</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">未满标标的列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<!--<a href="#" class="btn" onclick="gotoImportExcel('/product/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/product/gotoPreviewExcel');">预览excel</a>-->
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
							标的编号
						</th>
						<th>
							标的名称
						</th>
						<th>
						标的类型
					   </th>
						<th>
							还款日期
						</th>
						<th>
					     年化收益
						</th>
						<th>
					     标的总额
						</th>
						<th>
							审批状态
						</th>
						<th>
                        	发布状态
                        </th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="tab">
					<c:forEach items="${productPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
                            <td><a href="/transfer/${cur.id}/info" target="_blank">  ${cur.productCode } </a></td>
                            <td>${cur.productName           }</td>
                            <td><c:forTokens items="${cur.productTypeCod}" delims="," var="productTypeCod">
								<c:if test="${productTypeCod=='1'}">信用认证标</c:if>
								<c:if test="${productTypeCod=='2'}">实地认证标</c:if>
								<c:if test="${productTypeCod=='3'}">机构担保标</c:if>
								<c:if test="${productTypeCod=='4'}">债权转让标</c:if>
								<c:if test="${productTypeCod=='5'}">抵质押标</c:if><p></c:forTokens>
                            </td>
                            <td>${cur.repaymentDate         }</td>
                            <td>${cur.yearRate              }%</td>
                            <td>${cur.totalMoney}元</td>
                            <td id="td"><c:choose><c:when test="${cur.statusCode == '-2'}"><span>待审批</span></c:when>
                                        <c:otherwise><span>已审批</span></c:otherwise></c:choose>
                            </td>
                            <td><c:choose><c:when test="${cur.statusCode == '-1' ||cur.statusCode == '-2' }"><span>待发布</span></c:when>
                                   <c:otherwise><span>已发布</span></c:otherwise></c:choose></td>
							<td>
                                <a href="<c:url value='/product/${cur.id}/update'/>">修改</a>
								<a href="<c:url value='/product/${cur.id}/approval'/>">
								<c:choose>
									<c:when test="${cur.statusCode == '-1'}">
									<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/product/${cur.id}/release" method="GET"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="确定发布吗？"><span class="badge">发布</span></a>
									</c:when>
									<c:when test="${cur.statusCode == '0'}">
									<a href="#"><span class="badge">已发布</span></a>
									</c:when>
									<c:when test="${cur.statusCode == '-1' || cur.statusCode == '-2' }">
                                    <button type="button" class="btn btn-primary">审批</button></a>
                                    </c:when>
                                    <c:when test="${cur.statusCode == '1'}">
                                      <a href="#"><span class="badge">投标中</span></a>
                                    </c:when>
                                    <c:when test="${cur.statusCode == '7'}">
                                       <a href="#"><span class="badge">投标结束</span></a>
                                     </c:when>
                                     <c:when test="${cur.statusCode == '2'}">
                                        <a href="#"><span class="badge">满标</span></a>
                                     </c:when>
                                     <c:when test="${cur.statusCode == '3'}">
                                         <a href="#"><span class="badge">还款中</span></a>
                                     </c:when>
									<c:otherwise>
										<a href="#"><span class="badge">已发布</span></a>
									</c:otherwise>
								</c:choose>
							</td>

							<td><a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/product/${cur.id}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据">删除</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="productPage" url="/product/queryList"></pager:legend>
		</div>
	</div>
	<div id="showApproval"></div>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>
	<script src="/static/js/jquery/1.9.1/prototype.js"></script>
	<script src="/static/js/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>

	<script type="text/javascript">
		function hideTrash(id){
			$(id).popover('hide');
		}
		$(document).ready(function(){
			$("[rel=tooltip]").tooltip();
			$("a[id^=trash]").popover({html : true}).click(function(e) {
		        e.preventDefault();
		    });

		    $( "#showApproval" ).dialog({ autoOpen: false });

		});

		 function gotoApproval(){
		           var productId = jQuery("#appro").val();
		           alert(productId);
                   var divContent = jQuery("#showApproval");
                   divContent.empty();
                   divContent.html("<iframe id='showIframe' src='/product/"+productId+"/approval"+
                   	"' height='100%' width='100%' frameborder='0' style='padding: 0px;margin: 0px' ></iframe>");
                   divContent.dialog({
                                               autoOpen: true,
                                               height: 600,
                                               width: 500,
                                               resizable: true,
                                               draggable: false,
                                               modal: false,
                                               title: "审批信息"

               });
                 }
	</script>
</body>