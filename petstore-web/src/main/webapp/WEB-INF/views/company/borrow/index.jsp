<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>借款详情</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">

				<fieldset>
                <legend>
					    <div class="row-fluid">
                            234
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
								借款订单编号:
							    <input type="text" ></input>
							</label>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								借款金额:
							   <input type="text" ></input>
							</label>
						</div>
						<div class="span6" style="text-align: right">
							<label class="control-label">
								排序列:

							   <select>
							        <option value="">---请选择---</option>
							        <option value="1"></option>
							   </select>
                            </label>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label class="control-label">
								借款标题:
							  <input type="text" ></input>
							</label>
						</div>
					    <div class="span6" style="text-align: right">
							<label class="control-label">
								排序类型:
							 <select>
                            		<option value="">---请选择---</option>
                            		<option value="1"></option>

                             </select>
                           </label>
					    </div>
						<div class="span6" style="text-align: right"><button class="btn btn-primary" type="submit">查询</button></div>
					</div>
		<div class="row-fluid">
			<div class="span7">
				<p class="lead">借款详情</p>
			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
					<a href="#" class="btn btn-primary" onclick="gotoAdd('');">新增</a>
					<a href="#" class="btn" onclick="gotoImportExcel('/company/import');">导入excel</a>
					<a href="#" class="btn" onclick="gotoPreviewExcel('/company/gotoPreviewExcel');">预览excel</a>
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
							借款订单编号
						</th>
						<th>
							借款人编号
						</th>
						<th>
							借款标题
						</th>
						<th>
							借款金额
						</th>
						<th>
							借款描述
						</th>
						<th>
							借款时间
						</th>
						<th>
                           借款期限
                        </th>
                        <th>
                           剩余还款额
                        </th>
                        <th>借款状态</th>
                        <th>客户端版本</th>
                        <th>IP</th>
                        <th>真实姓名</th>
                        <th>借款期限ID</th>
                        <th>操作</th>
					</tr>
				</thead>
				<tbody>
                     <tr>
                       <td></td>
                        <td></td>
                         <td></td>
                          <td></td>
                           <td></td>
                            <td></td>
                             <td></td>
                              <td></td>
                               <td></td>
                               <td></td>
                                <td></td>
                                 <td></td>
                                  <td></td>
                                     <td></td>
                                       <td><a href="/borrow/info"><button class="btn btn-primary" type="button">审核</button></a></td>



                     </tr>
				</tbody>
			</table>
			<pager:legend bean="" url="/company/query"></pager:legend>
		</div>
	</div>	
	<script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-tooltip.js"></script>
	<script src="/static/js/bootstrap/2.3.2/bootstrap-popover.js"></script>
	<script type="text/javascript" src="/static/js/autoMail/autoMail.js"></script>
	<script src="/static/js/p2p/1.0.0/p2p.js"></script>
	<script src="/static/js/p2p/1.0.0/document.min.js"></script>
	<script type="text/javascript">

	</script>
</body>