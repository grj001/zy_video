<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>导航条</title>
	<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
	<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<!--
        	描述：反色导航条
        	navbar-fixed-top 固定到顶部
        -->
	<nav id="bs-navbar" class=" navbar-collapse">
		<div class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button class="navbar-toggle collapsed" type="button"
						data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="" onclick="">视频管理系统</a>
				</div>
				<div class="navbar-collapse collapse" role="navigation">
					<ul class="nav navbar-nav">
						<li class=""><a
							href="<c:url value="/admin/video/videoList.do"/>" target="pageBox"
							onclick="">视频管理</a></li>
						<li><a href="<c:url value="/admin/speaker/speakerList.do"/>"
							target="pageBox" onclick="">主讲人管理</a></li>
						<li><a href="<c:url value="/admin/course/courseList.do"/>"
							target="pageBox" onclick="">课程管理</a></li>
						<li><a href="<c:url value="/admin/char/charList.do"/>" target="pageBox" onclick="">统计分析</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="<c:url value="/admin/logout.do"/>"
							onclick=""> admin<span class="glyphicon glyphicon-log-out"
								aria-hidden="true"></span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="embed-responsive embed-responsive-4by3">
		<iframe name="pageBox" src="<c:url value="/admin/video/videoList.do" />"></iframe>
	</div>
</body>
</html>
