<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>主讲人列表</title>
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>


</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<h2>主讲人列表-主讲人管理</h2>
		</div>
	</div>
	<!--
        	描述：表单
       -->

	<div class="container">

		<!--描述：添加主讲人-->
		<a href="<c:url value="/admin/speaker/addSpeaker.do"/>" class="btn btn-primary">添加主讲人</a>

		<div class="pull-right">
			<form class="form-group form-inline"
				action="<c:url value="/admin/speaker/speakerList.do"/>">
				<!--描述：查询主讲人-->
				<strong>名称</strong>&nbsp;&nbsp; <input class="form-control"
					name="speakerNameKeyWord" value="${speakerNameKeyWord }"
					type="text" placeholder="主讲人名称" />&nbsp;&nbsp; <strong>职位</strong>&nbsp;&nbsp;
				<input class="form-control" name="speakerJobKeyWord"
					value="${speakerJobKeyWord }" type="text" placeholder="主讲人职位" />&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>


		<!--表格-->
		<div class="bs-example" data-example-id="hoverable-table">
			<table class="table table-hover ">
				<thead>
					<tr>
						<th>序号</th>
						<th>名称</th>
						<th>职位</th>
						<th>简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<!-- 遍历出course -->
					<c:forEach items="${page.rows }" var="speaker" varStatus="status">
						<tr>
							<!-- 是page.page因为page里有page属性,减一乘五是在SpeakerVO中设置的 -->
							<th scope="row">${status.count + (page.page-1)*5  }</th>
							<td>${speaker.speakerName }</td>
							<td>${speaker.speakerJob }</td>
							<td>${speaker.speakerDescr }</td>
							<td>
								<a href="<c:url value="/admin/speaker/updateSpeaker.do"/>?id=${speaker.id}">
									<span class="glyphicon glyphicon-edit" aria-hidden="true" ></span>
								</a>
							</td>
							<td>
								<a href="<c:url value="/admin/speaker/deleteSpeaker.do"/>?id=${speaker.id}">
									<span class="glyphicon glyphicon-trash" aria-hidden="true" ></span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 分页	 -->
		<div class="form-horizontal form-inline">
			<label><page:page url="${pageContext.request.contextPath}/admin/speaker/speakerList.do"></page:page></label>
		</div>
	</div>
</body>

</html>