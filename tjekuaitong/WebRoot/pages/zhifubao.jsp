<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付宝支付</title>
<script src="../js/jquery.min.js"></script>
</head>
 <%String url =request.getParameter("url");
 	System.out.print(url);
 %> 
<body>
<center>
<img id="img" style="width: 460px;height: 500px;padding-top: 36%;" alt="" src="">
</center>
 <script type="text/javascript">

	var url="http://pan.baidu.com/share/qrcode?w=150&h=150&url=<%=url%>";
	$("#img").attr("src",url);
</script>
</body>
</html>