<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>债权转让列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
债权转让列表
		</div>

					<div class="row-fluid">债权转让列表
                                          	</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">债权转让列表</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('/product/add');">新增</a>
					<a href="#" class="btn" onclick="gotoImportExcel('/transfer/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/transfer/gotoPreviewExcel');">预览excel</a>
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
							应付收益
						</th>
						<th>
							年化收益
						</th>
						<th>
							代理商
						</th>
						<th>
							应付收益时间
						</th>
						<th>
							备注
						</th>
						<th>标的总额</th>
						<th>每份价值</th>
						<th>投资开始时间</th>
						<th>投资结束时间</th>
						<th>满标时间</th>
						<th>保障方式</th>
						<th>逾期情况</th>
						<th>还款方式</th>
						<th>风控信息</th>
						<th>建立人</th>
						<th>建立时间</th>
						<th>是否结束</th>
						<th>借款期限</th>
						<th>认证等级</th>
						<th>发布类型</th>
						<th>标的总量</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transferPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							    <td>${cur.profitMoney }</td>
                                <td>${cur.repaymentRate}</td>
                                <td>${cur.agent         }</td>
                                <td>${cur.profitTime   }</td>
                                <td>${cur.description   }</td>
                                <td>${cur.totalMoney   }</td>
                                <td>${cur.perValue     }</td>
                                <td>${cur.startTime    }</td>
                                <td>${cur.endTime      }</td>
                                <td>${cur.finishTime   }</td>
                                <td>${cur.ensureType   }</td>
                                <td>${cur.overdue       }</td>
                                <td>${cur.repayType    }</td>
                                <td>${cur.riskInfo     }</td>
                                <td>${cur.createBy     }</td>
                                <td>${cur.createTime   }</td>
                                <td>${cur.finish        }</td>
                                <td>${cur.loanTerm     }</td>
                                <td>${cur.authLevel    }</td>
                                <td>${cur.publishType  }</td>
                                <td>${cur.productTotal }</td>



							<td>
								<a href="<c:url value='/transfer/${cur.id}/update'/>"><i class="icon-edit" rel="tooltip" data-placement="bottom" title="修改"></i></a>
								<a href="#" id="trash${s.index+1 }" rel="popover" data-placement="left" data-content='<form:form action="/transfer/${cur.productId}/delete" method="DELETE"><div class="control-group" style="text-align:center"><label class="control-label"></label><div class="controls"><button type="submit" class="btn btn-primary">是</button><a class="btn" href="#" onclick="hideTrash(trash${s.index+1 })">否</a></div></div></form:form>' title="请确定是否删除数据"><i class="icon-trash" rel="tooltip" data-placement="bottom" title="删除"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="transferPage" url="/transfer/query"></pager:legend>
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
			$("#email").autoMail({
					emails:['qq.com','163.com','126.com','sina.com','sohu.com','yahoo.cn','gmail.com','hotmail.com','live.cn']
				});
			$('#registerDates1').datepicker({
				format:'yyyy-mm-dd'
			});
			$('#registerDates2').datepicker({
				format:'yyyy-mm-dd'
			});
			$("[rel=tooltip]").tooltip();
			$("a[id^=trash]").popover({html : true}).click(function(e) {
		        e.preventDefault();
		    });
		});
	</script>
</body>