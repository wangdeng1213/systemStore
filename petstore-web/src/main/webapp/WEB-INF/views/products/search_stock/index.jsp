<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>搜索库存列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span7"><div class="span7">
                               				<p class="lead">搜索库存</p>
                               			</div><div class="span7">
                                              				<p class="lead">搜索库存</p>
                                              			</div>
				<font size="6"><strong>搜索库存</strong></size>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('/search_stock/add');">新增</a>
					<a href="#" class="btn" onclick="gotoImportExcel('/real_stock/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/real_stock/gotoPreviewExcel');">预览excel</a>
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
							标的ID
						</th>
						<th>
							搜索库存量
						</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${search_stockPage.records}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.produc_id}
							</td>
							<td>
								${cur.left_amount}
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<pager:legend bean="search_stockPage" url="/real_stock/query"></pager:legend>
		</div>
	</div>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>

</body>