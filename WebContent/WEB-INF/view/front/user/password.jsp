<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.zhiyou100.zy_video.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/profile.css">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
   <jsp:include page="uheader.jsp"></jsp:include>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="front/user/profile.do">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/avatar.do">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/password.do">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                        
                           <c:if test="${empty user.headUrl}">
		                         <img id="avatar"  src="static/img/avatar_lg.png" alt="">
		                      </c:if>
		                      
		                      <c:if test="${not empty user.headUrl}">
		                         <img id="avatar" width="200px" height="200px" src="/pic/${user.headUrl}" alt="">
		                      </c:if>
                           
                        </div>
                        
                        <div class="profile_ifo_area">
                        
                         <c:if test="${not empty message}">
				            <div>
				                <strong>${message}</strong>
				            </div>
				            </c:if>
                            <form action="front/user/password.do" method="post" id="updatePassWordFrom">
                                <div class="form_group">
                                    <span class="dd">旧&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="oldPassword" name="oldPassword" onblur="checkPassword()">
                                    <span id="checkPasswordResult"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="newPassword"  name="newPassword">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input type="password" id="newPassword02" name="newPasswordAgain">
                                </div>
                                <div class="form_submit dd">
                                    <input type="submit" value="保&#x3000;存">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="ufooter.jsp"></jsp:include>
    <%@include file="../include/script.html"%>
   <script type="text/javascript">
		function checkPassword() {
			
			var oldPassword = $("#oldPassword").val();
			//alert("oldPassword="+oldPassword);
			//alert("function checkPassword");
			$.ajax({
				type:"post",
				dataType:"text",
				data:"oldPassword="+ oldPassword,
				url:"front/user/checkPassword.do",
				success:function(msg){
						//alert("success:function(msg)");
						alert(msg);
						if(msg == "success"){
							$("#checkPasswordResult").text("密码正确!")
						}
					}
			});
			$("#oldPassword").onfcous();
		}
		$(function(){
			if("${resultStr}" == "success"){
				alert("修改成功");
			}
		})
		 $(function(){
		    	$("#updatePassWordFrom").validate({
		    		rules:{
		    			oldPassword:{
		    					required:true
		    				},
		    			newPassword:{
		    					required:true
		    				},
		    			newPasswordAgain:{
		    					required:true,
		    					equalTo:"input[name=newPassword]"
		    				}
		    		},
		    		messages:{
		    			oldPassword:{
	    					required:"旧密码不能为空"
	    				},
		    			newPassword:{
		    					required:"新密码不能为空"
		    				},
		    			newPasswordAgain:{
		    					required:"重复新密码不能为空",
		    					equalTo:"两次输入密码不一致"
		    				}
		    		}
		    	});
		    });
   </script>
</body>
</html>