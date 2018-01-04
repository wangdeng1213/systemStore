<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>新增用户基本信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form id="userInAddObjectForm" cssClass="form-horizontal" modelAttribute="userInfoModel"
			method="POST" action="/user/userinfo/add">
			<fieldset>
				<legend>
					新增用户基本信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
			<!--	<div class="control-group">
					<label class="control-label" for="id">
						主键:
					</label>
					<div class="controls">
						<form:input path="id" placeholder="主键:最少1个字符" />
					</div>
				</div> -->
				<div class="control-group">
					<label class="control-label" for="userName">
						用户名:
					</label>
					<div class="controls">
						<form:input  path="userName" placeholder="用户名:最少2个字符" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">
						密码:
					</label>
					<div class="controls">
						<form:input type="password" path="password" id="password"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="name">
						真实姓名:
					</label>
					<div class="controls">
						<form:input id="name" path="name"/>
					</div>
				</div>
				<div class="control-group">
                	<label class="control-label" for="sex">
                		性别:
                    </label>
                	<div class="controls">
                	    <form:select id="sex" path="sex">
                	        <form:option value="1" select="selected">男</form:option>
                	        <form:option value="2">女</form:option>
                	    </form:select>
                	</div>
                </div>
                <div class="control-group">
                	<label class="control-label" for="idcardType">
                		证件类型:
                	</label>
                	<div class="controls">
                	   <form:select id="idcardtype" path="idcardType">
                	       <form:option value="1" select="selected">身份证</form:option>
                	       <form:option value="2">军官证</form:option>
                	       <form:option value="3">驾驶证</form:option>
                	       <form:option value="4">护照</form:option>
                	       <form:option value="5">港澳通行证</form:option>
                	   </form:select>
                	</div>
                </div>
                <div class="control-group">
                     <label class="control-label" for="idcard">
                        身份证:
                     </label>
                     <div class="controls">
                          <form:input id="idcard" path="idcard" placeholder="身份证" />
                     </div>
                </div>
				<div class="control-group">
					<label class="control-label" for="releDocuments">
						相关证件:
					</label>
					<div class="controls">
						<form:input id="reledocuments" path="releDocuments"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="address">
						地址:
					</label>
					<div class="controls">
						<form:input id="address" path="address" placeholder="地址" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="mobilephone">
						手机:
					</label>
					<div class="controls">
						<form:input id="mobilephone" path="mobilephone" placeholder="手机" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="telephone">
						电话:
					</label>
					<div class="controls">
						<form:input id="telephone" path="telephone" placeholder="电话" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="email">
						EMAIL:
					</label>
					<div class="controls">
						<form:input path="email"  placeholder="邮箱:xxx@xxx.com" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="qq" >
						QQ:
					</label>
					<div class="controls">
						<form:input id="qq" path="qq" placeholder="qq"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="birthday">
						生日:
					</label>
					<div class="controls">
						<form:input id="bir" path="birthday" placeholder="生日" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="actStatus">
						激活状态:
					</label>
					<div class="controls">
						 <form:select id="actStatus" path="actStatus">
                           <form:option value="1" select="selected">是</form:option>
                           <form:option value="0">否</form:option>
                          </form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="phoneAuth">
						手机认证:
					</label>
					<div class="controls">
						<form:input id="phoneauth" path="phoneAuth" placeholder="手机认证" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="idcardAuth">
						身份认证:
					</label>
					<div class="controls">
						<form:input id="idcardauth" path="idcardAuth"  placeholder="身份认证"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="emailAuth">
						邮箱认证:
					</label>
					<div class="controls">
						<form:input id="emailauth" path="emailAuth"  placeholder="邮箱认证" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="updateBy">
						最后修改人:
					</label>
					<div class="controls">
						<form:input id="updateby" path="updateBy" placeholder="最后修改人"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="updateTime">
						最后修改时间:
					</label>
					<div class="controls">
						<form:input id="date" path="updateTime" placeholder="最后修改时间" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="descriptions">
						备注:
					</label>
					<div class="controls">
						<form:input path="descriptions"  placeholder="备注" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="payPassword">
						支付密码:
					</label>
					<div class="controls">
                       <form:input type="password"  path="payPassword" id="paypassword"/>
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