<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="description" content="">
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="user-scalable=0" />	
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/index.css">
		<title>分享页面</title>	
		<style>
		body{
				width: 100%;
				height: 43.4999999rem;
				background: url("../images/beijing1.png") no-repeat;
				background-size:100%  100%;
				position: relative;
			}
		</style>
	</head>
	<body>
	<div class="er_ma">
		<img src="<%=request.getParameter("url") %>" alt="">
	</div>
     <div class="eurn">立即邀请好友</div>
	</body>
	<script>
		var w = document.documentElement.clientWidth;
		if(w > 640) {
			w = 640
		}
		document.documentElement.style.fontSize = 20 / 320 * w + 'px';
		window.onresize = function() {
			document.documentElement.style.fontSize = 20 / 320 * w + 'px';
		};
	</script>	
</html>
