<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>借款人详细信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid" style="width:1000px; margin:0 auto;">

			<fieldset>
				<legend>
					    <div class="row-fluid">

					    </div>
					    <div class="row-fluid">

					    </div>
					借款人详细信息
				</legend>
						<div class="control-group  clearfix"  style="padding:10px; margin-top:35px;">
								<div class="control-label" style="text-align: right">
								<style> @media Print { .Noprn { DISPLAY: none }}
                                </style>
								<span class="pull-right">	<button class="Noprn  btn btn-success" type="button" onclick="preview();">
										预览并打印
									</button></span>
								</div>
							</div>
		<div id="info">
            <table  class="table table-striped table-hover"><tr><td>
				<div class="control-group">
					<label class="control-label">
						借款客户:${userInfoModel.name}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label">
						借款期限:${borrowModel.borrow_term}
					</label>
				</div>
				<div class="control-group">
				     <label class="control-label">
				        借款金额：${borrowModel.borrow_money}元
				     </label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						借款标题:${borrowModel.borrow_title}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label">
						借款时间:${borrowModel.borrow_time}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						借款状态:
					</label>
				</div>
				<div class="control-group">
                    <label class="control-label" >
                         身份证号:${userInfoModel.idcard}
                    </label>
                </div>
				<div class="control-group">
                    <label class="control-label" >
                         性别:								<c:choose>
                            									<c:when test="${userInfoModel.sex == 2}">
                            										<span>女</span>
                            									</c:when>
                            									<c:otherwise>
                            										<span>男</span>
                            									</c:otherwise>
                            								</c:choose>

                    </label>
                </div>
				<div class="control-group">
                    <label class="control-label" >
                         地址:${userInfoModel.address}
                    </label>
                </div></td><td>
 				<div class="control-group">
                     <label class="control-label" >
                          电话号:${userInfoModel.mobilephone}
                     </label>
                 </div>
                 <div class="control-group">
                      <label class="control-label" >
                          手机号:${userInfoModel.telephone}
                      </label>
                 </div>
                 <div class="control-group">
                	<label class="control-label">
                		EMAIL:${userInfoModel.email}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label" >
                		QQ:${userInfoModel.qq}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		出生日期:${userInfoModel.birthday}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		审核人:${borrowModel.fk_user}
                	</label>
                </div>
				<div class="control-group">
					<label class="control-label" >
						 审核意见:${borrowModel.fk_opinion}
					</label>
				</div>
				<div class="control-group">
                	<label class="control-label">
                		审核时间:${borrowModel.fk_time}
                	</label>
                </div>
				</td>

			</fieldset>
	     </div>
              <td>
 				<div class="control-group">
                 	<label class="control-label">
                 		身份认证：<img src="/borrow/${riskInfoModel.sfrz}/show" width="400px" height="500px"></img>    审批意见:${shcl1.shyj}
                 		审批结果：<c:if test="${shcl1.shzt ==1}">通过</c:if>
                 		<c:if test="${shcl1.shzt ==2}">不通过</c:if>
                 		<c:if test="${shcl1.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		工作认证：${riskInfoModel.gzrz}   审批意见:${shcl2.shyj} 审批结果：<c:if test="${shcl2.shzt ==1}">通过</c:if>
                                                                                <c:if test="${shcl2.shzt ==2}">不通过</c:if>
                                                                                <c:if test="${shcl2.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		信用认证：${riskInfoModel.xyrz}   审批意见:${shcl3.shyj} 审批结果：<c:if test="${shcl3.shzt ==1}">通过</c:if>
                                                                                      <c:if test="${shcl3.shzt ==2}">不通过</c:if>
                                                                                      <c:if test="${shcl3.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		收入认证：${riskInfoModel.srrz}    审批意见:${shcl4.shyj} 审批结果：<c:if test="${shcl4.shzt ==1}">通过</c:if>
                                                                                       <c:if test="${shcl4.shzt ==2}">不通过</c:if>
                                                                                       <c:if test="${shcl4.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		房产认证：${riskInfoModel.fcrz}     审批意见:${shcl5.shyj} 审批结果：<c:if test="${shcl5.shzt ==1}">通过</c:if>
                                                                                        <c:if test="${shcl5.shzt ==2}">不通过</c:if>
                                                                                        <c:if test="${shcl5.shzt ==3}">待审核</c:if>
                 	</label>
                 </div></td><td>
				<div class="control-group">
                 	<label class="control-label">
                 		购车认证：${riskInfoModel.gcrz}     审批意见:${shcl6.shyj} 审批结果：<c:if test="${shcl6.shzt ==1}">通过</c:if>
                                                                                         <c:if test="${shcl6.shzt ==2}">不通过</c:if>
                                                                                         <c:if test="${shcl6.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		结婚认证：${riskInfoModel.jhrz}    审批意见:${shcl7.shyj} 审批结果：<c:if test="${shcl7.shzt ==1}">通过</c:if>
                                                                                       <c:if test="${shcl7.shzt ==2}">不通过</c:if>
                                                                                       <c:if test="${shcl7.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		学历认证：${riskInfoModel.xlrz}    审批意见:${shcl8.shyj} 审批结果：<c:if test="${shcl8.shzt ==1}">通过</c:if>
                                                                                       <c:if test="${shcl8.shzt ==2}">不通过</c:if>
                                                                                       <c:if test="${shcl8.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		职称认证：${riskInfoModel.zcrz}     审批意见:${shcl9.shyj} 审批结果：<c:if test="${shcl9.shzt ==1}">通过</c:if>
                                                                                        <c:if test="${shcl9.shzt ==2}">不通过</c:if>
                                                                                        <c:if test="${shcl9.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		手机认证：${riskInfoModel.sjrz}     审批意见:${shcl10.shyj} 审批结果：<c:if test="${shcl10.shzt ==1}">通过</c:if>
                                                                                         <c:if test="${shcl10.shzt ==2}">不通过</c:if>
                                                                                         <c:if test="${shcl10.shzt ==3}">待审核</c:if>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		居住认证：${riskInfoModel.jzrz}     审批意见:${shcl11.shyj} 审批结果：<c:if test="${shcl11.shzt ==1}">通过</c:if>
                                                                                         <c:if test="${shcl11.shzt ==2}">不通过</c:if>
                                                                                         <c:if test="${shcl11.shzt ==3}">待审核</c:if>
                 	</label>
                 </div></td></tr></table>
         </div>
			<div class="control-group">
				<label class="control-label"></label>
				<style> @media Print { .Noprn { DISPLAY: none }}
                      </style>
				<div class="Noprn">
					<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
				</div>
			</div>
		  </fieldset>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){

		});
		function preview(){
		       window.print();

		}

	</script>
</body>