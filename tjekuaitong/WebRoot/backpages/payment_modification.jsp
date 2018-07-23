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
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/style1.css">
    <title>管理系统首页</title>
</head>
<%Object abc=session.getAttribute("user");
if(abc==null){
 response.sendRedirect("Login.jsp");
}
 %>
<body>
<div class="backstage row">
    <div class="top_text">
        <h4>后台登录系统</h4>
    </div>
    <div data-role="page">
        <div data-role="content-floud" class="col-lg-2 col-sm-2 left">
            <ul id="hear">
                <li>
                    <a href="index.jsp">首页</a>
                </li>
                <li>
                    <a href="user_management.jsp">用户管理</a>
                </li>
                <li>
                    <a href="payment_management.jsp">缴费管理</a>
                </li>
                <li >
                    <a href="earned_points.jsp">积分兑换</a>
                </li>
                <li>
                    <a href="order_management.jsp">订单管理</a>
                </li>
                <li class="action">
                    <a href="payment_modification.jsp">支付修改方式</a>
                </li>
                <li>
                    <a href="addUrl.jsp">添加推送信息</a>
                </li>
                <li>
                    <a href="Login.jsp">退出管理</a>
                </li>
            </ul>
        </div>
    </div>
  <div class="center col-md-9 col-lg-9">
      <table class="table table-bordered payment_modification">
          <thead>
          <tr class="text_ijh">
              <th>支付类型</th>
              <th>支付方式</th>
              <th>修改状态</th>
          </tr>
          </thead>
          <tbody>
          <tr class="dhfl_kj">
              <td class="type1">微信</td>
              <td>
                  <select id="demo01" class="selection">
                      <option value="block">显示</option>
                      <option value="none">隐藏</option>
                  </select>
              </td>
              <td class="wx"></td>
          </tr>
          <tr class="dhfl_kj">
              <td class="type2">支付宝</td>
              <td>
                  <select id="demo02" class="selection">
                      <option value="block">显示</option>
                      <option value="none">隐藏</option>
                  </select>
              </td>
               <td class="zfb"></td>
          </tr>
          <tr class="dhfl_kj" style="display: none;">
              <td class="type3">微信</td>
              <td>
                  <select id="demo03" class="selection">
                      <option value="block">显示</option>
                      <option value="none">隐藏</option>
                  </select>
              </td>
          </tr>
          <tr class="dhfl_kj" style="display: none;">
              <td class="type4">微信</td>
              <td>
                  <select id="demo04" class="selection">
                      <option value="block">显示</option>
                      <option value="none">隐藏</option>
                  </select>
              </td>
          </tr>
          </tbody>
      </table>
  </div>
    <button class="preservation btn btn-default">修改</button>
</div>
</body>
<script>
var name1='';
var name2='';
    $(function() {
        $("#hear li").click(function() {
            $(this).css({
                backgroundColor: "#b5bbbf",
                height: "100%"
            }).siblings().css({
                backgroundColor: "#fff",
                height: "55px"
            });
        });
    $.ajax({
    	url:"/tjekuaitong/provinceController/paymentMethod",
    	dataType:"json",
    	success:function(data){
    		$.each(data,function(index,datas){
    			console.info(datas.type);
    			if(datas.type=="wx"){
    				$(".type1").html("微信");
    				if(datas.state=="block"){
    					var demo01=	document.getElementById('demo01');
    				 	demo01[0].selected =true;
    				 	name1=datas.id;
    				}else{
    				var demo01=	document.getElementById('demo01');
    				 	demo01[1].selected =true;
    				 	name1=datas.id;
    				}
    				
    			}else if(datas.type=="zfb"){
    				$(".type2").html("支付宝");
    				if(datas.state=='block'){
    					var demo02=	document.getElementById('demo02');
    				 	demo02[0].selected =true;
    				 	name2=datas.id;
    				}else{
    					var demo02=	document.getElementById('demo02');
    				 	demo02[1].selected =true;
    				 	name2=datas.id;
    				}
    				
    			}
    			
    		})
    		
    	}
    });
    });   
    $(".btn").click(function(){
    	data1={"id":name1,"state":$("#demo01 option:selected").val()};
    	data2={"id":name2,"state":$("#demo02 option:selected").val()};
    	$.ajax({
    		url:"/tjekuaitong/provinceController/updatePaymentMethod",
    		data:data1,
    		success:function(data){
    			$(".wx").text(data);
    			console.info("1"+data);
    		}
    	});
    	$.ajax({
    		url:"/tjekuaitong/provinceController/updatePaymentMethod",
    		data:data2,
    		success:function(data){
    			$(".zfb").text(data);
    			console.info("2"+data);
    		}
    	});
    });
    
</script>
</html>