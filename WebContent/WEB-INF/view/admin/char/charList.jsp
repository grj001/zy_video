<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css"/>" />
<script type="text/javascript"
	src="<c:url value="/static/js/jquery-1.12.4.min.js"/>"></script>
<!-- ECharts单文件引入 -->
<!--新建<script>标签引入模块化单文件echarts.js-->
<script src="<c:url value="/static/js/build/dist/echarts.js"/>"></script>
</head>
<body>


	<script type="text/javascript">

		// 路径配置
		require.config({
			paths : {
				echarts : '<c:url value="/static/js/build/dist"/>'
			}
		});

		// 使用
		require([ 
			'echarts', 
			'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
		], 
		
		function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('main'));

			var option = {
				tooltip : {
					show : true
				},
				legend : {
					data : [ '播放次数' ]
				},
				xAxis : [ {
					type : 'category',
					data : [${resultCourseNamesStr}],
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					"name" : "播放次数",
					"type" : "bar",
					"data" : [${resultCourseTimesStr}],
				} ]
			};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		})
	</script>

	<div class="container">
		<div class="jumbotron">
			<h2>表格列表-表格管理</h2>
		</div>

		<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
		<h3 style="text-align: center;">平均播放次数</h3>
		<div id="main" style="height: 400px;"></div>
	
	</div>

</body>
</html>