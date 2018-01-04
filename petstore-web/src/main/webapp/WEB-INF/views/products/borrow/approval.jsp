<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>借款人详细信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">

			<fieldset>
				<legend>
					借款人详细信息
				</legend>
            <table><tr><td>
				<div class="control-group">
					<label class="control-label">
						借款客户:${userInfoModel.name}
					</label>
				</div>
				<div class="control-group">
					<label class="control-label">
						借款期限:${borrowModel.borrow_term}个月
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
						借款状态:${borrowModel.deal_status}
					</label>
				</div>
				<div class="control-group">
                    <label class="control-label" >
                         身份证号:${userInfoModel.idcard}
                    </label>
                </div>
				<div class="control-group">
                    <label class="control-label" >
                         性别:					<c:choose>
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
                </div>
 				<div class="control-group">
                     <label class="control-label" >
                          电话号:${userInfoModel.mobilephone}
                     </label>
                 </div>
                 <div class="control-group">
                      <label class="control-label" >
                          手机号:${userInfoModel.telephone}
                      </label>
                 </div><div class="control-group">
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
                </div><hr>
				<div class="control-group">
                	<label class="control-label">
                		最高学历:${riskInfoModel.education}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		籍贯:${riskInfoModel.hometown}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		户口所在地:${riskInfoModel.hkszd}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		居住地址:${riskInfoModel.jzdz}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		居住地邮编:${riskInfoModel.jzdyb}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		居住地电话:${riskInfoModel.jzddh}
                	</label>
                </div>
			    </td>
			    <td>
				<div class="control-group">
                	<label class="control-label">
                		婚姻状况:<c:if test="${riskInfoModel.hyzk == 1}">已婚</c:if>
                		<c:if test="${riskInfoModel.hyzk == 2}">未婚</c:if>
                		<c:if test="${riskInfoModel.hyzk == 3}">离异</c:if>
                		<c:if test="${riskInfoModel.hyzk == 4}">丧偶</c:if>
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		有无子女:
                		<c:if test="${riskInfoModel.ywzn == 1}">有</c:if>
                		<c:if test="${riskInfoModel.ywzn == 2}">无</c:if>
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		直系亲属: 姓名:${riskInfoModel.zxqsxm} 关系：${riskInfoModel.zxqsgx} 手机：${riskInfoModel.zxqssj}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		其他联系人: 姓名:${riskInfoModel.qtlxrxm}关系：${riskInfoModel.qtlxrgx} 手机：${riskInfoModel.qtlxrsj}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		职业状态:${riskInfoModel.zyzt}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		单位名称:${riskInfoModel.dwmc}
                	</label>
                </div>

				<div class="control-group">
                	<label class="control-label">
                		职位：${riskInfoModel.zw}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		月收入：${riskInfoModel.ysr}
                	</label>
                </div>
			<div class="control-group">
                	<label class="control-label">
                		工作邮箱:${riskInfoModel.gzyx}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		工作城市:${riskInfoModel.gzcs}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		公司地址：${riskInfoModel.gsdz}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		公司类别：${riskInfoModel.gslb}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		公司行业:${riskInfoModel.gshy}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		公司规模：${riskInfoModel.gsgm}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		在现单位工作年限：${riskInfoModel.zxdwgznx}年
                	</label>
                </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		公司电话：${riskInfoModel.gsdh}
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		房产信息:  是否有房：
                 		<c:if test="${riskInfoModel.sfyf == 1}">有</c:if>
                 		<c:if test="${riskInfoModel.sfyf == 2}">无</c:if>
                 		是否有房贷：
                 		<c:if test="${riskInfoModel.ywfd == 1}">有</c:if>
                 		<c:if test="${riskInfoModel.ywfd == 2}">无</c:if>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		车产信息：是否有车：
                 		<c:if test="${riskInfoModel.sfyc == 1}">有</c:if>
                 		<c:if test="${riskInfoModel.sfyc == 2}">无</c:if>
                 	</label>
                 </div>
			<form:form id="queryObjectForm" cssClass="form-inline"
                    						modelAttribute="riskInfoModel" action="/shcl/approval"
                    						method="POST">
                </td><td>
 				<div class="control-group">
                 	<label class="control-label">
                 		身份认证：<c:forTokens items="${shcl1.picId}" delims="," var="cur" varStatus="sta">
                            <a href="/borrow/${cur}/show">${cur}
                 		</c:forTokens>
                 		</a><input type="hidden" name="picId" id="picId" value="${riskInfoModel.sfrz}">  审批意见:${shcl1.shyj}审批结果：<c:if test="${shcl1.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl1.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl1.shzt ==3}">待审核</c:if><br> <textarea name="shyj" id="shyj"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId','shyj')" id="bu1">
                                                                                             通过
                                                                                            </button>
                                                                                    <button type="button" class="btn btn-primary" onclick="reject('picId','shyj')" id="bub1">不通过</button>
                                                                                    <button type="button" class="btn btn-primary" onclick="wait('picId','shyj')" id="bud1">待审核</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		工作认证：<c:forTokens items="${shcl2.picId}" delims="," var="cur">
                                                      <a href="/borrow/${cur}/show">${cur}
                                              		</c:forTokens>
                 		 </a> <input type="hidden" name="picId" id="picId1" value="${riskInfoModel.gzrz}">    审批意见:${shcl2.shyj}
