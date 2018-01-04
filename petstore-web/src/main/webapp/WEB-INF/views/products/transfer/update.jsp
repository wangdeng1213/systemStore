<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>修改债权转让</title>
     <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
     <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
     <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
     <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
     <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="transferModel"
			method="POST" action="/transfer/${transferModel.id}/update">
			<fieldset>
				<legend>
					修改债权转让信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

                <input type="hidden" name="id" value="productId">
				<div class="control-group">
					<label class="control-label" >
						收益总额:
					</label>
					<div class="controls">
                    						<form:input path="profitMoney" />
                    					</div>
				</div>
                      				<div class="control-group">
                      					<label class="control-label" >
                      						应付收益:
                      					</label>
                      					<div class="controls">
                                        						<form:input path="repaymentRate" />%
                                        </div>
                      				</div>
				<div class="control-group">
					<label class="control-label" >
						代理商:
					</label>
					<div class="controls">
					   <form:select path="agent" id="agent">
						  <c:forEach items="${allAgentModel}" var="cur">
							  <form:option value="${cur.id }">${cur.name }</form:option>
						  </c:forEach>
					    </form:select>
                   </div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						应付收益时间:
					</label>
					<div class="controls">
                    	<form:input path="profitTime" data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
                               	placeholder="还款日期:2012-12-21"/>
                    </div>
				</div>
				<div class="control-group">
                					<label class="control-label" >
                						每份价值:
                					</label>
                					<div class="controls">
                                    	<form:input path="perValue" />元
                                    </div>
                </div>
				<div class="control-group">
								<label class="control-label" >
									投资开始时间:
								</label>
								<div class="controls">
                                	<form:input path="startTime" data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
                                           placeholder="还款日期:2012-12-21" />
                                </div>
				</div>
				<div class="control-group">
                            <label class="control-label" >
                            		投资结束时间:
                          	</label>
                            <div class="controls">
                                  <form:input path="endTime" data-date="2012-12-21 00:00:00" data-date-format="yyyy-mm-dd"
                                       placeholder="还款日期:2012-12-21" />
                            </div>
                </div>
				<div class="control-group">
							<label class="control-label" >
									还款方式:
							</label>
							<div class="controls">
    							<form:select path="repayType">
                                        <form:option value="按月分期">按月分期</form:option>
                                        <form:option value="按季分期">按季分期</form:option>
                                        <form:option value="按月到期">按月到期</form:option>
                                        <form:option value="按天计息到期">按天计息到期</form:option>
                                </form:select>
                            </div>
				</div>
				<div class="control-group">
							<label class="control-label" >
									保障方式:
							</label>
							<div class="controls">
								<form:select path="ensureType">
    								    <form:option value="本金+利息">本金+利息</form:option>
    									<form:option value="本金">本金</form:option>
                                </form:select>
							</div>
				</div>
				<div class="control-group">
							<label class="control-label" >
									逾期情况:
							</label>
							<div class="controls">
                                       <form:input path="overdue" />
                            </div>
				</div>
				<div class="control-group">
							<label class="control-label" >
									风控信息:
							</label>
							<div class="controls">
    						<form:select path="riskInfo" >
    							<c:forEach items="${allRiskinfoModel}" var="cur">
    								<form:option value="${cur.id }">${cur.riskname }</form:option>
    							</c:forEach>
    						</form:select>
                            </div>
				</div>
				<div class="control-group">
							<label class="control-label" >
									借款期限:
							</label>
							<div class="controls">
                                    <form:input path="loanTerm" />
                            </div>
				</div>
				<div class="control-group">
							<label class="control-label" >
									认证等级:
							</label>
							<div class="controls">
 								<form:select path="authLevel">
 											<form:option value="1">一级</form:option>
 											<form:option value="2">二级</form:option>
 											<form:option value="3">三级</form:option>
 											<form:option value="4">四级</form:option>
 											<form:option value="5">五级</form:option>
 											<form:option value="6">六级</form:option>
 											<form:option value="7">七级</form:option>
 								</form:select>
                            </div>
				</div>
			    <div class="control-group">
							<label class="control-label" >
									发布类型:
							</label>
							<div class="controls">
								<form:select path="publishType">
										<form:option value="预发布">预发布</form:option>
										<form:option value="到时发布">到时发布</form:option>
								</form:select>
                            </div>
				</div>
				<div class="control-group">
							<label class="control-label" >
									标的总量:
							</label>
							<div class="controls">
                                 <form:input path="productTotal" />
                            </div>
				</div>
				<div class="control-group">
								<label class="control-label" >
									备注:
								</label>
								<div class="controls">
                                	<form:input path="description" />
                                </div>
				</div>


				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<button type="button" class="btn btn-primary" onclick="history.go(-1)">
    							返回
    					</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
       <script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" ></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-zh-CN.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#profitTime').datepicker({
				format:'yyyy-mm-dd'
			});

			    $('#preTime').datetimepicker({
                                                    timeFormat: "HH:mm:ss",
                                                    dateFormat: "yy-mm-dd"
                   });

                 $('#startTime').datetimepicker({
                                                    timeFormat: "HH:mm:ss",
                                                    dateFormat: "yy-mm-dd"
                     });

               	$('#endTime').datetimepicker({
                                                				timeFormat: "HH:mm:ss",
                                                                dateFormat: "yy-mm-dd"
                    });

		});
	</script>
</body>