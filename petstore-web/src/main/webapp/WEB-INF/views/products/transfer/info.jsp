<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
    <title>债权转让标的信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">

			<fieldset>
				<legend>
					标的债权转让信息
				</legend>
            <table><tr><td>
				<div class="control-group">
					<label class="control-label" for="productName">
						标的名称:${productModel.productName}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label">
						标的类型:<c:forTokens items="${productModel.productTypeCod}" delims="," var="productTypeCod">
							 <c:if test="${productTypeCod=='1'}">信用认证标</c:if>
							 <c:if test="${productTypeCod=='2'}">实地认证标</c:if>
							 <c:if test="${productTypeCod=='3'}">机构担保标</c:if>
							 <c:if test="${productTypeCod=='4'}">债权转让标</c:if>
							 <c:if test="${productTypeCod=='5'}">抵质押标</c:if><p></c:forTokens>
					</label>
				</div>
				<div class="control-group">
				     <label class="control-label">
				        标的种类：<c:if test="${transferModel.type == 'Z'}">债权</c:if>
                                <c:if test="${transferModel.type == 'S'}">散标</c:if>
                                <c:if test="${transferModel.type == 'U'}">U计划</c:if>
				     </label>
				</div>
				<div class="control-group">
					<label class="control-label" for="productTypeCod">
						发布类型:<c:if test="${transferModel.publishType == '1'}">预发布</c:if>
						<c:if test="${transferModel.publishType == '2'}">即时发布</c:if>
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="productTypeCod">
						预发布时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                        value="${transferModel.preTime}"/>
					</label>
				</div>

				<div class="control-group">
					<label class="control-label" >
						投标开始时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                        value="${transferModel.startTime}"/>
					</label>
				</div>
				<div class="control-group">
                    <label class="control-label" >
                         投标结束时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                          value="${transferModel.endTime}"/>
                    </label>
                </div>
				<div class="control-group">
                    <label class="control-label" >
                         锁标期:${transferModel.over_term}天
                    </label>
                </div>
				<div class="control-group">
                    <label class="control-label" >
                         锁标结束时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                          value="${transferModel.over_time}"/>
                    </label>
                </div>
 				<div class="control-group">
                     <label class="control-label" >
                          满标时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                          value="${transferModel.finishTime}"/>
                     </label>
                 </div></td>
				<td><div class="control-group">
                	<label class="control-label" for="yearRate">
                		年化收益:${productModel.yearRate} %
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label" >
                		应付收益总额:${transferModel.profitMoney}元
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		应付收益时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                        value="${transferModel.profitTime}"/>
                	</label>
                </div>
				<div class="control-group">
					<label class="control-label" >
						代理商:${agentModel.name}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" id="buyType" >
						购买方式:<c:if test="${productModel.buyType == '1'}">按份</c:if>
						<c:if test="${productModel.buyType == '2'}">按金额</c:if>
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" id="t1" >
						标的总额:${productModel.totalMoney}  元
					</label>
				</div>
               <div class="control-group">
                     <label class="control-label" for="minimumInvestment" id="t2">
                          最小投资金额:${productModel.minimumInvestment}  元
                     </label>
                </div>
                <div class="control-group">
 					<label class="control-label">
 						剩余总额:${realStockModel.left_amount} 元
 					</label>
 				</div>
				<div class="control-group">
					<label class="control-label" style="display:none;" id="p1">
						标的总份:${transferModel.productTotal}
					</label>
				</div>
				<div class="control-group">
                	<label class="control-label" style="display:none;" id="p2" >
                		每份价值:${transferModel.perValue} 元
                	</label>
                </div></td><td>
				<div class="control-group">
					  <label class="control-label" >
							保障方式:${ensureTypeModel.name}
					  </label>
				</div>
				<div class="control-group">
					  <label class="control-label" >
							认证等级:<c:if test="${transferModel.authLevel == '1'}">一级</c:if>
							<c:if test="${transferModel.authLevel == '2'}">二级</c:if>
							<c:if test="${transferModel.authLevel == '3'}">三级</c:if>
							<c:if test="${transferModel.authLevel == '4'}">四级</c:if>
							<c:if test="${transferModel.authLevel == '5'}">五级</c:if>
							<c:if test="${transferModel.authLevel == '6'}">六级</c:if>
					  </label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						借款人借款时间:${productModel.borrower_bor_time}
					</label>
				</div>
				<div class="control-group">
                    <label class="control-label" >
                        借款人还款时间:${productModel.borrower_rep_time}
                    </label>
                </div>
				<div class="control-group">
					<label class="control-label" >
						借款期限:${transferModel.loanTerm} 天
					</label>
				</div>
            	<div class="control-group">
					<label class="control-label" >
						最后一次还款日期:${productModel.repaymentDate}
					</label>
				</div>
				<div class="control-group">
					 <label class="control-label" >
							逾期情况:${transferModel.overdue}
					 </label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						月综合费率:${transferModel.month_rate}%
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						交易手续费:${transferModel.transfer_fee}%
					</label>
				</div>
            	<div class="control-group">
					<label class="control-label" >
						管理费:${transferModel.manage_fee}%
					</label>
				</div>
				<div class="control-group">
					 <label class="control-label" >
							违约金:${transferModel.odd}%
					 </label>
				</div>
				<div class="control-group">
					 <label class="control-label" >
							待还本息:${transferModel.to_pay}元
					 </label>
				</div>


				</td><td>
				<div class="control-group">
					 <label class="control-label" >
						  还款方式:<c:if test="${transferModel.repayType == '1'}">等额本息</c:if>
						  <c:if test="${transferModel.repayType == '2'}">等本等息</c:if>
					 </label>
				</div>
				<div class="control-group">
					 <label class="control-label" >
							风控信息:${riskInfoModel.id}
					</label>
				</div>
               <div class="control-group">
					<label class="control-label" for="productDesc">
						标的描述:${productModel.productDesc}
					</label>
				</div>
				<div class="control-group">
                	<label class="control-label" for="used">
                		借款用途:${productModel.used}
                	</label>

                </div>
                <div class="control-group">
                     <label class="control-label" for="ascendcompanyidea">
                          公司描述:${productModel.ascendcompanyidea}
                     </label>
                </div>
				<div class="control-group">
					<label class="control-label" >
						  备注:${transferModel.description}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						  添加人:${transferModel.createBy}
					</label>
				</div>
				<div class="control-group">
                	<label class="control-label" for="used">
                		审核人:${transferModel.verify_user}
                	</label>

                </div>
                <div class="control-group">
                     <label class="control-label" for="ascendcompanyidea">
                          审核时间:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                         value="${transferModel.verify_time}"/>
                     </label>
                </div>
				<div class="control-group">
					<label class="control-label" >
						  审核意见:${productModel.approval_opinion}
					</label>

				</div>

				</td>

		      </tr></table>



			</fieldset>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#registerDate').datepicker({
				format:'yyyy-mm-dd'
			});
			showCont();
		});

		   function showCont(){
		     var buyType = ${productModel.buyType};
             switch(buyType){
                case "1":
                    $("#p1").hide();
                    $("#p2").hide();
                    $("#t1").show();
                    $("#t2").show();
                    break;
                case "2":
                    $("#t1").hide();
                    $("#t2").hide();
                    $("#p1").show();
                    $("#p2").show();
                    break;
                default:
                    break;
             }
          }
	</script>
</body>