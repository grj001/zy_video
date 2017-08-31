<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑视频信息</title>
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>

</head>
<body>

	<!-- 表单提交到SpeakerController,addSpeaker,post -->
	<form class="form-horizontal container" action="<c:url value="/admin/speaker/addSpeaker.do"/>" method="post">
		<div class="container">
			<div class="jumbotron">
				<h2>编辑主讲人-主讲人管理</h2>
			</div>
		</div>
		<!--
        	描述：表单
        -->
		<div class="container">
			<!--
                	描述：登录名
                -->
			<div class="form-group">
				<label for="exampleInputEmail1">姓名</label> <input type="text" name="speakerName"
					class="form-control" id="inputEmail3" placeholder="">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">职业</label> <input type="text" name="speakerJob"
					class="form-control" id="inputEmail3" placeholder="">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">头像图片</label> <input type="text" name="speakerHeadUrl"
					class="form-control" id="inputEmail3" placeholder="">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">简介 </label>
				<textarea class="form-control" name="speakerDescr"></textarea>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary"
					onclick="{
							if(confirm('确定保存吗?')){
		  							return true;
  								}
  								return false;}">保存
				</button>
				&nbsp;&nbsp; <a href="javascript:history.go(-1)"
					class="btn btn-primary">返回列表</a>
			</div>
		</div>
	</form>
</body>
</html>