审批结果：<c:if test="${shcl2.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl2.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl2.shzt ==3}">待审核</c:if>
                 		 <br> <textarea name="shyj" id="shyj1"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId1','shyj1')" id="bu2">
                                                                                                                                                通过
                                                                                                                                               </button>
                                                                                  <button type="button" class="btn btn-primary" onclick="reject('picId1','shyj1')" id="bub2">不通过</button>
                                                                                  <button type="button" class="btn btn-primary" onclick="wait('picId1','shyj1')" id="bud2">待审核</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">

                 		信用认证：<c:forTokens items="${shcl3.picId}" delims="," var="cur">
                                                         <a href="/borrow/${cur}/show">${cur}
                                </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId2" value="${riskInfoModel.xyrz}">    审批意见:${shcl3.shyj}
审批结果：<c:if test="${shcl3.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl3.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl3.shzt ==3}">待审核</c:if>
                 		<br> <textarea name="shyj" id="shyj2"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId2','shyj2')" id="bu3">
                                                                                                                                                                                                   通过
                                                                                                                                                                                                  </button>
                                                                                                                                     <button type="button" class="btn btn-primary" onclick="reject('picId2','shyj2')" id="bub3">不通过</button>
                                                                                                                                      <button type="button" class="btn btn-primary" onclick="wait('picId2','shyj2')" id="bud3">待审核</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		收入认证：<c:forTokens items="${shcl4.picId}" delims="," var="cur">
                                                                                      <a href="/borrow/${cur}/show">${cur}
                                   </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId3" value="${riskInfoModel.srrz}">    审批意见:${shcl4.shyj}
 审批结果：<c:if test="${shcl4.shzt ==1}">通过</c:if>
                                                                                                          <c:if test="${shcl4.shzt ==2}">不通过</c:if>
                                                                                                          <c:if test="${shcl4.shzt ==3}">待审核</c:if>
                 		<br> <textarea name="shyj" id="shyj3"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId3','shyj3')" id="bu4">
                                                                                                                                                  通过
                                                                                                                                         </button>
                                                                                                         <button type="button" class="btn btn-primary" onclick="reject('picId3','shyj3')" id="bub4">不通过</button>
                                                                                                          <button type="button" class="btn btn-primary" onclick="wait('picId3','shyj3')" id="bud4">待审核</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		房产认证：<c:forTokens items="${shcl5.picId}" delims="," var="cur">
                                                                                                                   <a href="/borrow/${cur}/show">${cur}
                                                                </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId4" value="${riskInfoModel.fcrz}">    审批意见:${shcl5.shyj}
审批结果：<c:if test="${shcl5.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl5.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl5.shzt ==3}">待审核</c:if>
                 		<br> <textarea name="shyj" id="shyj4"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId4','shyj4')" id="bu5">
                                                                                                                                                                                                                                  通过
                                                                                                                                                                                         </button>
                                                                                                           <button type="button" class="btn btn-primary" onclick="reject('picId4','shyj4')" id="bub5">不通过</button>
                                                                                                            <button type="button" class="btn btn-primary" onclick="wait('picId4','shyj4')" id="bud5">待审核</button>
                 	</label>
                 </div></td><td>
				<div class="control-group">
                 	<label class="control-label">
                 		购车认证：<c:forTokens items="${shcl6.picId}" delims="," var="cur">
                                                                                                                   <a href="/borrow/${cur}/show">${cur}
                                                                </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId5" value="${riskInfoModel.gcrz}">  审批意见:${shcl6.shyj}
