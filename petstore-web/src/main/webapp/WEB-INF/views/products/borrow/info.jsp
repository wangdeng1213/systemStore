<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>借款人详细信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
  <!-- container --> 
  <div class="container-fluid" style="width:1000px; margin:0 auto;"> 
   <div class="row-fluid"> 
    <div class="span12" > 
     <div class="container-fluid"> 
     
      <fieldset> 
      
         <div class="control-group clearfix" style="padding:10px; margin-top:35px;">
          <h2 align="center"><span>风控报告</span></h2>
          <span class="pull-right">
          <style> @media Print { .Noprn { DISPLAY: none }}
                                          </style>
          <button class="Noprn btn btn-success" type="button" onclick="preview();">预览并打印 </button>
          <button type="button" class="Noprn btn btn-success" onclick="history.go(-1)">返回</button></span>
        <h4 class=""><span>基本信息</span></h4>
       </div> 
        
       <table class="table table-striped table-hover">
        <tbody>
        <tr>
          <td >
            <div class="control-group"> 
             <label class="control-label"> 借款客户:${userInfoModel.name} </label>
            </div> </td>
           <td>
            <div class="control-group">
             <label class="control-label"> 借款期限:${borrowModel.borrow_term}个月 </label>
            </div></td>
           <td>
            <div class="control-group">
             <label class="control-label"> 借款金额：${borrowModel.borrow_money}元 </label>
            </div></td>
           <td>
            <div class="control-group">
             <label class="control-label"> 借款标题:${borrowModel.borrow_title} </label>
            </div></td>

            </tr>
        <tr>
        <td>
            <div class="control-group">
             <label class="control-label"> 出生日期:${userInfoModel.birthday} </label>
            </div> </td>
        <td>
        <div class="control-group">
         <label class="control-label"> 身份证号:${userInfoModel.idcard}</label>
        </div></td><td>
        <div class="control-group">
         <label class="control-label"> 性别:
                  <c:choose>
                      <c:when test="${userInfoModel.sex == 2}">
                         <span>女</span>
                      </c:when>
                      <c:otherwise>
                         <span>男</span>
                      </c:otherwise>
                  </c:choose> </label>
        </div></td><td>
        <div class="control-group">
         <label class="control-label"> 地址:${userInfoModel.address} </label>
        </div></td>
            </tr>
        <tr>
        <td>
        <div class="control-group"> 
         <label class="control-label"> 电话号:${userInfoModel.mobilephone} </label>
        </div></td><td>
        <div class="control-group"> 
         <label class="control-label"> 手机号:${userInfoModel.telephone} </label>
        </div></td>
        <td>
        <div class="control-group"> 
         <label class="control-label"> EMAIL:${userInfoModel.email}</label>
        </div></td>
        
        <td>
        <div class="control-group"> 
         <label class="control-label"> QQ:${userInfoModel.qq} </label>
        </div></td></tr>

        <tr>
        <td>
            <div class="control-group"> 
             <label class="control-label"> 借款时间:${borrowModel.borrow_time}</label>
            </div></td> 
           <td> 
            <div class="control-group"> 
             <label class="control-label"> 最高学历: ${riskInfoModel.education}</label>
            </div> </td>
            <td>
            <div class="control-group">
             <label class="control-label"> 籍贯: ${riskInfoModel.hometown}</label>
            </div>
            </td>
            <td>
            <div class="control-group">
             <label class="control-label"> 户口所在地: ${riskInfoModel.hkszd}</label>
            </div>
            </td>
          </tr>
          <tr>
            <td>            <div class="control-group">
                             <label class="control-label"> 居住地址: ${riskInfoModel.hkszd}</label>
                            </div></td>
            <td>
           <div class="control-group">
             <label class="control-label"> 居住地邮编: ${riskInfoModel.jzdyb}</label>
            </div>
            </td>
            <td>
           <div class="control-group">
             <label class="control-label"> 居住地电话: ${riskInfoModel.jzddh}</label>
            </div>

            </td>
            <td>
           <div class="control-group">
             <label class="control-label"> 婚姻状况:
                        <c:if test="${riskInfoModel.hyzk == 1}">已婚</c:if>
                 		<c:if test="${riskInfoModel.hyzk == 2}">未婚</c:if>
                 		<c:if test="${riskInfoModel.hyzk == 3}">离异</c:if>
                 		<c:if test="${riskInfoModel.hyzk == 4}">丧偶</c:if>
             </label>
            </div>
            </td>
          </tr>
          <tr>
             <td>
          <div class="control-group">
             <label class="control-label"> 有无子女:
                   		<c:if test="${riskInfoModel.ywzn == 1}">有</c:if>
                        <c:if test="${riskInfoModel.ywzn == 2}">无</c:if>
             </label>
            </div>
             </td>
             <td>
           <div class="control-group">
             <label class="control-label"> 直系亲属姓名: ${riskInfoModel.zxqsxm}</label>
            </div>

             </td>
             <td>
           <div class="control-group">
             <label class="control-label"> 直系亲属关系: ${riskInfoModel.zxqsgx}</label>
            </div>
             </td>
             <td>
           <div class="control-group">
             <label class="control-label"> 直系亲属手机: ${riskInfoModel.zxqssj}</label>
            </div>
             </td>
          </tr>
          <tr>
            <td>           <div class="control-group">
                             <label class="control-label"> 其他联系人姓名: ${riskInfoModel.qtlxrxm}</label>
                            </div>

                             </td>
                             <td>
                           <div class="control-group">
                             <label class="control-label"> 其他联系人关系: ${riskInfoModel.qtlxrgx}</label>
                            </div>
                             </td>
                             <td>
                           <div class="control-group">
                             <label class="control-label"> 其他联系人手机: ${riskInfoModel.qtlxrsj}</label>
                            </div>
                             </td>
            <td>
            <div class="control-group">
              <label class="control-label"> 职业状态: ${riskInfoModel.zyzt}</label>
             </div>
            </td>
          </tr>
          <tr><td>
            <div class="control-group">
              <label class="control-label"> 单位名称: ${riskInfoModel.dwmc}</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 职位: ${riskInfoModel.zw}</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 月收入: ${riskInfoModel.ysr}元</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 工作邮箱: ${riskInfoModel.gzyx}</label>
             </div>
          </td>
          </tr>
          <tr><td>
            <div class="control-group">
              <label class="control-label"> 工作城市: ${riskInfoModel.gzcs}</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 公司地址: ${riskInfoModel.gsdz}</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 公司类别: ${riskInfoModel.gslb}</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 公司行业: ${riskInfoModel.gshy}</label>
             </div>
          </td>
          </tr>
          <tr><td>
            <div class="control-group">
              <label class="control-label"> 公司规模: ${riskInfoModel.gsgm}</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 在现单位工作年限: ${riskInfoModel.zxdwgznx}年</label>
             </div>
          </td>
          <td>
            <div class="control-group">
              <label class="control-label"> 公司电话: ${riskInfoModel.gsdh}</label>
             </div>
          </td>
          <td>
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
          </td>
          </tr>
          <tr>
            <td>
             <div class="control-group">
               <label class="control-label">
                 车产信息：是否有车：
                 		<c:if test="${riskInfoModel.sfyc == 1}">有</c:if>
                 		<c:if test="${riskInfoModel.sfyc == 2}">无</c:if>
               </label>
              </div>
            </td>
         <td>
        <div class="control-group">
         <label class="control-label"> 审核人:${borrowModel.fk_user} </label>
        </div></td><td>
        <div class="control-group">
         <label class="control-label"> 审核意见:${borrowModel.fk_opinion} </label>
        </div></td><td>
        <div class="control-group">
         <label class="control-label"> 审核时间:${borrowModel.fk_time}</label>
        </div></td>
          </tr>
         </tbody>
        </table> 
       </fieldset> 
       
      <div class="control-group clearfix" style="padding:10px;"> 
        <h4 class=""><span class="">认证信息</span></h4>
       </div> 
      <table class="table table-bordered table-hover">
      <tr>
     <div class="control-group"> 
      <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 身份认证</label></td>
      <td><c:forTokens items="${shcl1.picId}" delims="," var="cur">
                                     <img src="/borrow/${cur}/show" ></img>
                           		</c:forTokens>
        <br>审批人:${shcl1.verify_user} 审批日期: ${shcl1.rzrq}  审批意见:${shcl1.shyj}
                                                                                                                                 		审批结果：<c:if test="${shcl1.shzt ==1}">通过</c:if>
                                                                                                                                 		<c:if test="${shcl1.shzt ==2}">不通过</c:if>
                                                                                                                                 		<c:if test="${shcl1.shzt ==3}">待审核</c:if></td>
     </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 工作认证</label> </td>
       <td><c:forTokens items="${shcl2.picId}" delims="," var="cur">
                                                <img src="/borrow/${cur}/show" ></img>
                                      		</c:forTokens> <br>审批人:${shcl2.verify_user} 审批日期: ${shcl2.rzrq} 审批意见:${shcl2.shyj} 审批结果：<c:if test="${shcl2.shzt ==1}">通过</c:if>
                                                                                                                                                                                    <c:if test="${shcl2.shzt ==2}">不通过</c:if>
                                                                                                                                                                                    <c:if test="${shcl2.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
     
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 信用认证</label> </td>
       <td><c:forTokens items="${shcl3.picId}" delims="," var="cur">
                                                <img src="/borrow/${cur}/show" ></img>
                                      		</c:forTokens><br>审批人:${shcl3.verify_user} 审批日期: ${shcl3.rzrq} 审批意见:${shcl3.shyj} 审批结果：<c:if test="${shcl3.shzt ==1}">通过</c:if>
                                                                                                                                                                                   <c:if test="${shcl3.shzt ==2}">不通过</c:if>
                                                                                                                                                                                   <c:if test="${shcl3.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 收入认证</label> </td>
       <td><c:forTokens items="${shcl4.picId}" delims="," var="cur">
                                                <img src="/borrow/${cur}/show"  width="400px" height="500px" ></img>
                                      		</c:forTokens> <br>审批人:${shcl4.verify_user} 审批日期: ${shcl4.rzrq}审批意见:${shcl4.shyj} 审批结果：<c:if test="${shcl4.shzt ==1}">通过</c:if>
                                                                                                                                                                                    <c:if test="${shcl4.shzt ==2}">不通过</c:if>
                                                                                                                                                                                    <c:if test="${shcl4.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 房产认证</label> </td>
       <td><c:forTokens items="${shcl5.picId}" delims="," var="cur">
                                                           <img src="/borrow/${cur}/show" ></img>
                                                 		</c:forTokens> <br>审批人:${shcl5.verify_user} 审批日期: ${shcl5.rzrq}审批意见:${shcl5.shyj} 审批结果：<c:if test="${shcl5.shzt ==1}">通过</c:if>
                                                                                                                                                                                     <c:if test="${shcl5.shzt ==2}">不通过</c:if>
                                                                                                                                                                                     <c:if test="${shcl5.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label">购车认证</label> </td>
       <td><c:forTokens items="${shcl6.picId}" delims="," var="cur">
                                                           <img src="/borrow/${cur}/show" ></img>
                                                 		</c:forTokens> <br>审批人:${shcl6.verify_user} 审批日期: ${shcl6.rzrq}审批意见:${shcl6.shyj} 审批结果：<c:if test="${shcl6.shzt ==1}">通过</c:if>
                                                                                                                                                                                           <c:if test="${shcl6.shzt ==2}">不通过</c:if>
                                                                                                                                                                                           <c:if test="${shcl6.shzt ==3}">待审核</c:if></td>
       </div>
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label">结婚认证</label> </td>
       <td><c:forTokens items="${shcl7.picId}" delims="," var="cur">
                                                           <img src="/borrow/${cur}/show" ></img>
                                                 		</c:forTokens> <br>审批人:${shcl7.verify_user} 审批日期: ${shcl7.rzrq}审批意见:${shcl7.shyj} 审批结果：<c:if test="${shcl7.shzt ==1}">通过</c:if>
                                                                                                                                                                                         <c:if test="${shcl7.shzt ==2}">不通过</c:if>
                                                                                                                                                                                         <c:if test="${shcl7.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 学历认证</label> </td>
       <td><c:forTokens items="${shcl8.picId}" delims="," var="cur">
                                                           <img src="/borrow/${cur}/show" ></img>
                                                 		</c:forTokens> <br>审批人:${shcl8.verify_user} 审批日期: ${shcl8.rzrq}审批意见:${shcl8.shyj} 审批结果：<c:if test="${shcl8.shzt ==1}">通过</c:if>
                                                                                                                                                                                         <c:if test="${shcl8.shzt ==2}">不通过</c:if>
                                                                                                                                                                                         <c:if test="${shcl8.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 职称认证</label> </td>
       <td><c:forTokens items="${shcl9.picId}" delims="," var="cur">
                                                           <img src="/borrow/${cur}/show" ></img>
                                                 		</c:forTokens><br>审批人:${shcl9.verify_user} 审批日期: ${shcl9.rzrq}审批意见:${shcl9.shyj} 审批结果：<c:if test="${shcl9.shzt ==1}">通过</c:if>
                                                                                                                                                                                     <c:if test="${shcl9.shzt ==2}">不通过</c:if>
                                                                                                                                                                                     <c:if test="${shcl9.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 手机认证</label> </td>
       <td><c:forTokens items="${shcl10.picId}" delims="," var="cur">
                                                           <img src="/borrow/${cur}/show" ></img>
                                                 		</c:forTokens> <br>审批人:${shcl10.verify_user} 审批日期: ${shcl10.rzrq}审批意见:${shcl10.shyj} 审批结果：<c:if test="${shcl10.shzt ==1}">通过</c:if>
                                                                                                                                                                                           <c:if test="${shcl10.shzt ==2}">不通过</c:if>
                                                                                                                                                                                           <c:if test="${shcl10.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
      <tr>
     <div class="control-group"> 
        <td style="text-align:center; vertical-align:middle;"><label class="control-label"> 居住认证</label> </td>
       <td><c:forTokens items="${shcl11.picId}" delims="," var="cur">
                                                           <img src="/borrow/${cur}/show" ></img>
                                                 		</c:forTokens> <br>审批人:${shcl11.verify_user} 审批日期: ${shcl11.rzrq}审批意见:${shcl11.shyj} 审批结果：<c:if test="${shcl11.shzt ==1}">通过</c:if>
                                                                                                                                                                                           <c:if test="${shcl11.shzt ==2}">不通过</c:if>
                                                                                                                                                                                           <c:if test="${shcl11.shzt ==3}">待审核</c:if></td>
       </div> 
     </tr>
     
     
   </table>

    </div> 
    </div> 
    <div class="control-group"> 
     <label class="control-label"></label> 
     <style> @media Print { .Noprn { DISPLAY: none }}
                      </style> 
     <div class="Noprn"> 
      <button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button> 
     </div> 
    </div>  
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script> 
    <script type="text/javascript">
		$(document).ready(function(){

		});
		function preview(){
		       window.print();
               window.close();
		}

	</script> 
   </div> 
  </div>  
 </body>
</html>