<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head><!-- style="display: none;" -->
<%
	
	String brcb_gateway_url = request.getParameter("brcb_gateway_url");
	String body = request.getParameter("body");
	body=new String(body.getBytes("iso-8859-1"),"utf-8");
	String mch_id = request.getParameter("mch_id");
	String nonce_str = request.getParameter("nonce_str");
	String notify_url = request.getParameter("notify_url");
	String out_trade_no = request.getParameter("out_trade_no");
	String service_type = request.getParameter("service_type");
	String sign = request.getParameter("sign");
	String spbill_create_ip = request.getParameter("spbill_create_ip");
	String total_fee = request.getParameter("total_fee");
	String attach = request.getParameter("attach");
	
%>
<body style="display: none;">
	<form id="from"  action="<%=brcb_gateway_url%>" method="post">
		<input type="text" name="body" value="<%=body %>" />
		<input type="text" name="mch_id" value="<%=mch_id %>" />
		<input type="text" name="nonce_str" value="<%=nonce_str %>" />
		<input type="text" name="notify_url" value="<%=notify_url %>" />
		<input type="text" name="out_trade_no" value="<%=out_trade_no %>" />
		<input type="text" name="service_type" value="<%=service_type %>" />
		<input type="text" name="sign" value="<%=sign %>" />
		<input type="text" name="spbill_create_ip" value="<%=spbill_create_ip %>" />
		<input type="text" name="total_fee" value="<%=total_fee %>" />
		<input type="text" name="attach" value="<%=attach %>" />
		
	</form>
	  <script type="text/javascript">
		document.getElementById("from").submit();
	</script>  
</body>
</html>