<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>债权转让标的信息</title>
</head>
<body>
	<div class="container-fluid">
    		<div class="row-fluid">

              <fieldset>
              <div class="control-group">&nbsp;</div><div class="control-group">&nbsp;</div>
              <table>
                 <tr> <td>

				<div class="control-group">
					<label class="control-label" for="productName">
						标的名称:${productModel.productName}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="productTypeCod">
						标的类型:<c:if test="${productModel.productTypeCod == '1'}">信用认证标</c:if>
						<c:if test="${productModel.productTypeCod == '2'}">实地认证标</c:if>
						<c:if test="${productModel.productTypeCod == '3'}">机构担保标</c:if>
						<c:if test="${productModel.productTypeCod == '4'}">智能理财标</c:if>
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
						预发布时间:${transferModel.preTime}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						投标开始时间:${transferModel.startTime}
					</label>
				</div>
				<div class="control-group">
                    <label class="control-label" >
                         投标结束时间:${transferModel.endTime}
                    </label>
                </div>
 				<div class="control-group" >
                     <label class="control-label" >
                          锁标期:${transferModel.over_term}天
                     </label>
                 </div>
              </div>
 				<div class="control-group">
                     <label class="control-label" >
                          锁标结束时间:${transferModel.over_time}
                     </label>
                 </div>
  				<div class="control-group">
                      <label class="control-label" >
                           满标时间:${transferModel.finishTime}
                      </label>
                  </div>
                  </td>
                  <td>
 				<div class="control-group">
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
                 		应付收益时间:${transferModel.profitTime}
                 	</label>
                 </div>
 				<div class="control-group">
 					<label class="control-label" >
 						代理商:${agentModel.name}
 					</label>
 				</div>
 				 </td></tr><tr>
 				 <td>
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
                 </div>
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
 						借款人借款时间:${productModel.borrower_rep_time}
 					</label>
 				</div>
 				<div class="control-group">
                     <label class="control-label" >
                         借款人还款时间:${productModel.borrower_bor_time}
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
 				</td>
 				<td>
 				<div class="control-group">
 					 <label class="control-label" >
 						  还款方式:<c:if test="${transferModel.repayType == '1'}">等额本息</c:if>
 						  <c:if test="${transferModel.repayType == '2'}">等本等息</c:if>
 					 </label>
 				</div>
 				<div class="control-group">
 					 <label class="control-label" >
 							风控信息:${riskInfoModel}
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

 				</div></td></tr></table>
				<form:form id="queryObjectForm" cssClass="form-inline"
                    						modelAttribute="productModel" action="/product/${productModel.id}/approval"
                    						method="POST">
     		               <div class="control-group">
     		                  <div class="span4">
             					<label class="control-label" for="verify_user">
             						审核人:
             					</label>
             						<form:input path="verify_user"  />
             				 </div>

    		                 <div class="span4" >
            					<label class="control-label" for="approval_opinion">
            						审批意见:
            					</label>
            						<form:textarea path="approval_opinion"  />
            				</div>
            			</div>
            				<div class="control-group">
                                  <div class="controls">
                                       <form:radiobutton path="statusCode" value="-1" checked="checked" />审批通过
                                       <form:radiobutton path="statusCode" value="21"/>驳回
                                  </div>
                            </div>
 				<div class="control-group">
 					<label class="control-label"></label>
 					<div class="controls">
 						<button type="submit" class="btn btn-primary">
 							确认
 						</button>
 						<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
 					</div>
 				</div>
 			  </fieldset>
             </form:form>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
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