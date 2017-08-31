<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
	<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
	<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/messages_zh.min.js"/>"></script>
	
	<!-- validate -->
	<script type="text/javascript">
		$(function(){
			//$("form[name='tab5_2'] input[name='kw']").val()
			$("form[name='adminLoginForm']").validate({
				rules: {
					loginName: {
						required: true,
						minlength:3
					},
					loginPwd: {
						required:true,
						minlength:3
					}
				},
				messages: {
					loginName: {
						required: "用户名不能为空.",
						minlength:"用户名最少要输入 6 个字符"
					},
					loginPwd: {
						required: "密码不能为空.",
						minlength:"密码最少要输入 6 个字符"
					}
				}
			})
		});
	</script>

	<style>
		#inputEmail3-error{
			color: red;
		}
		#inputPassword3-error{
			color: red;
		}
		.center-block {
			display: block;
			margin-left: auto;
			margin-right: auto;
			margin-top: 250px;
			width: 350px;
		}
	</style>
</head>
<body>
	<form name="adminLoginForm" class="form-horizontal" action="<c:url value="/admin/login.do"/>" method="post">
		<div class="center-block container">
			<!--
            	描述：图片
           -->
			<img class="img-responsive" src="<c:url value="/static/image/logo.png"/>" />
			<div class="form-group">
				<!--
                	描述：登录名
                -->
				<div class="col-md-12">
					<label for="exampleInputEmail1">登录名</label> 
					<input type="text" name="loginName" value="admin" class="form-control" id="inputEmail3" placeholder="用户名">
				</div>
			</div>
			<div class="form-group">
				<!--
                	描述：密码
                -->
				<div class="col-md-12">
					<label for="inputPassword3">密码</label> 
					<input type="password" name="loginPwd" value="admin" class="form-control" id="inputPassword3" placeholder="登录密码">
				</div>
			</div>
			
			<!-- 登录错误信息 -->
			<div class="form-group" style="text-align: center;"><strong style="color:red;">${errorMessage }</strong></div>
			
			<div class="checkbox">
				<label> <input type="checkbox" name="remember">记住密码</label>
			</div>
			&zwnj;
			<div class="form-group">
				<div class="col-md-12">
					<button type="submit" class="btn btn-block btn-primary">登录</button>
				</div>
			</div>
		</div>
	</form>
	<a href="<c:url value="/index.do"></c:url>">进入前台</a>
</body>
</html>