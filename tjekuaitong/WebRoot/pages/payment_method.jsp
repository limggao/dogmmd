<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="../js/jquery.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<title>支付方式</title>
</head>
<body>
	<nav class="method_box">
	<div class="method">支付方式</div>
	<div id="wx" class="method_ic" style="display: none;">
		<div class="weixin">
			<img src="../images/iocn/weixin.png" alt="">
		</div>
		<div class="text_wei">微信支付</div>
		<div class="radio xuanzhon"><!-- 默认选择 checked -->
			<label> <input type="radio" name="optionsRadios" data-recharge="optionsRadios1" class="xuanze"
				id="optionsRadios1" value="option1"
				style="height: 0.8rem; width: 0.8rem" />
			</label>
		</div>
	</div>
	<div id="zfb" class="method_ic" style="display: none;">
		<div class="weixin">
			<img src="../images/iocn/zhifubao.png" alt="">
		</div>
		<div class="text_wei zhifubao_z">支付宝支付</div>
		<div class="radio xuanzhon">
			<label> <input type="radio" name="optionsRadios" data-recharge="optionsRadios2" class="xuanze"
				id="optionsRadios2" value="option2"
				style="height: 0.8rem; width: 0.8rem" />
			</label>
		</div>
	</div>
	<div id="yh" class="method_ic" style="display: none;">
		<div class="weixin">
			<img src="../images/iocn/abcicon1.jpg" alt="">
		</div>
		<div class="text_wei" style="color: #009882">农行支付</div>
		<div class="radio xuanzhon">
			<label> <input type="radio" name="optionsRadios" data-recharge="optionsRadios3" class="xuanze"
				id="optionsRadios3" value="option3"
				style="height: 0.8rem; width: 0.8rem" />
			</label>
		</div>
	</div>
	<!-- <div id="kj" class="method_ic" style="display: none;">
		<div class="weixin">
			<img src="../images/iocn/weixin.png" alt="">
		</div>
		<div class="text_wei">微信支付</div>
		<div class="radio xuanzhon">
			<label> <input type="radio" name="optionsRadios" data-recharge="optionsRadios4" class="xuanze"
				id="optionsRadios4" value="option4"
				style="height: 0.8rem; width: 0.8rem" />
			</label>
		</div>
	</div> -->
	<div class="clear"></div>
	</nav>
	<button type="button" class="btn btn-primary btn-lg">
		立即充值
	</button>