审批结果：<c:if test="${shcl6.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl6.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl6.shzt ==3}">待审核</c:if>
                 		<br> <textarea name="shyj" id="shyj5"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId5','shyj5')" id="bu6">
                                                                                                                                                                                                        通过
                                                                                                                                                                                                </button>
                                                                                                <button type="button" class="btn btn-primary" onclick="reject('picId5','shyj5')" id="bub6">不通过</button>
                                                                                                 <button type="button" class="btn btn-primary" onclick="wait('picId5','shyj5')" id="bud6">待审核</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		结婚认证：<c:forTokens items="${shcl7.picId}" delims="," var="cur">
                                                                                                                                                <a href="/borrow/${cur}/show">${cur}
                                                                                             </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId6" value="${riskInfoModel.jhrz}">  审批意见:${shcl7.shyj}
审批结果：<c:if test="${shcl7.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl7.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl7.shzt ==3}">待审核</c:if>
                 		<br> <textarea name="shyj" id="shyj6"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId6','shyj6')" id="bu7">
                                                                                                                                                                                                                                                                                                                                              通过
                                                                                                                                                                                                                                                                                                                                      </button>
                                                                                                <button type="button" class="btn btn-primary" onclick="reject('picId6','shyj6')" id="bub7">不通过</button>
                                                                                                 <button type="button" class="btn btn-primary" onclick="wait('picId6','shyj6')" id="bud7">待审核</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		学历认证：<c:forTokens items="${shcl8.picId}" delims="," var="cur">
                                                                                                                                                <a href="/borrow/${cur}/show">${cur}
                                                                                             </c:forTokens>
                 		</a><input type="hidden" name="picId" id="picId7" value="${riskInfoModel.xlrz}"> 审批意见:${shcl8.shyj}
审批结果：<c:if test="${shcl8.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl8.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl8.shzt ==3}">待审核</c:if>
                 		<br> <textarea name="shyj" id="shyj7"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId7','shyj7')" id="bu8">
                                                                                                                                                                                                                                                                                                                                        通过
                                                                                                                                                                                                                                                                                                                                </button>
                                                                                                 <button type="button" class="btn btn-primary" onclick="reject('picId7','shyj7')" id="bub8">不通过</button>
                                                                                                  <button type="button" class="btn btn-primary" onclick="wait('picId7','shyj7')" id="bud8">待审核</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		职称认证：<c:forTokens items="${shcl9.picId}" delims="," var="cur">
                                                                                                                                                <a href="/borrow/${cur}/show">${cur}
                                                                                             </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId8" value="${riskInfoModel.zcrz}">审批意见:${shcl9.shyj}
审批结果：<c:if test="${shcl9.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl9.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl9.shzt ==3}">待审核</c:if>
                 		<br> <textarea name="shyj" id="shyj8"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId8','shyj8')" id="bu9">
                                                                                                                                                                  通过
                                                                                                                                                                                                                                      </button>
                                                                                                 <button type="button" class="btn btn-primary" onclick="reject('picId8','shyj8')" id="bub9">不通过</button>
                                                                                                  <button type="button" class="btn btn-primary" onclick="wait('picId8','shyj8')" id="bud9">待审核</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		手机认证：<c:forTokens items="${shcl10.picId}" delims="," var="cur">
                                                                                                                                                <a href="/borrow/${cur}/show">${cur}
                                                                                             </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId9" value="${riskInfoModel.sjrz}">审批意见:${shcl10.shyj}
审批结果：<c:if test="${shcl10.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl10.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl10.shzt ==3}">待审核</c:if>
                 		<br>  <textarea name="shyj" id="shyj9"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId9','shyj9')" id="bu10">
                                                                                                                                                                                                                              通过
                                                                                                                                                                                            </button>
                                                                                                  <button type="button" class="btn btn-primary" onclick="reject('picId9','shyj9')" id="bub10">不通过</button>
                                                                                                   <button type="button" class="btn btn-primary" onclick="wait('picId9','shyj9')" id="bud10">待审核</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		居住认证：<c:forTokens items="${shcl11.picId}" delims="," var="cur">
                                                                                                                                                <a href="/borrow/${cur}/show">${cur}
                                                                                             </c:forTokens>
                 		</a> <input type="hidden" name="picId" id="picId10" value="${riskInfoModel.jzrz}">审批意见:${shcl11.shyj}
