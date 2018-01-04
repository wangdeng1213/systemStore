<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>用户基本信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form id="userInAddObjectForm" cssClass="form-horizontal" modelAttribute="userInfoModel"
			method="POST" action="/user/userinfo/add">
			<fieldset>
				<legend>
					用户基本信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
			<!--	<div class="control-group">
					<label class="control-label" for="id">
						主键:
					</label>
				</div> -->
				<div class="control-group">
					<label class="control-label" for="userName">
						用户名: ${userInfoModel.userName}
					</label>
				</div>

				<div class="control-group">
					<label class="control-label" for="name">
						真实姓名:${userInfoModel.name}
					</label>
				</div>
				<div class="control-group">
                	<label class="control-label" for="sex">
                		性别:
                                <c:choose>
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
                	<label class="control-label" for="idcardType">
                		证件类型:
                             <c:choose>
									<c:when test="${userInfoModel.idcardType == 1}">
										<span>身份证</span>
									</c:when>
									<c:otherwise>
										<span>港澳台通行证</span>
									</c:otherwise>
								</c:choose>

                	</label>
                </div>
                <div class="control-group">
                     <label class="control-label" for="idcard">
                        身份证: ${userInfoModel.idcard}
                     </label>

                </div>
				<div class="control-group">
					<label class="control-label" for="releDocuments">
						相关证件:${userInfoModel.releDocuments}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="address">
						地址: ${userInfoModel.address}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="mobilephone">
						手机:  ${userInfoModel.mobilephone}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="telephone">
						电话:${userInfoModel.telephone}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="email">
						EMAIL:${userInfoModel.email}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="qq" >
						QQ:${userInfoModel.qq}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="birthday">
						生日:${userInfoModel.birthday}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="actStatus">
						激活状态:
	                           <c:choose>
									<c:when test="${userInfoModel.actStatus == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose>
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="phoneAuth">
						手机认证:
                             <c:choose>
									<c:when test="${userInfoModel.phoneAuth == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
							 </c:choose>
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="idcardAuth">
						身份认证:
                              <c:choose>
									<c:when test="${userInfoModel.idcardAuth == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
							 </c:choose>
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="emailAuth">
						邮箱认证:
                              <c:choose>
									<c:when test="${userInfoModel.emailAuth == 1}">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
							  </c:choose>
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="updateBy">
						最后修改人:${userInfoModel.updateBy}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="updateTime">
						最后修改时间:${userInfoModel.updateTime}
					</label>

				</div>
				<div class="control-group">
					<label class="control-label" for="descriptions">
						备注:${userInfoModel.descriptions}
					</label>
				</div>
			</fieldset>
		</form:form>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
          $(document).ready(function(){
                 $("#userInAddObjectForm").validate({
                         rules:{
                      userName:"required",
                      password:{
                       required: true,
                       minlength: 5,
                       maxlength: 8
                       },
                      name:"required",
                      idcard:{
                      required: true,
                      minlength: 18,
                      maxlength: 18
                      },
                      address: "required",
                      mobilephone: {
                      required: true,
                      digits: true,
                      minlength: 8,
                      maxlength: 11
                      },
                      email: {
                      email: true
                      },
                      qq: {
                      digits: true
                      },
                      birthday: "required",
                      payPassword: {
                      required: true,
                      minlength: 5,
                      maxlength: 8
                      }
                         },
                         messages:{
                      userName: "请输入姓名",
                      password: {
                       required: "请输入密码",
                       minlength: jQuery.format("密码不能小于{0}个字符"),
                       maxlength: jQuery.format("密码不能大于{0}个字符")
                      },
                      name: "请输入真实姓名",
                      idcard:{
                       required: "请输入身份证号",
                       minlength: jQuery.format("身份证号不能小于{0}个字符"),
                       maxlength: jQuery.format("身份证号不能大于{0}个字符")
                      },
                      address: "请输入地址",
                      mobilephone: {
                      required: "请输入手机号",
                      digits: "请输入数字",
                       minlength: jQuery.format("手机号不能小于{0}个数字"),
                       maxlength: jQuery.format("手机号不能大于{0}个数字")

                      },
                      email: "请输入正确的EMAIL邮箱",
                      qq: "请输入正确的qq号",
                      birthday: "请输入生日",
                      payPassword: {
                       required: "请输入支付密码",
                       minlength: jQuery.format("支付密码不能小于{0}个字符"),
                       maxlength: jQuery.format("支付密码不能大于{0}个字符")
                      }
                         }
                    });
                     $('#date').datepicker({
                        	format:'yyyy-mm-dd'
                   });
                     $('#bir').datepicker({
                                           	format:'yyyy-mm-dd'
                    });

           });
	</script>
</body>