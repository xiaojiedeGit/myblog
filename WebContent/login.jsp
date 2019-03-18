<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="${ctx}/css/style.css">
<script type="text/javascript" src="${ctx }/js/jquery.js"></script>
</head>
<body>

	<div class="login">
		<div class="login-screen">
			<div class="app-title">
				<h1>登录</h1>
			</div>
			
			<div class="login-form">
				<div class="control-group">
					<input type="text" class="login-field" value="" placeholder="用户名" id="login-name">
					<label class="login-field-icon fui-user" for="login-name"></label>
				</div>

				<div class="control-group">
					<input type="password" class="login-field" value="" placeholder="密码" id="login-pass">
					<label class="login-field-icon fui-lock" for="login-pass"></label>
				</div>
				
				<div class="control-group" style="">
					<input type="text" class="login-field" value="" placeholder="验证码" id="verifyCode" style="width: 90px; padding-left:10px; ">
					<img  src="${ctx}/getVerifyCode" onclick="verifcationCodeChange()" id="verifcationCodeImge">
				</div>

				<a class="btn btn-primary btn-large btn-block" href="#" id="login_but">登录</a>
				<a class="login-link" href="#">忘记密码</a>
			</div>
		</div>
	</div>
	
</body>

<script type="text/javascript">


	function verifcationCodeChange(){
		document.getElementById("verifcationCodeImge").src="${ctx}/getVerifyCode?a="+new Date().getTime(); 
	}
	
	$(function(){
		
		/*登录按钮点击事件*/
		$("#login_but").on("click",function(){
			var name=$("#login-name").val()
			var password=$("#login-pass").val()
			var code=$("#verifyCode").val()
			
			$.ajax({
				type:'POST',
				url:'${ctx}/login',
				data:{
					name:name,
					password:password,
					code:code
				},
				success:function(data){
					alert("?")
				}
				
			})
			
		})
		
	})
	
	

</script>
</html>