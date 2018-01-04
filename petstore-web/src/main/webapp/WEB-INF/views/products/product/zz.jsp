<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="pager" uri="http://www.peanut.com/pagination"%>
<%@ taglib prefix="template" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<head>
    <title>投资列表</title>
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />
</head>
<body>
	<div class="container-fluid">

		<div class="row-fluid">
			<div class="span7">

			</div>
			<div class="span5" style="text-align: right">
				<div class="btn-group">
				  <div>dsad</div>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span7">

			</div>
		    <div class="span5">
		     <p class="lead"><font size="5"><strong>标的投资列表</strong></font></p>
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
                             标的名称
                          </th>
						<th>
						    投资人ID
						</th>
						<th>
							投资金额
						</th>
						<th>
							投资收益
						</th>

						<th>
                            投资时间
                        </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${investRecordList}" var="cur" varStatus="s">
						<tr>
							<td>
								${s.index+1 }
							</td>
							<td>
								${cur.productId }
							</td>
                            <td>
                                  ${cur.productName }
                             </td>
							<td>
								${cur.userId }
							</td>
							<td>
								${cur.investMoney }元
							</td>
							<td>
								${cur.income }元
							</td>

                            <td>
                              <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cur.investTime }"></fmt:formatDate>
                             </td>
							<td>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row-fluid">
		   <div class="span4">
			<label class="control-label">
        		 借款人:${agentModel.name}
        	</label>
           </div>
        </div>
        <div class="row-fluid">
           <div class="span4">
		    <label class="control-label">
                 借款金额:${productList.totalMoney}元
            </label>
           </div>
		</div>
		<form:form action="/product/${productList.id}/confirmZZ" method="post">
		      <label class="control-label">
           					 <input type="hidden" name="id" value="${productList.id}"/><font color="red">${confirmList}</font>
              </label>

				<div class="control-group">

 					<div class="controls">
 					    <button type="submit" class="btn btn-primary" >
                     		确认转账
                     	</button>
 						<a href="/product/${productList.id}/queryTransaction"><button type="button" class="btn btn-primary">
                         	查询交易状态
                        </button></a>
 						<button type="button" class="btn btn-primary" onclick="history.go(-1);">
 							返回
 						</button>
 					</div>
 				</div>
 		</form:form>
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

		function confirmZZ(){

		}
	</script>
</body>