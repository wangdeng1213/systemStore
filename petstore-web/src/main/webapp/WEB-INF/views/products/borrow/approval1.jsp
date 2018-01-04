<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="auth" tagdir="/WEB-INF/tags/auth"%>
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
                         性别:${userInfoModel.sex}
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
                		婚姻状况:${riskInfoModel.hyzk}
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label">
                		有无子女:${riskInfoModel.ywzn}
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
                		在现单位工作年限：${riskInfoModel.zxdwgznx}
                	</label>
                </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		公司电话：${riskInfoModel.gsdh}
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		房产信息:  是否有房：${riskInfoModel.sfyf}是否有房贷：${riskInfoModel.ywfd}
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		车产信息：是否有车：${riskInfoModel.sfyc}
                 	</label>
                 </div>
			<form:form id="queryObjectForm" cssClass="form-inline"
                    						modelAttribute="riskInfoModel" action="/shcl/approval"
                    						method="POST">
                </td><td>
 				<div class="control-group">
                 	<label class="control-label">
                 		身份认证：${riskInfoModel.sfrz}<input type="hidden" name="picId" id="picId" value="${riskInfoModel.sfrz}">    审批意见: <textarea name="shyj" id="shyj"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId','shyj')">
                                                                                             通过
                                                                                            </button>
                                                                                    <button type="button" class="btn btn-primary" onclick="reject('picId','shyj')">驳回</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		工作认证：${riskInfoModel.gzrz} <input type="hidden" name="picId" id="picId1" value="${riskInfoModel.gzrz}">    审批意见: <textarea name="shyj" id="shyj1"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId1','shyj1')">
                                                                                                                                                通过
                                                                                                                                               </button>
                                                                                  <button type="button" class="btn btn-primary" onclick="reject('picId1','shyj1')">驳回</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		信用认证：${riskInfoModel.xyrz} <input type="hidden" name="picId" id="picId2" value="${riskInfoModel.xyrz}">    审批意见: <textarea name="shyj" id="shyj2"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId2','shyj2')">
                                                                                                                                                                                                   通过
                                                                                                                                                                                                  </button>
                                                                                                                                     <button type="button" class="btn btn-primary" onclick="reject('picId2','shyj2')">驳回</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		收入认证：${riskInfoModel.srrz}<input type="hidden" name="picId" id="picId3" value="${riskInfoModel.srrz}">    审批意见: <textarea name="shyj" id="shyj3"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId3','shyj3')">
                                                                                                                                                  通过
                                                                                                                                         </button>
                                                                                                         <button type="button" class="btn btn-primary" onclick="reject('picId3','shyj3')">驳回</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		房产认证：${riskInfoModel.fcrz}<input type="hidden" name="picId" id="picId4" value="${riskInfoModel.fcrz}">    审批意见: <textarea name="shyj" id="shyj4"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId4','shyj4')">
                                                                                                                                                                                                                                  通过
                                                                                                                                                                                         </button>
                                                                                                                                                                                       <button type="button" class="btn btn-primary" onclick="reject('picId4','shyj4')">驳回</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		购车认证：${riskInfoModel.gcrz} <input type="hidden" name="picId" id="picId5" value="${riskInfoModel.gcrz}">  审批意见: <textarea name="shyj" id="shyj5"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId5','shyj5')">
                                                                                                                                                                                                        通过
                                                                                                                                                                                                </button>
                                                                                                <button type="button" class="btn btn-primary" onclick="reject('picId5','shyj5')">驳回</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		结婚认证：${riskInfoModel.jhrz} <input type="hidden" name="picId" id="picId6" value="${riskInfoModel.jhrz}">  审批意见: <textarea name="shyj" id="shyj6"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId6','shyj6')">
                                                                                                                                                                                                                                                                                                                                              通过
                                                                                                                                                                                                                                                                                                                                      </button>
                                                                                                                                                              <button type="button" class="btn btn-primary" onclick="reject('picId6','shyj6')">驳回</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		学历认证：${riskInfoModel.xlrz} <input type="hidden" name="picId" id="picId7" value="${riskInfoModel.xlrz}"> 审批意见: <textarea name="shyj" id="shyj7"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId7','shyj7')">
                                                                                                                                                                                                                                                                                                                                        通过
                                                                                                                                                                                                                                                                                                                                </button>
                                                                                                                                                           <button type="button" class="btn btn-primary" onclick="reject('picId7','shyj7')">驳回</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		职称认证：${riskInfoModel.zcrz} <input type="hidden" name="picId" id="picId8" value="${riskInfoModel.zcrz}">审批意见: <textarea name="shyj" id="shyj8"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId8','shyj8')">
                                                                                                                                                                  通过
                                                                                                                                                                                                                                      </button>
                                                                                                                                    <button type="button" class="btn btn-primary" onclick="reject('picId8','shyj8')">驳回</button>
                 	</label>
                 </div>
 				<div class="control-group">
                 	<label class="control-label">
                 		手机认证：${riskInfoModel.sjrz} <input type="hidden" name="picId" id="picId9" value="${riskInfoModel.sjrz}">审批意见:  <textarea name="shyj" id="shyj9"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId9','shyj9')">
                                                                                                                                                                                                                              通过
                                                                                                                                                                                            </button>
                                                                                                                                   <button type="button" class="btn btn-primary" onclick="reject('picId9','shyj9')">驳回</button>
                 	</label>
                 </div>
				<div class="control-group">
                 	<label class="control-label">
                 		居住认证：${riskInfoModel.jzrz}<input type="hidden" name="picId" id="picId10" value="${riskInfoModel.jzrz}">审批意见:   <textarea name="shyj" id="shyj10"></textarea> <button type="button" class="btn btn-primary" onclick="pass('picId10','shyj10')" >
                                                                                                                                                                                                                                           通过
                                                                                                                                                                                                                                         </button>
                                                                                                                                     <button type="button" class="btn btn-primary" onclick="reject('picId10','shyj10')">驳回</button>
                 	</label>
                 </div>
                 </td>
		      </tr></table>
			</fieldset>
	</div>
	</form:form>
			<form:form id="queryObjectForm" cssClass="form-inline"
                    						modelAttribute="borrowModel" action="/borrow/${borrowModel.borrow_tran_id}/approval"
                    						method="POST">

     		               <div class="control-group">
     		                  <div class="span4">
             					<label class="control-label">
             						角色类型:
             					</label>
                                <input type="hidden" name="taskId" value="riskControlAudit"></input>
             					 <c:if test="<auth:roles user='${cur}'/>==riskControlPass"/>
             						<form:input path="type" name="riskControlPass"/></c:if>
             					 <c:if test="<auth:roles user='${cur}'/>==presidentControlPass"/>
                                    <form:input path="type" name="presidentControlPass"/></c:if>
             				 </div>

    		                 <div class="span4" >
            					<label class="control-label" for="approval_opinion">
            						审批意见:
            					</label>
            						<form:textarea path="opinion"  />
            				</div>
            			</div>
            				<div class="control-group">
                                  <div class="controls">
                                       <form:radiobutton path="applyResult" value="true" checked="checked" />审批通过
                                       <form:radiobutton path="applyResult" value="false"/>驳回
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
    <script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){

		});
		//通过
        function pass(para,para2){
           var picId = jQuery("#"+para).val();
           alert(picId);
           var shyj = jQuery("#"+para2).val();
           alert(shyj);
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
        //驳回
        function reject(para,para2){
		   var picId = jQuery("#"+para).val();
		   alert(picId);
		   var shyj = jQuery("#"+para2).val();
		   alert(shyj);
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
			            alert("提交成功！");
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
	</script>
</body>