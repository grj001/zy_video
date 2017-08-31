<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>视频列表</title>
<link href="<c:url value="/static/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/static/css/jquery-confirm.css"/>"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>

<script src="<c:url value="/static/js/jquery-confirm.js"/>"></script>

<!-- 批量删除 -->
<script>

	var deleteNum = 0;
	function onclickAdd(ele) {
		//alert("function checkAll(ele)");
		//alert(ele);
		if (ele.checked) {
			//alert("if(ele.checked)");
			//alert(ele.checked);
			deleteNum++;
		} else {
			deleteNum--;
		}
		$("#countSpan").text(deleteNum);

		//下面全选了,全选框选中
		//下面没全选的,第一个不选中
		//alert(deleteNum);
		if (deleteNum == $("input[name=ids]").length) {
			$("#checkAllChecks").prop("checked", true);
		} else {
			$("#checkAllChecks").prop("checked", false);
		}

	}

	function checkAll(ele) {
		//alert("function checkAll(ele)");
		//alert(ele);
		//更换所有的选中框为checkAll的状态
		$("input[name=ids]").prop("checked", ele.checked);
		//为deleteNum赋值
		if (ele.checked) {
			deleteNum = $("input[name=ids]").length;
		} else {
			deleteNum = 0;
		}
		$("#countSpan").text(deleteNum);
	}

	function batchDelete() {
		//alert("function batchDelete()");
		if (deleteNum == 0) {
			//alert(deleteNum);
			$.alert({
				title : '警告',
				content : '啥都没有,删啥',
			});
			return;
		}

		$.confirm({
			title : '警告!',
			content : '全部删除!!',
			buttons : {
				//点击确定时调用
				confirm : {
					text : '确定全部删除',
					action : function() {
						//alert($("#deleteVideosForm"));
						$("#deleteVideosForm").submit();
						$.alert('完成全部删除!');
					}
				},
				//点击取消调用
				取消 : function() {
					$.alert('已取消删除');
				}
			}
		});

	}
	
	function deleteInfo(id){
		$.confirm({
			title : '提示!',
			content : '确认删除!!',
			buttons : {
				//点击确定时调用
				confirm : {
					text : '删除',
					action : function() {
						$.ajax({
							url:"${pageContext.request.contextPath}/admin/video/deleteVideo.do",
							dataType: "text",
							type: "post",
							data:{"id" : id},
							success: function(msg){
								
								if(msg=="success"){
									location.reload();
								}
							}
						})
					}
				},
				//点击取消调用
				取消 : function() {
					$.alert('已取消删除');
				}
			}
		});
	}
</script>
</head>

<body>














	<!--描述：表单 -->
	<div class="form-group container">


		<div class="jumbotron">
			<h2>视频列表-视频管理</h2>
		</div>



		<!--************************** 描述：添加视频 **************************-->
		<a href="<c:url value="/admin/video/addVideo.do"/>"
			class="btn btn-primary">添加视频</a>
		<!--************************** 批量删除 **************************-->
		<button class="btn btn-primary" type="button" onclick="batchDelete()">
			批量删除 <span class="badge" id="countSpan">0</span>
		</button>

		<!--************************** 描述：查询主讲人 **************************-->
		<div class="pull-right">
			<form class="form-group form-inline"
				action="<c:url value="/admin/video/videoList.do"/>">
				<input class="form-control" type="text" placeholder="视频标题"
					name="titleKeyWord" value="${titleKeyWord }">&nbsp;&nbsp;
				<!-- **************************遍历主讲人姓名 **************************-->
				<select class="form-control" name="speakerNameKeyWord">
					<option value="">请选择主讲人</option>
					<c:forEach items="${listSpeaker}" var="speaker" varStatus="status">
						<option value="${speaker.speakerName }" ${speakerNameKeyWord eq speaker.speakerName ? "selected" : ""}>${speaker.speakerName}</option>
					</c:forEach>
				</select>&nbsp;&nbsp;
				<!--************************** 遍历课程名称 **************************-->
				<select class="form-control" name="courseNameKeyword">
					<option value="">请选择课程</option>
					<c:forEach items="${listCourse}" var="course" varStatus="status">
						<option value="${course.courseName }" ${courseNameKeyword eq course.courseName ? "selected" : ""}>${course.courseName}</option>
					</c:forEach>
				</select>&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>










		<!--****************************	表格		******************************-->
		<form id="deleteVideosForm"
			action="<c:url value="/admin/video/deleteVideos.do"/>">
			<div class="bs-example" data-example-id="hoverable-table">






				<table class="table table-hover">




					<thead>
						<tr>
							<th><input type="checkbox" onclick="checkAll(this)"
								id="checkAllChecks"></th>
							<th>序号</th>
							<th>名称</th>
							<th>介绍</th>
							<th>讲师</th>
							<th>课程</th>
							<th>时长(秒)</th>
							<th>播放次数</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>




					<tbody>

						<c:forEach items="${page.rows }" var="video" varStatus="status">
							<tr>
								<td><input type="checkbox" onclick="onclickAdd(this)"
									name="ids" value="${video.id }"></td>
								<td>${status.count + (page.page-1)*5 }</td>
								<td>${video.videoTitle }</td>
								<td>${video.videoDescr }</td>
								<td>${video.speaker.speakerName  }</td>
								<td>${video.course.courseName }</td>
								<td>${video.videoLength }</td>
								<td>${video.videoPlayTimes }</td>



								<td><a class="glyphicon glyphicon-edit"
									href="<c:url value="/admin/video/updateVideo.do"/>?id=${video.id}"
									style="text-decoration: none;" aria-hidden="true"></a></td>
								<td><a class="glyphicon glyphicon-trash"
									onclick="deleteInfo(${video.id})"
									style="text-decoration: none;" aria-hidden="true"></a></td>




							</tr>
						</c:forEach>

					</tbody>



				</table>
			</div>
		</form>


		<!-- 分页	 -->
		<div class="form-horizontal form-inline">
			<label><page:page
					url="${pageContext.request.contextPath }/admin/video/videoList.do"></page:page></label>
		</div>
	</div>
</body>
</html>