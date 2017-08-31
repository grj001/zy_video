<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加课程</title>
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
</head>

<body>
	<form class="form-horizontal container" action="<c:url value="/admin/course/updateCourse.do"/>?id=${updateCourse.id}" method="post">
		<div class="container">
			<div class="jumbotron">
				<h2>编辑课程-课程管理</h2>
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
				<label for="exampleInputEmail1">标题</label> 
				<input type="text" value="${updateCourse.courseName }" name="courseName" class="form-control" id="inputEmail3" placeholder="">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">学科</label> 
				<select class="form-control" name="subjectId">
					<c:forEach items="${listSubject}" var="subject" varStatus="status">
						<option value="${subject.id }" ${subject.id eq updateCourse.subjectId ? "selected" : ""}>${subject.subjectName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">简介 </label>
				<textarea class="form-control" name="courseDescr">${updateCourse.courseDescr }</textarea>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary">保存</button>
				&nbsp;&nbsp; 
				<a href="javascript:history.go(-1)" class="btn btn-primary">返回列表</a>
			</div>
		</div>
	</form>
</body>
</html>