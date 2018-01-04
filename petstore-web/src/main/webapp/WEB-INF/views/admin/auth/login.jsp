<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/static/css/bootstrap/2.3.2/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			body {
				padding-top: 40px;
				padding-bottom: 40px;
				background-color: #f5f5f5;
			}
			
			.form-signin {
				max-width: 300px;
				padding: 19px 29px 29px;
				margin: 0 auto 20px;
				background-color: #fff;
				border: 1px solid #e5e5e5;
				-webkit-border-radius: 5px;
				-moz-border-radius: 5px;
				border-radius: 5px;
				-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
				-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
				box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
			}
			
			.form-signin .form-signin-heading,.form-signin .checkbox {
				margin-bottom: 10px;
			}
			
			.form-signin input[type="text"],.form-signin input[type="password"] {
				font-size: 16px;
				height: auto;
				margin-bottom: 15px;
				padding: 7px 9px;
			}
			.form-signin img {
				height: auto;
				margin-bottom: 15px;
			}
		</style>
		<link href="/static/css/bootstrap/2.3.2/bootstrap-responsive.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">

			<form class="form-signin" action="/j_spring_security_check" method="post">
			                  <a class="brand" href="/login">
                                    <strong><em><font color="blue" size="8">拇指金融</font></em></strong>
                                    <strong><font color="black" size="6">后台管理系统</font></strong>
                                </a>
				<h2 class="form-signin-heading">
					请登录
				</h2>
				<c:if test="${not empty loginErrorModel}">
					<div class="alert">
  						<button type="button" class="close" data-dismiss="alert">&times;</button>
  						<strong>发生错误!</strong>${loginErrorModel} 
					</div>
				</c:if>
				<input type="text" name="j_username" id="username" class="input-block-level"
					placeholder="用户名">
				<input type="password" name="j_password" class="input-block-level"
					placeholder="密码">
				<input type="text" name="j_captcha" class="input-small"
					placeholder="验证码">
				<span style="margin-left:5px">	
					<a href="#" onclick="refreshCaptcha();">
						<img id="captchaImg" src="/img/captcha.jpg" title="点击换一张" />
					</a>
				</span>		
				<label class="checkbox">
					<input type="checkbox" name="_spring_security_remember_me">
					两周之内不必登录
				</label>
				<button class="btn btn-large btn-primary" type="submit">
					登录
				</button>
				<button class="btn btn-large btn-primary" type="reset">
					重置
				</button>
			</form>
		</div>
		
		<!-- le js -->
		<script type="text/javascript" src="/static/js/jquery/jquery.js"></script>
		<script type="text/javascript" src="/static/js/bootstrap/2.3.2/bootstrap-alert.js"></script>
		<script type="text/javascript">
			function refreshCaptcha() {
				$('#captchaImg').hide().attr('src','/img/captcha.jpg?' + Math.floor(Math.random()*100)).fadeIn();
			}
			$(document).ready(function() {
				$("#username").focus();
			});
		</script>
	</body>
</html>