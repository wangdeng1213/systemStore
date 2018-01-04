<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>修改标的信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="/static/css/pager/pager.css" />
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link rel="stylesheet" href="/static/css/autoMail/autoMail.css" />

</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="productInfoModel" id="productForm"
			method="POST" action="/product/${productInfoModel.product.id}/update" onsubmit="return vali();">
			<form:input path="product.id" value="${product.id}"  />
			<form:input path="transfer.transferId" value="${transfer.transferId}"  />
			<fieldset>
				<legend>
					修改标的信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
				  <div class="span4" >
					<label class="control-label" for="productName">
						标的名称:
					</label>
						<form:input path="product.productName" id="productName" value="${product.productName}"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4" >
					<label class="control-label" for="productTypeCod" style="text-align: right">
						标的类型:
					</label>
				    <form:select path="product.productTypeCod" value="${product.productTypeCod}" multiple="multiple">
						<form:option value="1">信用认证标</form:option>
						<form:option value="2">实地认证标</form:option>
						<form:option value="3">机构担保标</form:option>
						<form:option value="4">债权转让标</form:option>
						<form:option value="5">抵质押标</form:option>
					</form:select><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
					<label class="control-label"  >
						标的种类:
					</label>
                          <form:select path="transfer.type">
                                  <form:option value="Z">债权</form:option>
                                  <form:option value="S">散标</form:option>
                                  <form:option value="U">U计划</form:option>
                          </form:select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>

				</div>

				<div class="control-group">
                   <div class="span4">
                         <label class="control-label" for="totalMoney">
                                标的总额:
                         </label>
                              <form:input path="product.totalMoney" id="to" value="${transfer.totalMoney}"/>元<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                  <div  class="span4">
                	<label class="control-label" >
                		购买方式:
                	</label>
                		<form:radiobutton path="product.buyType" value="1"  id="buy_type1"/>按份
                		<form:radiobutton path="product.buyType" value="2" id="buy_type2"/>按金额<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                    <div class="span4">
					   <label class="control-label" >
						月综合费率:
					   </label>
                         <form:input path="transfer.month_rate" value="${transfer.month_rate}"/>%<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                    </div>
                 </div>
                <div class="control-group">
                  <div class="span4" id="product2">
					<label class="control-label" style="text-align: right" >
						每份价值:
					</label>
                         <form:input path="transfer.perValue" id="p2" value="${transfer.perValue}"/>元<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                  <div class="span4" id="product1">
					<label class="control-label" >
						标的总份:
					</label>
                         <form:input path="transfer.productTotal"  id="p1" value="${transfer.productTotal}"/>份<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				</div>
                <div class="control-group"  id="total1">

               	    <div class="span4"  id="total2">
                        <label class="control-label" style="text-align: right">
                                最小投资金额:
                        </label>
                             <form:input path="product.minimumInvestment" id="t2" value="${product.minimumInvestment}"/>元<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                    </div>
                </div>
				<div class="control-group">
				   <div  class="span4">
                	 <label class="control-label" for="yearRate">
                		年化收益:
                	 </label>
                			<form:input path="product.yearRate" id="yearRate" value="${product.yearRate}"/>% <span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                			<span id="s_msg" style="color: Red; display: none; font-size: 10pt; font-weight: bold; font-family: Andalus;">年利率必须为正整数，请您重新输入！</span>
                   </div>
				   <div  class="span4">
                	 <label class="control-label" for="profitMoney">
                		应付收益总额:
                	 </label>
                			<form:input path="transfer.profitMoney" id="profitMoney" value="${transfer.profitMoney}"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>

                   </div>
				  <div class="span4">
					<label class="control-label" >
						应付收益时间:
					</label>
                    	<form:input path="transfer.profitTime" id="profitTime" value="${transfer.profitTime}"/><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				</div>
				<div class="control-group">
                  <div class="span4" >
                	 <label class="control-label" style="text-align: right">
                		代理商:
                	 </label>
                		<form:select id="agent" path="transfer.agent" value="${transfer.agent}">
                			<c:forEach items="${allAgentModel}" var="cur">
                				<form:option value="${cur.userId }">${cur.name }</form:option>
                			</c:forEach>
                		</form:select><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                   </div>
				    <div class="span4">
					   <label class="control-label" >
						发布类型:
					   </label>
						<form:select path="transfer.publishType" id="publishType" value="${transfer.publishType}">
							<form:option value="1">预发布</form:option>
							<form:option value="2">即时发布</form:option>
						</form:select><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                	</div>
                    <div  class="span4" >
                    	<label class="control-label" style="text-align: right">
		                    预发布时间:
                		</label>
                		<form:input path="transfer.preTime" id="preTime"  value="${transfer.preTime}"/><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                   </div>
				</div>
			    <div class="control-group">
			      <div class="span4">
					<label class="control-label" >
							投标开始时间:
					 </label>
                          <form:input path="transfer.startTime" id="startTime" value="${transfer.startTime}"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label"  style="text-align: right">
						    投标结束时间:
					</label>
						<form:input path="transfer.endTime"  id="endTime" value="${transfer.endTime}"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				</div>
				<div class="control-group">
				   <div class="span4">
					<label class="control-label" >
						锁标期:
					</label>
                         <form:input path="transfer.over_term" id="overTerm"  value="${transfer.over_term}"/>
                   </div>
				   <div class="span4">
					<label class="control-label" style="text-align: right">
						锁标结束时间:
					</label>
                         <form:input path="transfer.over_time" id="overTime" value="${transfer.over_time}"/>
                   </div>
			      <div class="span4">
					<label class="control-label" >
						满标时间:
					</label>
                         <form:input path="transfer.finishDate"  id="finishTime" />
                    </div>
				</div>

				<hr>
                <div class="control-group">

                 </div>
				<div class="control-group">
				  <div class="span4">
					<label class="control-label" >
							保障方式:
					</label>
							<form:select id="ensureType" path="transfer.ensureType" value="${transfer.ensureType}">
                                   <c:forEach items="${allEnsureTypeModel}" var="cur">
                                         <form:option value="${cur.id }">${cur.name }</form:option>
                                   </c:forEach>
                            </form:select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
					<label class="control-label" style="text-align: right">
						认证等级:
					</label>
						<form:select path="transfer.authLevel" value="${transfer.authLevel}">
							<form:option value="1">一级</form:option>
							<form:option value="2">二级</form:option>
							<form:option value="3">三级</form:option>
							<form:option value="4">四级</form:option>
							<form:option value="5">五级</form:option>
							<form:option value="6">六级</form:option>
							<form:option value="7">七级</form:option>
						</form:select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label" style="text-align: right">
						是否新手推荐:
					</label>
						<form:select path="product.releaseStatus" value="${product.releaseStatus}">
							<form:option value="0">否</form:option>
							<form:option value="1">是</form:option>
						</form:select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                </div>

                <div class="control-group">
                  <div class="span4">
                	<label class="control-label" >
                		借款人借款时间:
                	</label>
                		<form:input path="product.borrower_bor_time" id="borrower_bor_time" value="${product.borrower_bor_time}"/><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                  <div class="span4">
                	<label class="control-label" style="text-align: right">
                		借款人还款时间:
                	</label>
                		<form:input path="product.borrower_rep_time" id="borrower_rep_time" value="${product.borrower_rep_time}" /><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label" >
						违约金:
					</label>
                         <form:input path="transfer.odd" id="odd" value="${transfer.odd}"/>%
                    </div>

                </div>
				<div class="control-group">
				  <div class="span4">
					<label class="control-label" >
						借款期限:
					</label>
                         <form:input path="transfer.loanTerm" id="loanTerm" value="${transfer.loanTerm}"/>天<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label" style="text-align: right">
						最后一次还款日期:
					</label>
						<form:input path="product.repaymentDate" id="repaymentDate" value="${product.repaymentDate}"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
					<label class="control-label" >
						管理费:
					</label>
                         <form:input path="transfer.manage_fee" placeholder="提示根据借款人的信用登记表计算" id="mfee" value="${transfer.manage_fee}"/>%
                  </div>
				</div>
				<div class="control-group">
				  <div class="span4">
					<label class="control-label" >
						逾期情况:
					</label>
                         <form:input path="transfer.overdue" value="${transfer.overdue}"/>
                    </div>
				  <div class="span4">
					<label class="control-label" >
						交易手续费:
					</label>
                         <form:input path="transfer.transfer_fee" placeholder="提示根据借款人的信用登记表计算" id="tfee" value="${transfer.transfer_fee}"/>%
                    </div>
				  <div class="span4">
					<label class="control-label" >
						借款类型:
					</label>
						<form:select path="product.approvalStatus" value="${product.approvalStatus}">
							<form:option value="1">个人借款</form:option>
							<form:option value="2">企业借款</form:option>
						</form:select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                    </div>

			<!--  <div class="span4">
					<label class="control-label" >
						待还本息:
					</label>
                         <form:input path="transfer.to_pay" placeholder="收益总额+标的总额（本金）+平台服务费（管理费和手续费）+违约金（如有)" id="tpay" value="${transfer.to_pay}"/>
                  </div>-->
				</div>
				<hr>
				<div class="control-group">
				   <div class="span4">
					<label class="control-label" >
						还款方式:
					</label>
                         <form:select path="transfer.repayType" value="${transfer.repayType}">
                                <form:option value="1">等额本息</form:option>
                                <form:option value="2">等本等息</form:option>
                         </form:select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                  <div class="span4">
					<label class="control-label" style="text-align: right">
						风控信息:
					</label>
						<form:select id="riskInfo" path="transfer.riskInfo" value="${transfer.riskInfo}">
							<c:forEach items="${allRiskinfoModel}" var="cur">
								<form:option value="${cur.id }">${cur.id }</form:option>
							</c:forEach>
						</form:select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
					<label class="control-label" >
						修改人:
					</label>
                         <form:input path="transfer.createBy" value="${transfer.createBy}"/>
                    </div>
                </div>
                <div class="control-group">
                  <div class="span4">
					<label class="control-label" for="productDesc">
						标的描述:
					</label>
						<form:textarea path="product.productDesc" value="${product.productDesc}" />
				  </div>
				  <div class="span4">
                	<label class="control-label" style="text-align: right">
                		借款用途:
                	</label>
                        <form:textarea path="product.used"  value="${product.used}" />
                  </div>
				  <div class="span4">
                	<label class="control-label" style="text-align: right">
                		企业借款描述:
                	</label>
                        <form:textarea path="transfer.attribute1"  value="${transfer.attribute1}" />
                  </div>

                </div>
                <div class="control-group">
                  <div class="span4">
                      <label class="control-label" for="ascendcompanyidea">
                           债权提供方:
                      </label>
                           <form:textarea path="product.ascendcompanyidea" value="${product.ascendcompanyidea}" />
                  </div>
				  <div class="span4">
					<label class="control-label" style="text-align: right" >
						备注:
					</label>
                         <form:textarea path="transfer.description"  value="${transfer.description}"/>
                  </div>
				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
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
        <script src="/static/js/p2p/product/update.js" type="text/javascript"></script>
	<script type="text/javascript">


	</script>


</body>