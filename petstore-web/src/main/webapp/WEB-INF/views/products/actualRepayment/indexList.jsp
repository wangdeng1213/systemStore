<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>实际还款统计列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form:form id="queryObjectForm" cssClass="form-inline"
						modelAttribute="vActualRepaymentQueryObject" action="/actualRepayment/queryList"
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
							<label class="control-label">
								标的名称:
							</label>
							<form:input path="" />
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
								实际还款时间:
							</label>
                             <input type="text" id="investTimes1" name=""
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								>
							到
							<input type="text" id="investTimes2" name=""
								class="input-small" placeholder="2012-12-21"
								data-date="2012-12-21" data-date-format="yyyy-mm-dd"
								>
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label" for="orders[0].name">
								排序列:
							</label>
							<form:select path="orders[0].name">
								<form:option value="">----请选择----</form:option>
								<form:option value=""></form:option>
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
				<p class="lead"><font size="5"><strong>实际还款统计列表</strong></font></p>
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
						    借款金额
						</th>
						<th>标的种类</th>
						<th>
							年化收益
						</th>
						<th>
							借款期限
						</th>
						<th>
							借款人
						</th>
						<th>
							借款时间
						</th>
						<th>
							还款类型
						</th>
						<th>
							还款总额
						</th>
						<th>
							每期应还金额
						</th>
						<th>
							开始还款时间
						</th>
						<th>
							结束时间
						</th>
						<th>银行名称</th>
						<th>
							开户行支行
						</th>
						<th>
							银行账号
						</th>
						<th>到账时间</th>
						<th>到账金额</th>
						<th>是否异常</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vActualRepaymentPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								</a>
							</td>
							<td>
								元
							</td>
							<td>
							</td>
							<td>
								%
							</td>
							<td>
								天
							</td>
							<td>

                            </td>
                            <td>元</td>
                            <td></td>
                            <td>元</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="vActualRepaymentPage" url="/actualRepayment/queryList"></pager:legend>
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
            var url = "/repayment_plan/download";
            window.open(url);
		}
	</script>
</body>