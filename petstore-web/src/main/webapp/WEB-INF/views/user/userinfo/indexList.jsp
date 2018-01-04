<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>用户信息统计</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
	<link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
	<link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
	<link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="vUserInfoQueryObject" action="/user/userinfo/queryList"
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
							   用户名:
							</label>
							<form:input path="" />
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								真实姓名:
							</label>
							<form:input path="" />
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="id">----请选择----</form:option>
								<form:option value="">用户名</form:option>
								<form:option value="">性别</form:option>
								<form:option value="">身份证</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								时间:
							</label>
                             <input type="text" id="investTimes1" name=""
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${vInvestRecordQueryObject.investTimes[0] }">
							到
							<input type="text" id="investTimes2" name=""
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${vInvestRecordQueryObject.investTimes[1] }">

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
								<div class="span6">
									<button class="btn btn-primary" type="submit">
										查询
									</button>
								</div>
						    <div class="span6">
								<div class="btn-group">
							<!--		<button class="btn" type="button" onclick="import1();">
										导入Excel
									</button>
									<div id="msgchChooseId"></div>-->
								</div>
								<div class="btn-group">
									<button class="btn" type="button" onclick="downLoad();">
										导出Excel
									</button>
								</div>
							</div>
                       </div>
				</fieldset>
			</form:form>
		</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead"><font size="5"><strong>用户信息统计</strong></font></p>
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
							用户总人数
						</th>

						<th>
							PC端注册人数
						</th>
						<th>
							移动端注册人数
						</th>
						<th>
							PC端活跃人数
						</th>
						<th>
                            移动端活跃人数
                        </th>
                        <th>
                            手机认证人数
                         </th>
                         <th>
                            身份证认证人数
                         </th>
						<th>
                            未认证人数
                        </th>
                        <th>
                            特权活跃度
                         </th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vUserInfoPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.userName }</a>
							</td>

							<td>
								${cur.name }
							</td>
							<td>${cur.sex}
							</td>
							<td>

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
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<pager:legend bean="vUserInfoPage" url="/user/userinfo/queryList"></pager:legend>
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
		function downLoad(){
            var url = "/download";
            window.open(url);
		}

		function import1(){
		  alert(323);
         	   var chooseMsgDialog = null;
         	    jQuery("#msgchChooseId").html("<iframe id='sumIFrame' src='/user/import' height='80%' width='100%' frameborder='0' style='padding: 0px;margin: 0px' ></iframe>");

         		if(chooseMsgDialog==null){
         			chooseMsgDialog = jQuery("#msgchChooseId").dialog({
                        autoOpen : false,
         				title : "信息",
         				width : 720,
         				height : 500,
         				resizable : true,
         				position : "center",
         				modal : false

         			});
         		}
         		chooseMsgDialog.dialog("open");
         		jQuery("#msgchChooseId").css({
         			height : "470px"
         	    });
         	}
	</script>
</body>