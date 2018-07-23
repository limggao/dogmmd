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
<meta name="viewport"
	content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="../css/index.css">
<title>话费充值</title>
</head>
<%	String ss =request.getParameter("openId"); %>
<%	String vip_j =request.getParameter("vip_j"); %>
<body>
	<div class="phone_recharge">
		<div class="phone">
			<form>
				<input type="number" placeholder="请输入手机号码！" value="" class="phone_input" style="font-size:24px;"/>
			</form>
			<span class="iocn_r"> <img src="../images/iocn/rentou.png"
				alt="">
			</span>
		</div>
		<div class="information_xi">
			<span class="name" style="font-size:16px;">姓名：</span>
			<span class="subject_01"></span> 
			<span class="subject balance" style="font-size:16px;">余额：</span>
			<span class="subject_01"></span> 
			<span class="subject" style="font-size:16px;">省份：</span>
			 <span class="province" style="font-size:16px;"></span> 
		</div>
		<div class="phone_bill">
			<div class="phone_bill_i" style="color: red;">充话费</div>
			<!-- <div class="phone_bill_g">充流量</div> -->
			<div class="huanfei">
			</div>
			<div>
			
			<div class="clear"></div>
		</div>
	</div>
	<div class="s"></div>
	<button type="button" class="btn">
		立即充值
	</button>
