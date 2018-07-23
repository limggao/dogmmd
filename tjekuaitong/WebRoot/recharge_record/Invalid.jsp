<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="renderer"content="webkit">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/swiper.min.css">
    <link rel="stylesheet" href="../css/tab_xia.css">
    <link rel="stylesheet" href="../css/style.css">
    <title>充值记录</title>
</head>
<body>
<div data-role="page">
    <div data-role="content-floud">
        <ul id="hear">
            <li>
                <a href="../recharge_record/pending_payment.jsp?openId=${openId }">已缴费</a>
            </li>
            <li>
                <a href="../recharge_record/recharge_in.jsp?openId=${openId }">待缴费</a>
            </li>
            <li class="action">
                <a href="../recharge_record/Invalid.jsp?openId=${openId }">失败</a>
            </li>
        </ul>
    </div>
</div>
<div class="payment">
    
</div>
</body>
<script type="text/javascript" src="../js/zepto.min.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper.min.js"></script>
<script type="text/javascript">
    var w = document.documentElement.clientWidth;
    if(w > 640) {
        w = 640
    }
    document.documentElement.style.fontSize = 20 / 320 * w + 'px';
    window.onresize = function() {
        document.documentElement.style.fontSize = 20 / 320 * w + 'px';
    }
    $(function() {
        $("#hear li").click(function() {
            $(this).css({
                borderBottom: "3px solid #0698eb",
                color:"#0698eb",
                height: "98%"
            }).siblings().css({
                borderBottom: "none",
                height: "45px"
            });
        });
    });
    
    $(function(){
      	 $.ajax({
      		url: "/tjekuaitong/orderController/order",
      		data:{"payState":"1","openId":"${openId}","rechargeState":"9"},
      		dataType:"json",
      		success:function(data){
      			console.info(data);
      			var ss='';
      			$.each(data,function(index,datas){
      				console.info(index);
      				console.info(datas);
      				ss+='<div class="payment_io1"><div class="img_head"><img src="'+datas.idFrontImage+'" alt=""></div>'+
      	    	        	'<div class="text_jilu"><div class="user_form"><span>订单编号：</span><span class="moi_yt">'+datas.billId+'</span></div>'+
      	    	            '<div class="user_form"><span>充值号码：</span><span class="moi_yt">'+datas.rechargeAccount+'</span></div>'+
      	    	            '<div class="user_form"><span>订单名称：</span><span class="moi_yt">'+datas.itemName+'</span></div>'+
      	    	            '<div class="user_form"><span>订单状态：</span><span class="moi_yt">失败</span></div>'+
      	    	            '<div class="user_form"><span>下单时间：</span><span class="moi_yt">'+datas.orderTime+'</span></div></div> <div class="clear"></div></div>';
      	    	            
      			}); 
      			$(".payment").html(ss);
      		}
      	});
      });
</script>
</html>