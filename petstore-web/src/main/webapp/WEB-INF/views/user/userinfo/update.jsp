<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>修改用户基本信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="userInfoModel"
				method="PUT" action="/user/userinfo/${id}/update">
			<fieldset>
				<legend>
					修改用户基本信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />
			<table><tr><td>	<div class="control-group">
					<label class="control-label" for="id">
						主键:
					</label>
					<div class="controls">
						<form:input path="id" placeholder="主键:最少1个字符" readonly="true"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="userName">
						用户名:
					</label>
					<div class="controls">
						<form:input path="userName" placeholder="用户名:最少2个字符" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">
						密码:
					</label>
					<div class="controls">
						<form:input type="password" path="password" placeholder="密码" readonly="true"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="name">
						真实姓名:
					</label>
					<div class="controls">
						<form:input  path="name"/>
					</div>
				</div>
				<div class="control-group">
                	<label class="control-label" for="sex">
                		性别:
                    </label>
                	<div class="controls">
                		<form:select path="sex">
                		   <form:option value="1">男</form:option>
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
                                <form:input path="idcard" placeholder="身份证" />
                     </div>
                </div>
				<div class="control-group">
					<label class="control-label" for="releDocuments">
						相关证件:
					</label>
					<div class="controls">
						<form:input path="releDocuments" placeholder="相关证件" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="address">
						地址:
					</label>
					<div class="controls">
						<form:input path="address" placeholder="地址" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="mobilephone">
						手机:
					</label>
					<div class="controls">
						<form:input path="mobilephone" placeholder="手机" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="telephone">
						电话:
					</label>
					<div class="controls">
						<form:input path="telephone" placeholder="电话" />
					</div>
				</div></td><td>
				<div class="control-group">
					<label class="control-label" for="email">
						EMAIL:
					</label>
					<div class="controls">
						<form:input path="email"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						QQ:
					</label>
					<div class="controls">
						<form:input path="qq"/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">
						生日:
					</label>
					<div class="controls">
						<form:input path="birthday" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						激活状态:
					</label>
					<div class="controls">
						<form:select path="actStatus">
						   <form:option value="1">已激活</form:option>
						   <form:option value="0">未激活</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="phoneAuth">
						手机认证:
					</label>
					<div class="controls">
               	   <form:select id="phoneAuth" path="phoneAuth">
                	       <form:option value="1" select="selected">是</form:option>
                	       <form:option value="0">否</form:option>
                	   </form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="idcardAuth">
						身份认证:
					</label>
					<div class="controls">
                	   <form:select id="idcardAuth" path="idcardAuth">
                	       <form:option value="1" select="selected">是</form:option>
                	       <form:option value="0">否</form:option>
                	   </form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="emailAuth">
						邮箱认证:
					</label>
					<div class="controls">
                	   <form:select id="emailAuth" path="emailAuth">
                	       <form:option value="1" select="selected">是</form:option>
                	       <form:option value="0">否</form:option>
                	   </form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="updateBy">
						最后修改人:
					</label>
					<div class="controls">
						<form:input path="updateBy"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="updateTime">
						最后修改时间:
					</label>
					<div class="controls">
						<form:input path="updateTime"  readonly="true"/>
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
						<form:input type="password" path="payPassword"  placeholder="支付密码" readonly="true"/>
					</div>
				</div></td></tr></table>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<button type="button"  class="btn btn-primary" onclick="history.go(-1)">
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
       $('#birthday').datepicker({
            				format:'yyyy-mm-dd'
            			});
      });
	</script>
</body>