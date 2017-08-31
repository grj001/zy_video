<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.12.4.min.js"/>"></script>
<script type="text/javascript">
	
function sendMessage() {
		alert("sendMessage");
		//接受到表单数据
		var message = document.getElementById("sendId").value;
		alert(message);
		/*
			1.创建ajax对象
			2.发送数据
			3.接收数据
		 */
		//1.创建ajax对象
		var xmlHttp = new XMLHttpRequest();
		alert(xmlHttp);

		//当服务端返回数据的时候此方法会调用	
		xmlHttp.onreadystatechange = function() {

			alert(xmlHttp.readyState+"-------------"+ xmlHttp.status);
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				alert(xmlHttp.readyState+"-------------"+ xmlHttp.status);
				document.getElementById("receiveId").value = xmlHttp.responseText;
			}

		};
		/*
		//绑定请求
		xmlHttp.open("GET","/Day33_SpringMVC03/ajax/js.action?name="+message,true);
		//发送数据
		xmlHttp.send();
		 */
		xmlHttp.open("POST", "/zy_video/ajax/js.action", true);

		//如果使用post请求需要多添加一个请求头,如果不添加,服务器收不到数据
		xmlHttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlHttp.send("name=" + message);

	}; 
	
/* 	function sendMessage(){
		var str = $("#sendId").val();
		$.get(
			"${pageContest.request.contextPath}/ajax/js.action",	
			//?name=
			"name="+str,
			function(message){
				
			},
			"text"
		);
	}; */
</script>
</head>
<body>
	<h1>js原生ajax</h1>
	要发送的信息
	<input type="text" id="sendId"> 接收到的信息
	<input type="text" id="receiveId">
	<input type="button" value="发送信息" onclick="sendMessage()">
</body>
</html>