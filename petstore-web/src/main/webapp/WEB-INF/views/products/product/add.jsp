<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>标的信息</title>
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
		<form:form cssClass="form-horizontal" modelAttribute="product,transfer" id="productForm"
			method="POST" action="/product/add" onsubmit="return vali();">

			<fieldset>
				<legend>
					新增标的信息
				</legend>
				<div class="control-group">
				  <div class="span4" >
					<label class="control-label" >
						标的名称:
					</label>
						<input type="text" name="productName" id="productName"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4" >
					<label class="control-label" for="productTypeCod" style="text-align: right">
						标的类型:
					</label>
				    <select name="productTypeCod" multiple="multiple">
						<option value="1">信用认证标</option>
						<option value="2">实地认证标</option>
						<option value="3">机构担保标</option>
						<option value="4">债权转让标</option>
						<option value="5">抵质押标</option>
					</select><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>

				  <div class="span4">
					<label class="control-label"  >
						标的种类:
					</label>
                          <select name="type">
                                  <option value="Z">债权</option>
                                  <option value="S">散标</option>
                                  <option value="U">U计划</option>
                          </select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                    </div>

                </div>
                <div class="control-group">
                    <div class="span4">
					   <label class="control-label" >
						标的总额:
					   </label>
                         <input type="text" name="totalMoney"  id="to"/>元<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                    </div>
                  <div  class="span4">
                	<label class="control-label" style="text-align: right">
                		购买方式:
                	</label>
                		<input type="radio" name="buyType" value="1"  id="buy_type1"/>按份
                		<input type="radio" name="buyType" value="2" checked="checked" id="buy_type2"/>按金额<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                    <div class="span4">
					   <label class="control-label" >
						月综合费率:
					   </label>
                         <input type="text" name="month_rate"/>%<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                    </div>
                </div>
                <div class="control-group"  style="display:none;" id="product1">

                  <div class="span4" id="product2">
					<label class="control-label" style="text-align: right">
						每份价值:
					</label>
                         <input type="text" name="perValue" id="p2"/>元<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                  <div class="span4" id="product2">
                  	<label class="control-label" style="text-align: right">
                  		标的总份:
                  	</label>
                          <input type="text" name="productTotal" id="pt" readonly="true" placeholder="标的总额/每份价值"/>份
                  </div>
				</div>
				<form:errors cssStyle="color:red" path="productName" />
                <div class="control-group"  id="total1">

               	    <div class="span4"  id="total2">
                        <label class="control-label" style="text-align: right">
                                最小投资金额:
                        </label>
                             <input type="text" name="minimumInvestment" id="t2"/>元<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                    </div>
                </div>
				<div class="control-group">
				   <div  class="span4">
                	 <label class="control-label" for="yearRate">
                		年化收益:
                	 </label>
                			<input type="text" name="yearRate" id="yearRate"/>% <span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                			<span id="s_msg" style="color: Red; display: none; font-size: 10pt; font-weight: bold; font-family: Andalus;">年利率必须为正整数，请您重新输入！</span>
                   </div>
				   <div  class="span4">
                	 <label class="control-label" for="profitMoney">
                		应付收益总额:
                	 </label>
                			<input type="text" name="profitMoney" id="profitMoney" placeholder="（标的总额*年化收益率）/12*锁标期" readonly="true"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                   </div>
 				  <div class="span4">
 					<label class="control-label" >
 						应付收益时间:
 					</label>
                     	<input type="text" name="profitTime" id="profitTime" placeholder="投标结束时间+30" readonly="true"/><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
 				  </div>
                </div>
				<div class="control-group">

                  <div class="span4" >
                	 <label class="control-label" style="text-align: right">
                		借款人:
                	 </label>
                		<select id="agent" name="agent" >
                			<c:forEach items="${allAgentModel}" var="cur">
                				<option value="${cur.userId }">${cur.userId }---${cur.name }</option>
                			</c:forEach>
                		</select><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                   </div>
				    <div class="span4">
					   <label class="control-label" style="text-align: right">
						发布类型:
					   </label>
						<select name="publishType" id="publishType">
							<option value="1">预发布</option>
							<option value="2">即时发布</option>
						</select><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                	</div>
                    <div  class="span4" >
                    	<label class="control-label" style="text-align: right">
		                    预发布时间:
                		</label>
                		<input type="text" name="preTime" id="preTime" /><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                   </div>
				</div>
			    <div class="control-group">
			      <div class="span4">
					<label class="control-label" >
							投标开始时间:
					 </label>
                          <input type="text" name="startTime" id="startTime"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label"  style="text-align: right">
						    投标结束时间:
					</label>
						<input type="text" name="endTime"  id="endTime"/><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				</div>
				<div class="control-group">
				   <div class="span4">
					<label class="control-label" >
						锁标期:
					</label>
                         <input type="text" name="over_term" id="overTerm"/>天
                   </div>
				   <div class="span4">
					<label class="control-label" style="text-align: right">
						锁标结束时间:
					</label>
                         <input type="text" name="over_time" id="overTime" readonly="true" placeholder="投标结束时间+锁标期"  />
                   </div>
				<!--   <div class="span4">
					<label class="control-label" >
						满标时间:
					</label>
                         <input type="text" name="finishDate"  placeholder="请勿填写" id="finishTime" readonly="true"/>
                    </div>-->
				</div>
               <hr>

				<div class="control-group">
				  <div class="span4">
					<label class="control-label" >
							保障方式:
					</label>
							<select id="ensureType" name="ensureType" >
                                   <c:forEach items="${allEnsureTypeModel}" var="cur">
                                         <option value="${cur.id }">${cur.name }</option>
                                   </c:forEach>
                            </select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
					<label class="control-label" style="text-align: right">
						认证等级:
					</label>
						<select name="authLevel">
							<option value="1">一级</option>
							<option value="2">二级</option>
							<option value="3">三级</option>
							<option value="4">四级</option>
							<option value="5">五级</option>
							<option value="6">六级</option>
							<option value="7">七级</option>
						</select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label" style="text-align: right">
						是否新手推荐:
					</label>
						<select name="releaseStatus">
							<option value="0">否</option>
							<option value="1">是</option>
						</select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>

                </div>

                <div class="control-group">
                  <div class="span4">
                	<label class="control-label" >
                		借款人借款时间:
                	</label>
                		<input type="text" name="borrower_bor_time" id="borrower_bor_time"/><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                  <div class="span4">
                	<label class="control-label" style="text-align: right">
                		借款人还款时间:
                	</label>
                		<input type="text" name="borrower_rep_time" id="borrower_rep_time" placeholder="下一个合约还款日根据借款人实际还款计划表"/><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label" >
						违约金:
					</label>
                         <input type="text" name="odd" id="odd" />%
                    </div>
                </div>
				<div class="control-group">
				  <div class="span4">
					<label class="control-label" >
						借款期限:
					</label>
                         <input type="text" name="loanTerm" id="loanTerm" readonly="true" placeholder="借款人借款时间-借款人还款时间"/>天<span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4" >
					<label class="control-label" style="text-align: right">
						最后一次还款日期:
					</label>
						<input type="text" name="repaymentDate" id="repaymentDate" /><span style="color: Red;font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
					<label class="control-label" >
						管理费:
					</label>
                         <input type="text" name="manage_fee" placeholder="提示根据借款人的信用登记表计算" id="mfee"/>%
                  </div>
				</div>
				<div class="control-group">
				  <div class="span4">
					<label class="control-label" >
						逾期情况:
					</label>
                         <input type="text" name="overdue" />
                    </div>
				  <div class="span4">
					<label class="control-label" >
						交易手续费:
					</label>
                         <input type="text" name="transfer_fee" placeholder="提示根据借款人的信用登记表计算" id="tfee"/>%
                    </div>
				  <div class="span4">
					<label class="control-label" >
						借款类型:
					</label>
 					<select name="approvalStatus">
 							<option value="1">个人借款</option>
 							<option value="2">企业借款</option>
 						</select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				<!--  <div class="span4">
					<label class="control-label" >
						待还本息:
					</label>
                         <input type="text" name="to_pay" placeholder="标的总额*月综合费率*借款期限+标的总额（本金）+平台服务费（管理费和手续费）+违约金（如有)" id="tpay" readonly="true"/>
                  </div>-->
				</div>
				<hr>
				<div class="control-group">
				   <div class="span4">
					<label class="control-label" >
						还款方式:
					</label>
                         <select name="repayType">
                                <option value="1">等额本息</option>
                                <option value="2">等本等息</option>
                         </select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                  <div class="span4">
					<label class="control-label" style="text-align: right">
						风控信息:
					</label>
						<select id="riskInfo" name="riskInfo" >
							<c:forEach items="${allRiskinfoModel}" var="cur">
								<option value="${cur.id }">${cur.id }</option>
							</c:forEach>
						</select><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
					<label class="control-label" >
						添加人:
					</label>
                         <input type="text" name="createBy" />
                    </div>
				</div>
                <div class="control-group">
                  <div class="span4">
					<label class="control-label" for="productDesc">
						标的描述:
					</label>
						<textarea name="productDesc"></textarea><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
				  </div>
				  <div class="span4">
                	<label class="control-label" style="text-align: right">
                		借款用途:
                	</label>
                        <textarea  name="used"></textarea><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
                	<label class="control-label" style="text-align: right">
                		企业借款描述:
                	</label>
                        <textarea  name="attribute1"></textarea><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
                </div>
                <div class="control-group">
                  <div class="span4">
                      <label class="control-label">
                           债权提供方:
                      </label>
                           <textarea name="ascendcompanyidea"></textarea><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>
				  <div class="span4">
					<label class="control-label" style="text-align: right" >
						备注:
					</label>
                         <textarea name="description"></textarea><span style="color: Red; font-size: 10pt; font-weight: bold; font-family: Andalus;">*必填</span>
                  </div>

				</div>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交审核
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
        <script src="/static/js/p2p/product/add.js" type="text/javascript"></script>
	<script type="text/javascript">

	</script>


</body>