</body>
<script>
	
	$.ajax({
		url:"/tjekuaitong/provinceController/paymentMethod",
		dataType:"json",
		success:function(data){
			$.each(data,function(index,datas){
				if(datas.type=='zfb'){
					console.info("zfb1:"+datas.type);
					console.info("zfb:"+datas.state);
					$("#zfb").css({"display":datas.state});
				}
				else if(datas.type=='wx'){
					console.info("wx1:"+datas.type);
					console.info("wx:"+datas.state);
					$("#wx").css({"display":datas.state});
				}
				else if(datas.type=='yh'){
					console.info("yh1:"+datas.type);
					console.info("yh:"+datas.state);
					$("#yh").css({"display":datas.state});
				}
			});
			
		}
	});
	
	var w = document.documentElement.clientWidth;
	if (w > 640) {
		w = 640;
	}
	document.documentElement.style.fontSize = 20 / 320 * w + 'px';
	window.onresize = function() {
		document.documentElement.style.fontSize = 20 / 320 * w + 'px';
	};
	
	<%
		//手机号
		String mobileNo = request.getParameter("mobileNo");
		//千米金额
		String rechargeAmount = request.getParameter("rechargeAmount");
		//支付金额
		String rechargeAmount1 = request.getParameter("rechargeAmount1");
		//充值类型
		String recharge = request.getParameter("recharge");
		//加油卡姓名
		String gasCardName = request.getParameter("gasCardName");
		//加油卡号
		String gasCardNo = request.getParameter("gasCardNo");
		//车牌号
		String brand = request.getParameter("brand");
		//联通或电信
		String type = request.getParameter("type");
		//发动机号
		String engine = request.getParameter("engine");
		//违章号
		String violation = request.getParameter("violation");
		//罚金
		String fine = request.getParameter("fine");
		//滞纳金
		String Late_fee = request.getParameter("Late_fee");
		//游戏账号
		String account = request.getParameter("account");
		//游戏名字
		String name = request.getParameter("name");
		//openId
		String openId=request.getParameter("openId");
		//province省份
		String province =request.getParameter("province");
		//城市
		String city =request.getParameter("city");
		rechargeAmount=rechargeAmount.trim();
		rechargeAmount1=rechargeAmount1.trim();
		province=province ==null ? null:new String(province.getBytes("ISO-8859-1"),"UTF-8");
		city=city ==null ? null:new String(city.getBytes("ISO-8859-1"),"UTF-8");
		name=name ==null ? null:new String(name.getBytes("ISO-8859-1"),"UTF-8");
		brand=brand ==null ? null:new String(brand.getBytes("ISO-8859-1"),"UTF-8");
		engine=engine ==null ? null:new String(engine.getBytes("ISO-8859-1"),"UTF-8");
		violation=violation ==null ? null:new String(violation.getBytes("ISO-8859-1"),"UTF-8"); 
		type=type ==null ? null:new String(type.getBytes("ISO-8859-1"),"UTF-8");
		gasCardName =gasCardName ==null ? null:new String(gasCardName.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("name:"+name);
		System.out.println("type:"+type);
		System.out.println("mobileNo:"+mobileNo);
		System.out.println("rechargeAmount:"+rechargeAmount);
		System.out.println("rechargeAmount1:"+rechargeAmount1);
		System.out.println("recharge:"+recharge);
		System.out.println("gasCardName:"+gasCardName);
		System.out.println("province:"+province);
		System.out.println("city:"+city);
		//System.out.println(gasCardNo);
		//String recharge = request.getParameter("recharge");
		//String recharge = request.getParameter("recharge");
		//String recharge = request.getParameter("recharge");
	%>
	$(".btn").click(function(){
		var optionsRadio = "";
		var optionsRadios=document.getElementsByName("optionsRadios");
		for (var i = 0; i < optionsRadios.length; i++) {
			if(optionsRadios[i].checked){
				optionsRadio=optionsRadios[i].value;
				console.info(optionsRadio);
				} 
		}
		//console.info(optionsRadios);
		if(optionsRadio==null||optionsRadio==""){
			alert("请选择支付方式");
			return;
		}
		//电话
		var data={
				"mobileNo" : "<%=mobileNo%>",
				"rechargeAmount" : "<%=rechargeAmount%>",
				"rechargeAmount1" : "<%=rechargeAmount1%>",
				"openId":"<%=openId%>",
				"optionsRadio":optionsRadio
			};
		//流量
		var data1={
				"mobileNo" : "<%=mobileNo%>",
				"flow" : "<%=rechargeAmount%>M",
				"rechargeAmount1" : "<%=rechargeAmount1%>",
				"openId":"<%=openId%>",
				"optionsRadio":optionsRadio
		};
		//加油卡充值
		 var data2={
				"mobileNo" : "<%=mobileNo%>",
				"rechargeAmount" : "<%=rechargeAmount%>",
				"rechargeAmount1" : "<%=rechargeAmount1%>",
				"gasCardName" : "<%=gasCardName%>",
				"gasCardNo" : "<%=gasCardNo%>",
				"openId":"<%=openId%>",
				"optionsRadio":optionsRadio
		}; 
		 //固话
		var data3={
				"mobileNo" : "<%=mobileNo%>",
				"rechargeAmount" : "<%=rechargeAmount%>",
				"rechargeAmount1" : "<%=rechargeAmount1%>",
				"type":"<%=type%>",
				"openId":"<%=openId%>",
				"optionsRadio":optionsRadio
		};
		//QB
		var data4={
				"mobileNo" :"<%=mobileNo%>",
				"rechargeAmount" : "<%=rechargeAmount%>",
				"rechargeAmount1" : "<%=rechargeAmount1%>",
				"openId":"<%=openId%>",
				"optionsRadio":optionsRadio
		};
		//游戏
		var data5={
				"account" :"<%=account%>",
				"rechargeAmount" : "<%=rechargeAmount%>",
				"rechargeAmount1" : "<%=rechargeAmount1%>",
				"name" :"<%=name%>",
				"openId":"<%=openId%>",
				"optionsRadio":optionsRadio
		};
		//交通罚款
		var data6={
				
				"brand" :"<%=brand%>",
				"rechargeAmount" : "<%=rechargeAmount%>",
				"rechargeAmount1" : "<%=rechargeAmount1%>",
				"engine" :"<%=engine%>",
				"Late_fee" :"<%=Late_fee%>",
				"violation":"<%=violation%>",
				"fine":"<%=fine%>",
				"openId":"<%=openId%>",
				"city":"<%=city%>",
				"province":"<%=province%>",
				"optionsRadio":optionsRadio
		};
		//判断支付方式
		//微信支付
		if(optionsRadio=="option1"){
			console.info("<%=rechargeAmount%>");
				 //电话流量
				if ( "<%=recharge%>" == "bill_g") {
					
					$.ajax({
						url : "/tjekuaitong/mobileController/mobileCreatelow",
						dataType : "json",
						data :data1,
						success:function(data){
							console.info(data);
							if(data!=null&&data!=""){
								var datas="brcb_gateway_url="+data.brcb_gateway_url+"&body="+data.body+"&mch_id="+data.mch_id+"&nonce_str="+data.nonce_str+"&notify_url="+data.notify_url+"&out_trade_no="+data.out_trade_no+"&service_type="+data.service_type+"&sign="+data.sign+"&spbill_create_ip="+data.spbill_create_ip+"&total_fee="+data.total_fee+"&attach="+data.attach;
								window.location.href=data.guodu+datas;
							}else{
								window.location.href="create-bill-fail.jsp";
							}
							
						}
					});
					//电话
				} else if ( "<%=recharge%>"== "bill") {
					 $.ajax({
						url : "/tjekuaitong/mobileController/createBill",
						dataType : "json",
						data :data,
						success:function(data){
							if(data!=null&&data!=""){
								var datas="brcb_gateway_url="+data.brcb_gateway_url+"&body="+data.body+"&mch_id="+data.mch_id+"&nonce_str="+data.nonce_str+"&notify_url="+data.notify_url+"&out_trade_no="+data.out_trade_no+"&service_type="+data.service_type+"&sign="+data.sign+"&spbill_create_ip="+data.spbill_create_ip+"&total_fee="+data.total_fee+"&attach="+data.attach;
								window.location.href=data.guodu+datas;
							}else{
								window.location.href="create-bill-fail.jsp";
							}
						}
					}); 
				 //加油卡充值
				}else if("<%=recharge%>"== "bill_i"){
					
					 $.ajax({
						url : "/tjekuaitong/mobileController/mobileGasCard",
						dataType : "json",
						data :data2,
						success:function(data){
							console.info(data);
							if(data!=null&&data!=""){
								var datas="brcb_gateway_url="+data.brcb_gateway_url+"&body="+data.body+"&mch_id="+data.mch_id+"&nonce_str="+data.nonce_str+"&notify_url="+data.notify_url+"&out_trade_no="+data.out_trade_no+"&service_type="+data.service_type+"&sign="+data.sign+"&spbill_create_ip="+data.spbill_create_ip+"&total_fee="+data.total_fee+"&attach="+data.attach;
								window.location.href=data.guodu+datas;
							}else{
								window.location.href="create-bill-fail.jsp";
							}
						}
					}); 
					 //固话
				}else if("<%=recharge%>"== "bill_K"){
					$.ajax({
						url : "/tjekuaitong/mobileController/mobileDirectRecharge",
						dataType : "json",
						data :data3,
						success:function(data){
							console.info(data);
							if(data!=null&&data!=""){
								var datas="brcb_gateway_url="+data.brcb_gateway_url+"&body="+data.body+"&mch_id="+data.mch_id+"&nonce_str="+data.nonce_str+"&notify_url="+data.notify_url+"&out_trade_no="+data.out_trade_no+"&service_type="+data.service_type+"&sign="+data.sign+"&spbill_create_ip="+data.spbill_create_ip+"&total_fee="+data.total_fee+"&attach="+data.attach;
								window.location.href=data.guodu+datas;
							}else{
								window.location.href="create-bill-fail.jsp";
							}
						}
					});  
					//QB
				} else if("<%=recharge%>"== "bill_Q"){
					$.ajax({
						url : "/tjekuaitong/mobileController/mobileQb",
						dataType : "json",
						data :data4,
						success:function(data){
							console.info(data);
							if(data!=null&&data!=""){
								var datas="brcb_gateway_url="+data.brcb_gateway_url+"&body="+data.body+"&mch_id="+data.mch_id+"&nonce_str="+data.nonce_str+"&notify_url="+data.notify_url+"&out_trade_no="+data.out_trade_no+"&service_type="+data.service_type+"&sign="+data.sign+"&spbill_create_ip="+data.spbill_create_ip+"&total_fee="+data.total_fee+"&attach="+data.attach;
								window.location.href=data.guodu+datas;
							}else{
								window.location.href="create-bill-fail.jsp";
							}
						}
					});  
					
				//游戏
				}else if("<%=recharge%>"== "bill_game"){
					$.ajax({
						url : "/tjekuaitong/mobileController/mobileGame",
						dataType : "json",
						data :data5,
						success:function(data){
							console.info(data);
							if(data!=null&&data!=""){
								var datas="brcb_gateway_url="+data.brcb_gateway_url+"&body="+data.body+"&mch_id="+data.mch_id+"&nonce_str="+data.nonce_str+"&notify_url="+data.notify_url+"&out_trade_no="+data.out_trade_no+"&service_type="+data.service_type+"&sign="+data.sign+"&spbill_create_ip="+data.spbill_create_ip+"&total_fee="+data.total_fee+"&attach="+data.attach;
								window.location.href=data.guodu+datas;
							}else{
								window.location.href="create-bill-fail.jsp";
							}
						}
					});  
					//交通罚款
				}else if("<%=recharge%>"== "bill_car"){
					$.ajax({
						url : "/tjekuaitong/mobileController/mobileTrafficFine",
						dataType : "json",
						data :data6,
						success:function(data){
							console.info(data);
							if(data!=null&&data!=""){
								var datas="brcb_gateway_url="+data.brcb_gateway_url+"&body="+data.body+"&mch_id="+data.mch_id+"&nonce_str="+data.nonce_str+"&notify_url="+data.notify_url+"&out_trade_no="+data.out_trade_no+"&service_type="+data.service_type+"&sign="+data.sign+"&spbill_create_ip="+data.spbill_create_ip+"&total_fee="+data.total_fee+"&attach="+data.attach;
								window.location.href=data.guodu+datas;
							}else{
								window.location.href="create-bill-fail.jsp";
							}
						}
					});  
				} 
			//支付宝支付	 
		}else if(optionsRadio=="option2"){
			console.info("<%=rechargeAmount%>");
			console.info("2222");
			console.info("<%=recharge%>");
			if ( "<%=recharge%>" == "bill") {
				console.info("2222");
				//电话
				$.ajax({
					url : "/tjekuaitong/mobileController/createBill",
					dataType : "json",
					data :data,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				}); 
				//流量
			}else if ( "<%=recharge%>" == "bill_g") {
				
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileCreatelow",
					dataType : "json",
					data :data1,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
						
					}
				});
				//加油卡
			}else if("<%=recharge%>"== "bill_i"){
				
				 $.ajax({
					url : "/tjekuaitong/mobileController/mobileGasCard",
					dataType : "json",
					data :data2,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				}); 
				 //固话
			}else if("<%=recharge%>"== "bill_K"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileDirectRecharge",
					dataType : "json",
					data :data3,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
				//QB
			} else if("<%=recharge%>"== "bill_Q"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileQb",
					dataType : "json",
					data :data4,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
				
			//游戏
			}else if("<%=recharge%>"== "bill_game"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileGame",
					dataType : "json",
					data :data5,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
				//交通罚款
			}else if("<%=recharge%>"== "bill_car"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileTrafficFine",
					dataType : "json",
					data :data6,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
			} 
			//农行
		}else if(optionsRadio=="option3"){
			console.info("<%=rechargeAmount%>");
			console.info("3333");
			console.info("<%=recharge%>");
			if ( "<%=recharge%>" == "bill") {
				console.info("3333");
				//电话
				$.ajax({
					url : "/tjekuaitong/mobileController/createBill",
					dataType : "json",
					data :data,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				}); 
				//流量
			}else if ( "<%=recharge%>" == "bill_g") {
				
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileCreatelow",
					dataType : "json",
					data :data1,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
						
					}
				});
				//加油卡
			}else if("<%=recharge%>"== "bill_i"){
				
				 $.ajax({
					url : "/tjekuaitong/mobileController/mobileGasCard",
					dataType : "json",
					data :data2,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				}); 
				 //固话
			}else if("<%=recharge%>"== "bill_K"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileDirectRecharge",
					dataType : "json",
					data :data3,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
				//QB
			} else if("<%=recharge%>"== "bill_Q"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileQb",
					dataType : "json",
					data :data4,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
				
			//游戏
			}else if("<%=recharge%>"== "bill_game"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileGame",
					dataType : "json",
					data :data5,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
				//交通罚款
			}else if("<%=recharge%>"== "bill_car"){
				$.ajax({
					url : "/tjekuaitong/mobileController/mobileTrafficFine",
					dataType : "json",
					data :data6,
					success:function(data){
						console.info(data);
						if(data!=null&&data!=""){
							window.location.href="zhifubao.jsp?url="+data.qrcode;
						}else{
							window.location.href="create-bill-fail.jsp";
						}
					}
				});  
			} 
		}
		
	});
	 
</script>
</html>