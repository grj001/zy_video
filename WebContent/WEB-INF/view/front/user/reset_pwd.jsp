<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/forget_password.css">
    <link rel="icon" href="favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
    
    <%@include file="../include/script.html"%>
    <script type="text/javascript">
	    $(function(){
	    	$("#resetPassWordFrom").validate({
	    		rules:{
	    			password:{
	    					required:true
	    				},
	    			pwdAgain:{
	    					required:true,
	    					equalTo:"input[name=password]"
	    				},
	    		},
	    		messages:{
	    			password:{
	    				required: "用户名不能为空"
	    			},
	    			pwdAgain:{
	    				required: "密码不能为空",
	    				equalTo: "密码两次输入不一致"
	    			},
	    		}
	    	});
	    });
    </script>
    
</head>

<body>
    <header>
        <div class="container">
            <img src="static/img/logo.png" alt="智游">
        </div>
    </header>
    <main>
        <div class="container">
            <form class="ma" action="front/user/resetpwd.do" method="post" id="resetPassWordFrom">
               <input type="hidden" name="email" value="${email}"/>
                <input type="hidden" name="captcha" value="${captcha}"/>
                <div class="form_header">
                    <div class="form_title">
                        <h2>重置密码</h2>
                    </div>
                    
                </div>
                <div class="form_body form-group">
                    <input type="password" class="form-control" placeholder="请输入新密码" id="password" name="password">
                    <input type="password" class="form-control" style="width:100%" placeholder="再次输入新密码" id="password02" name="pwdAgain">
                    <input type="submit" class=" form-control" style="margin:0px;width:100%" value="提交">&nbsp;
                    <a href="javascript:history.go(-1)" class="btn btn-primary form-control">返回列表</a>
                </div>
                
            </form>
        </div>
    </main>
</body>

</html>