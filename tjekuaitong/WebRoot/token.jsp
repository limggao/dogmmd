<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
</head>
<body>
	 <button type="button" class="btn btn-primary" onclick="goAuth()">授权</button>
</body>

<script type="text/javascript">
        function goAuth() {
            window.location.href = "http://oauth.qianmi.com/authorize?client_id=10001483&response_type=code&redirect_uri=http://wx.tjaxej.com/authController/callback&state=1&view=web";
        }
    </script>
</html>