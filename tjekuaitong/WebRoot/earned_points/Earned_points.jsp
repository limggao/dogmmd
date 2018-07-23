<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/index.css">
    <script src="../js/jquery.min.js"></script>
    <title>积分赚取</title>
</head>
<body>
<div class="payment">

</div>

</body>
<script>
    var w = document.documentElement.clientWidth;
    if(w > 640) {
        w = 640
    }
    document.documentElement.style.fontSize = 20 / 320 * w + 'px';
    window.onresize = function() {
        document.documentElement.style.fontSize = 20 / 320 * w + 'px';
    }
    //获取积分赚取
    //记得写action地址
    $(function(){
    	 $.ajax({
    		url: "/tjekuaitong/vipController/getVip",
    		data:{"openId":"${openId}","type":"1"},
    		dataType:"json",
    		success:function(data){
    			var strVar = "";
    			console.info(data);
    			$.each(data,function(index,datas){
    				
        		    strVar += "<div class=\"Earned_points\">\n";
        		    strVar += "    <div class=\"_points-left\">\n";
        		    strVar += "        <div class=\"phone_huf\">"+datas.totalScore+"<\/div>\n";
        		    strVar += "        <div class=\"phone_time\"><sapn>"+datas.vipUpdateTime+"<\/span><\/div>\n";
        		    strVar += "    <\/div>\n";
        		    strVar += "    <div class=\"_points_right\">+"+datas.addVip+"<\/div>\n";
        		    strVar += "    <div class=\"clear\"><\/div>\n";
        		    strVar += "<\/div>\n";
     	    	            
     			}); 
    			
    			$(".payment").html(strVar);
    		}
    	});
    });
</script>
</html>