<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程列表</title>
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>课程列表-课程管理</h2>
		</div>
	</div>
	<!--
        	描述：表单
        -->
	<div class="form-group container">

		<!--
            	描述：添加视频
            -->
		<a href="<c:url value="/admin/course/addCourse.do"/>" class="btn btn-primary">添加课程</a>

		<!--表格-->
		<div class="bs-example" data-example-id="hoverable-table">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>标题</th>
						<th>学科</th>
						<th>简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<!-- 遍历出course -->
					<c:forEach items="${findAllCourse }" var="course" varStatus="status">
						<tr>
							<th scope="row">${status.count }</th>
							<!-- courseName -->
							<td>${course.courseName }</td>
							<!-- 学科名称,多表查询 -->
							<td>${course.subjectName }</td>
							<td>${course.courseDescr }</td>
							<td>
								<a href="<c:url value="/admin/course/updateCourse.do"/>?id=${course.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
							</td>
							<td>
								<a href="<c:url value="/admin/course/deleteCourse.do"/>?id=${course.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>