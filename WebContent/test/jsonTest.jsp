<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		window.onload = function(){
			alert("window.onload = function(){");
			var jsonObj = {"name": "小明"};
			alert(jsonObj.name);
			alert(JSON.stringify(jsonObj));
			alert(JSON.parse(JSON.stringify(jsonObj)).name);
			
			var car = [{"name":"c1","price":"c1"},{"name":"c2","price":"c2"}];
			alert(car[1].name);
		}
		
	</script>
</head>
<body>

</body>
</html>