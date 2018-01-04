<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						modelAttribute="vInvestRecordQueryObject" action="/user/investrecord/queryList"
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

						</div>
					</legend>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label" for="productName">
								标的名称:
							</label>
							<form:input path="productName" />
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
								投资时间:
							</label>
                             <input type="text" id="investTimes1" name="investTimes"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${vInvestRecordQueryObject.investTimes[0] }">
							到
							<input type="text" id="investTimes2" name="investTimes"
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								value="${vInvestRecordQueryObject.investTimes[1] }">
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="">----请选择----</form:option>
								<form:option value="productName">标的名称</form:option>
							</form:select>
						</div>
					</div>
					<div class="row-fluid">
					    <div class="span6" style="text-align: right">
					  	    <button class="btn btn-primary" type="submit">查询</button>
					  	</div>
						<div class="span6">
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
				<p class="lead"><font size="5"><strong>投资统计列表</strong></font></p>
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
							标的名称
						</th>
						<th>
						    投资总次数
						</th>
						<th>
							投资总人数
						</th>

						<th>
							投资总金额
						</th>
						<th>
                        	投资总收益
                        </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vInvestRecordPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.productName }</a>
							</td>
							<td>
								${cur.tztimes }
							</td>
							<td>
								${cur.tzperson }
							</td>
							<td>
                            	${cur.investMoney }
                            </td>
                            <td>
                            	${cur.income }
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="vInvestRecordPage" url="/user/investrecord/queryList"></pager:legend>
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
		    document.forms[0].action="/download";
            document.forms[0].submit();
            document.forms[0].action="/user/investrecord/queryList";
		}
	</script>
</body>