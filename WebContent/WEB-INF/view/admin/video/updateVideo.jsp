<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="http://zhiyou100.com/common/"%>
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
	<form class="form-horizontal container" action="<c:url value="/admin/video/updateVideo.do"/>?id=${updateVideo.id}" method="post">
		<div class="container">
			<div class="jumbotron">
				<h2>编辑视频信息-视频管理</h2>
			</div>
		</div>
		<!--	描述：表单 	-->
		<div class="form-group">
			<!--	描述：登录名	-->
			<div class="form-group">
				<label class="col-lg-2 control-label">视频标题</label>
				<div class="col-lg-10">
					<input type="text" name="videoTitle" value="${updateVideo.videoTitle }" class="form-control" id="inputEmail3" placeholder="">
				</div>
				<br />
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label">主讲人</label>
				<div class="col-md-10">
					<!-- 提交的是选择的speaker的id -->
					<select class="form-control" name="speakerId">
						<option value="">请选择主讲人</option>
						<c:forEach items="${listSpeaker}" var="speaker" varStatus="status">
							<option value="${speaker.id }" ${updateVideo.speakerId eq speaker.id ? "selected" : ""}>${speaker.speakerName}</option>
						</c:forEach>
					</select>
				</div>
				<br />
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label">所属课程</label>
				<div class="col-md-10">
					<select class="form-control" name="courseId">
						<option value="">请选择课程</option>
						<c:forEach items="${listCourse}" var="course" varStatus="status">
						<option value="${course.id }" ${updateVideo.courseId eq course.id ? "selected" : ""}>${course.courseName}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 col-lg-2 control-label">视频时长</label>
				<div class="col-md-10 col-lg-10 ">
					<input type="text" name="videoLength" value="${updateVideo.videoLength }" class="form-control" id="inputEmail3" placeholder="">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 col-lg-2 control-label">封面图片</label>
				<div class="col-md-10 col-lg-10 ">
					<input type="text" name="videoImageUrl" value="${updateVideo.videoImageUrl }" class="form-control" id="inputEmail3"
						placeholder="">
				</div>
				<br />
			</div>

			<div class="form-group">
				<label class="col-md-2 col-lg-2 control-label">视频播放地址</label>
				<div class="col-md-10 col-lg-10 ">
					<input type="text" name="videoUrl" value="${updateVideo.videoUrl }" class="form-control" id="inputEmail3" placeholder="">
				</div>
				<br />
			</div>

			<div class="form-group">
				<label class="col-md-2 col-lg-2 control-label">视频简介 </label>
				<div class="col-md-10 col-lg-10 ">
					<textarea class="form-control" name="videoDescr">${updateVideo.videoDescr }</textarea>
				</div>
				<br />
			</div>

			<div class="form-group">
				<span class="col-md-2 col-lg-2"></span>
				<div class="col-md-2 col-lg-10 ">
					<button type="submit" class="btn btn-primary">保存</button>
					&nbsp;&nbsp; 
					<a href="javascript:history.go(-1)" class="btn btn-primary">返回列表</a>
				</div>
			</div>

		</div>
	</form>
</body>
</html>