</body>
<script>
var l;
var recharge;
var rechargeAmount;
var pageIndex = 0;
var pageSize = 8;
$(".phone_input").bind("click",  
		  function() {  
		     $(".phone_input")[0].focus();   
});  
$(".phone_bill_g").click(function(){
	$(this).css('color', 'red');
	$(".phone_bill_i").css('color', '#999');
	
	$.ajax({
		url:"/tjekuaitong/PayController/userPages",
		data:{"type":"流量充值","pageIndex":pageIndex,"pageSize":pageSize},
		success:function(data){
			console.info(data);
             var datas= eval(data);   
             var strVar = "";
             strVar += "<ul class=\"recharge_shu\"  data-recharge=\"bill_g\">\n";
             strVar += "					<li>"+datas[0].facePrice+"M<\/li>\n";
             strVar += "					<li>"+datas[0].orderCost+"<\/li>\n";
             strVar += "				<\/ul>\n";
             strVar += "				<ul class=\"recharge_shu_03\"  data-recharge=\"bill_g\">\n";
             strVar += "					<li>"+datas[1].facePrice+"M<\/li>\n";
             strVar += "					<li>"+datas[1].orderCost+"<\/li>\n";
             strVar += "				<\/ul>\n";
             strVar += "				<ul class=\"recharge_shu\"  data-recharge=\"bill_g\">\n";
             strVar += "					<li>"+datas[2].facePrice+"M<\/li>\n";
             strVar += "					<li>"+datas[2].orderCost+"<\/li>\n";
             strVar += "				<\/ul>\n";
             strVar += "				<ul class=\"recharge_shu\"  data-recharge=\"bill_g\">\n";
             strVar += "					<li>"+datas[3].facePrice+"M<\/li>\n";
             strVar += "					<li>"+datas[3].orderCost+"<\/li>\n";
             strVar += "				<\/ul>\n";
             strVar += "				<ul class=\"recharge_shu_03\"  data-recharge=\"bill_g\">\n";
             strVar += "					<li>"+datas[4].facePrice+"M<\/li>\n";
             strVar += "					<li>"+datas[4].orderCost+"<\/li>\n";
             strVar += "				<\/ul>\n";
             strVar += "				<ul class=\"recharge_shu\"  data-recharge=\"bill_g\">\n";
             strVar += "					<li>"+datas[5].facePrice+"M<\/li>\n";
             strVar += "					<li>"+datas[5].orderCost+"<\/li>\n";
             strVar += "				<\/ul>\n";
             $(".huanfei").html(strVar);
 			ss ();
		}
	});
});
$(".phone_bill_i").click(function(){
	$(this).css('color', 'red');
	$(".phone_bill_g").css('color', '#999');
	$.ajax({
		url:"/tjekuaitong/PayController/userPages",
		data:{"type":"手机充值","pageIndex":pageIndex,"pageSize":pageSize},
		success:function(data){
             var datas= eval(data);   
             var strVar = "";
             strVar += "<ul class=\"recharge_shu\"  data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[0].facePrice+"元<\/li>\n";
             strVar += "				<li id=\"ss\">"+datas[0].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu_03\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[1].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[1].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[2].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[2].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[3].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[3].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu_03\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[4].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[4].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[5].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[5].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
			$(".huanfei").html(strVar);
			ss ();
		}
	});
});
$(function(){
	$.ajax({
		url:"/tjekuaitong/PayController/userPages",
		data:{"type":"手机充值","pageIndex":pageIndex,"pageSize":pageSize},
		success:function(data){
             var datas= eval(data);   
             var strVar = "";
             strVar += "<ul class=\"recharge_shu\"  data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[0].facePrice+"元<\/li>\n";
             strVar += "				<li id=\"ss\">"+datas[0].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu_03\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[1].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[1].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[2].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[2].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[3].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[3].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu_03\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[4].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[4].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
             strVar += "			<ul class=\"recharge_shu\" data-recharge=\"bill\">\n";
             strVar += "				<li>"+datas[5].facePrice+"元<\/li>\n";
             strVar += "				<li>"+datas[5].orderCost+"<\/li>\n";
             strVar += "			<\/ul>\n";
			$(".huanfei").html(strVar);
			ss ();
		}
	});
	
});
	
	function ss (){
		$("ul").addClass("color1");
		$("ul").click(
				function() {
					var that = $(this);
					if (that.hasClass("color")) {
						that.removeClass("color").addClass("color1");
						that.attr("data-checked", "0");
					} else {
						that.addClass("color").removeClass("color1").attr(
								"data-checked", "1").siblings("ul")
								.removeClass("color").addClass("color1").attr(
										"data-checked", "0");
					}
					data = that.attr("data-checked");
				});
		
		
		$("ul").on("click",function(){    
			recharge =$(this).attr("data-recharge");
			console.info(recharge);
			if(recharge=="bill"){
				var arr=$(this).text().split("元");
				console.info(arr[0]);
				rechargeAmount=arr[0].replace(/(^\s*)|(\s*$)/g, "");
				l=arr[1].replace(/(^\s*)|(\s*$)/g, "");
			}else if(recharge=="bill_g"){
				var arr=$(this).text().split("M");
				console.info("arr[0]"+arr[0]);
				rechargeAmount=arr[0].replace(/(^\s*)|(\s*$)/g, "");
				l=arr[1].replace(/(^\s*)|(\s*$)/g, "");
			}
			
		 });
	}
	var w = document.documentElement.clientWidth;
	if (w > 640) {
		w = 640
	}
	document.documentElement.style.fontSize = 20 / 320 * w + 'px';
	window.onresize = function() {
		document.documentElement.style.fontSize = 20 / 320 * w + 'px';
	};
	
	$(".phone_input").on("blur", function() {
		var tel = $(this).val();
		if (tel == "") {
			return false;
		} else if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(tel))) {
			return false;
		}
	});
	//动态获取手机号输入获得手机号本人信息
	$('.phone_input').bind('input propertychange', function() {
		
		var phone = $(this).val();
		if (/^1\d{10}$/.test(phone)) {
			if ((/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))) {
				console.info(phone);
				$.ajax({
					url : "/tjekuaitong/mobileController/phone",
					dataType : "json",
					data : {
						"phoneNo" : phone
					},
					success : function(data) {
							console.info(data);
							var arr= data.detail.split(",");
							$(".name").html(arr[0]);
							$(".balance").html(arr[1]);
							$(".province").html(data.city);
					}
				});
			}
		}
	});
	var vip_j=<%=vip_j%>;
	//支付按钮
	$(".btn").click(function() {
		var phone = $('.phone_input').val();
		if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
			alert("请输入正确收手机号");
		}else{
			if(phone!=null&&l!=null&&recharge!=null&&phone!=""&&l!=""&&recharge!=""){
				if(l<=vip_j){
					if(window.confirm('你确定充值吗？')){
						window.location.href="/tjekuaitong/mobileController/vip?mobileNo="+phone+"&rechargeAmount1="+l+"&recharge="+recharge+"&rechargeAmount="+rechargeAmount+"&openId=<%=ss%>";
		                 return true;
		              }else{
		                 alert("取消");
		                 return false;
		             }
				
				}else{
					alert("积分不足");
				}
				}else{
				window.location.href="create-bill-fail.jsp";
				}
		}
	});
	
</script>

</html>