审批结果：<c:if test="${shcl11.shzt ==1}">通过</c:if>
                                                                                                         <c:if test="${shcl11.shzt ==2}">不通过</c:if>
                                                                                                         <c:if test="${shcl11.shzt ==3}">待审核</c:if>
                 		<br>   <textarea name="shyj" id="shyj10"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId10','shyj10')" id="bu11">
                                                                                                                                                                                                                                           通过
                                                                                                                                                                                                                                         </button>
                                                                                                   <button type="button" class="btn btn-primary" onclick="reject('picId10','shyj10')" id="bub11">不通过</button>
                                                                                                   <button type="button" class="btn btn-primary" onclick="wait('picId10','shyj10')" id="bud11">待审核</button>
                 	</label>
                 </div>
                 </td>
		      </tr></table>
			</fieldset>
	</div>
	</form:form>
			<form:form id="queryObjectForm" cssClass="form-inline"
                    						modelAttribute="borrowModel" action="/borrow/${borrowModel.id}/approval"
                    						method="POST">
    		                 <div class="span4" >
            					<label class="control-label">
            						风控审核意见:
            					</label>
            						<form:textarea path="fk_opinion"  />
            				</div>
            			</div>
 				<div class="control-group">
 					<label class="control-label"></label>
 					<div class="controls">
 						<button type="submit" class="btn btn-primary">
 							审核完成
 						</button>
 						<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
 					</div>
 				</div>
 			  </fieldset>
             </form:form>
    <script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
 		  var shzt1 = ${shcl1.shzt};
 		  if(shzt1 != null && shzt1=='1'){
 		    $("#bu1").css("display","none");
 		    $("#bub1").css("display","none");
 		    $("#bud1").css("display","none");
 		  }
 		  if(shzt1 !=null && shzt1=='2'){
 		    $("#bub1").css("display","none");
 		  }
 		  if(shzt1 !=null && shzt1=='3'){
 		   $("#bud1").css("display","none");
 		  }
           var shzt2 = ${shcl2.shzt};
 		  if(shzt2 != null && shzt2=='1'){
 		    $("#bu2").css("display","none");
 		    $("#bub2").css("display","none");
 		    $("#bud2").css("display","none");
 		  }
 		  if(shzt2 !=null && shzt2=='2'){
 		    $("#bub2").css("display","none");
 		  }
 		  if(shzt2 !=null && shzt2=='3'){
 		   $("#bud2").css("display","none");
 		  }
           var shzt3 = ${shcl3.shzt};
 		  if(shzt3 != null && shzt3=='1'){
 		    $("#bu3").css("display","none");
 		    $("#bub3").css("display","none");
 		    $("#bud3").css("display","none");
 		  }
 		  if(shzt3 !=null && shzt3=='3'){
 		   $("#bud3").css("display","none");
 		  }
 		  if(shzt3 !=null && shzt3=='2'){
 		    $("#bub3").css("display","none");
 		  }
           var shzt4 = ${shcl4.shzt};
 		  if(shzt4 != null && shzt4=='1'){
 		    $("#bu4").css("display","none");
 		    $("#bub4").css("display","none");
 		    $("#bud4").css("display","none");
 		  }
 		  if(shzt4 !=null && shzt4=='2'){
 		    $("#bub4").css("display","none");
 		  }
 		  if(shzt4 !=null && shzt4=='3'){
 		   $("#bud4").css("display","none");
 		  }
           var shzt5 = ${shcl5.shzt};
 		  if(shzt5 != null && shzt5=='1'){
 		    $("#bu5").css("display","none");
 		    $("#bub5").css("display","none");
 		    $("#bud5").css("display","none");
 		  }
 		  if(shzt5 !=null && shzt5=='2'){
 		    $("#bub5").css("display","none");
 		  }
 		  if(shzt5 !=null && shzt5=='3'){
 		   $("#bud5").css("display","none");
 		  }
           var shzt6 = ${shcl6.shzt};
 		  if(shzt6 != null && shzt6=='1'){
 		    $("#bu6").css("display","none");
 		    $("#bub6").css("display","none");
 		    $("#bud6").css("display","none");
 		  }
 		  if(shzt6 !=null && shzt6=='2'){
 		    $("#bub6").css("display","none");
 		  }
 		  if(shzt6 !=null && shzt6=='3'){
 		   $("#bud6").css("display","none");
 		  }
           var shzt7 = ${shcl7.shzt};
 		  if(shzt7 != null && shzt7=='1'){
 		    $("#bu7").css("display","none");
 		    $("#bub7").css("display","none");
 		    $("#bud7").css("display","none");
 		  }
 		  if(shzt7 !=null && shzt7=='2'){
 		    $("#bub7").css("display","none");
 		  }
 		  if(shzt7 !=null && shzt7=='3'){
 		   $("#bud7").css("display","none");
 		  }
           var shzt8 = ${shcl8.shzt};
 		  if(shzt8 != null && shzt8=='1'){
 		    $("#bu8").css("display","none");
 		    $("#bub8").css("display","none");
 		    $("#bud8").css("display","none");
 		  }
 		  if(shzt8 !=null && shzt8=='2'){
 		    $("#bub8").css("display","none");
 		  }
 		  if(shzt8 !=null && shzt8=='3'){
 		   $("#bud8").css("display","none");
 		  }
           var shzt9 = ${shcl9.shzt};
 		  if(shzt9 != null && shzt9=='1'){
 		    $("#bu9").css("display","none");
 		    $("#bub9").css("display","none");
 		    $("#bud9").css("display","none");
 		  }
 		  if(shzt9 !=null && shzt9=='2'){
 		    $("#bub9").css("display","none");
 		  }
 		  if(shzt9 !=null && shzt9=='3'){
 		   $("#bud9").css("display","none");
 		  }

           var shzt11 = ${shcl11.shzt};
 		  if(shzt11 != null && shzt11=='1'){
 		    $("#bu11").css("display","none");
 		    $("#bub11").css("display","none");
 		    $("#bud11").css("display","none");
 		  }
 		  if(shzt11 !=null && shzt11=='2'){
 		    $("#bub11").css("display","none");
 		  }
 		  if(shzt11 !=null && shzt11=='3'){
 		   $("#bud11").css("display","none");
 		  }
		});
		//通过
        function pass(para,para2){
        if(confirm("确定通过吗？")){
                  var picId = jQuery("#"+para).val();
                      var shyj = jQuery("#"+para2).val();
           			$.ajax( {
           			    url:'/borrow/approvalSh',// 跳转到 action
           			    data:{
           			            picId : picId,
           			             shyj : shyj,
           			             shzt : 1
           			    },
           			    type:'post',
           			    cache:false,
           			    dataType:'json',
           			    success:function(data) {
           			        if(data =="true" ){
           			            alert("审批成功！");
           			            window.location.reload();
           			        }else{
           			            alert("审批成功！");
           			        }
           			    jQuery("#"+para2).attr('disabled',"true");
           		        },
           			     error : function() {
           			          alert("异常！");
           			     }
           			});
           }
        }
        //不通过
        function reject(para,para2){
        if(confirm("确定不通过吗？")){
		   var picId = jQuery("#"+para).val();
		   var shyj = jQuery("#"+para2).val();
			$.ajax( {
			    url:'/borrow/approvalSh',// 跳转到 action
			    data:{
			            picId : picId,
			             shyj : shyj,
			             shzt : 2
			    },
			    type:'post',
			    cache:false,
			    dataType:'json',
			    success:function(data) {
			        if(data.msg =="true" ){
			            alert("审批成功！");
			            window.location.reload();
			        }else{
			            alert("审批成功！");
			        }
			     jQuery("#"+para2).attr('disabled',"true");
		        },
			     error : function() {
			          alert("异常！");
			     }
			});
		  }
        }
		//待审核
        function wait(para,para2){
          if(confirm("确定待审核吗？")){
                      var picId = jQuery("#"+para).val();
                      var shyj = jQuery("#"+para2).val();
           			$.ajax( {
           			    url:'/borrow/approvalSh',// 跳转到 action
           			    data:{
           			            picId : picId,
           			             shyj : shyj,
           			             shzt : 3
           			    },
           			    type:'post',
           			    cache:false,
           			    dataType:'json',
           			    success:function(data) {
           			        if(data =="true" ){
           			            alert("审批成功！");
           			            window.location.reload();
           			        }else{
           			            alert("审批成功！");
           			        }
           			    jQuery("#"+para2).attr('disabled',"true");
           		        },
           			     error : function() {
           			          alert("异常！");
           			     }
           			});
          }
        }
	</script>
</body>