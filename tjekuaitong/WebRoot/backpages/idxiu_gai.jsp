<%@page import="com.itextpdf.text.log.SysoLogger"%>
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
    <script src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap_01.min.css">
    <link rel="stylesheet" href="../css/index_01.css">
    <title>订单管理</title>
</head>
<%
	String in =request.getParameter("id");
	System.out.print(in);
%>
<%Object abc=session.getAttribute("user");
if(abc==null){
 response.sendRedirect("Login.jsp");
}
 %>
<body>
    <div class="modify">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control id" readonly="readonly" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">套餐金额</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control facePrice" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实际金额</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control orderCost" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">种类</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control type" readonly="readonly" >
                </div>
            </div>
            <div class="success" align="center" style="color: red;"></div>
            <div class="btn">修改</div>
        </form>
    </div>
    <script type="text/javascript">
    	$.ajax({
    		url:"/tjekuaitong/PayController/getId",
    		dataType:"json",
    		data:{"id":<%=in%>},
	    	success:function(data){
	    		$(".id").val(data.id);
	    		$(".facePrice").val(data.facePrice);
	    		$(".type").val(data.type);
	    		$(".orderCost").val(data.orderCost);
	    	}
    	});
    	
    	
    	$(".btn").click(function(){
    		var id = $(".id").val();
    		var facePrice = $(".facePrice").val();
    		var type = $(".type").val();
    		var orderCost = $(".orderCost").val();
    		
    		$.ajax({
    			url:"/tjekuaitong/PayController/update",
        		data:{"id":id,"facePrice":facePrice,"type":type,"orderCost":orderCost},
    	    	success:function(data){
    	    		console.info(data);
    	    		if(data){
    	    			alert("修改成功");
    	    			$(".success").html("修改成功");
    	    			window.location.href="payment_management.jsp";
    	    		}else{
    	    			alert("修改失败");
    	    			$(".success").html("修改失败");
    	    		}
    	    		
    	    	}
    		});
    	});
    </script>
</body>
</html>