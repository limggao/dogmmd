<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstraps.min.css">
    <script src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<div class="login">
   <h4>后台登录系统</h4>
   <div class="ss" style="color: red;" align="center"></div>
    <form class="form-horizontal box_form" role="form">
        <div class="form-group">
            <label for="firstname" class="col-sm-3 control-label">用户名：</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="firstname"
                       placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-3 control-label password">密码:</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" id="lastname"
                       placeholder="请输密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-7">
                <input type="button" onclick="dianji()" value="登录" class="btn btn-default"></input>
            </div>
        </div>
    </form>
    
    
    <script type="text/javascript">
    function dianji(){
    	var name =$("#firstname").val();
    	var passWord =$("#lastname").val();
    	$.ajax({
    		url:"/tjekuaitong/UserController/login",
    		dataType:"json",
    		data:{"passWord":passWord,"userName":name},
    		success:function(data){
    			console.info(data);
    			if(data.msg=="成功"){
    				window.location.href="/tjekuaitong/backpages/index.jsp";
    			}else if(data.msg=="失败"){
    				$(".ss").html("用户名或密码错误！");
    				$("#firstname").val("");
    				$("#lastname").val("");
    			}
    		}
    	});
    }
    	
    </script>
</div>
</body>
</html>