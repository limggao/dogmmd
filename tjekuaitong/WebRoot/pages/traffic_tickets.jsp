<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="description" content="">
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<script src="../js/jquery.min.js"></script>
		<link rel="stylesheet" href="../css/style.css">
		<title>交通罚单</title>
	</head>
	<%	String ss =request.getParameter("openId"); %>
	<body>
		<div class="phone_recharge">
			<div class="row">
				<form class="xinxi_op">
				<div class="jiaofei">
					<div class="type_box">
        <span class="type">省:</span>
                <select name="customSelectForm" id="selete1" class="selection">
                   
                </select>
         </div>
         <div class="type_box">
        <span class="type">市:</span>
                <select name="customSelectForm" id="selete2" class="selection">
                    <option value="1">请选择城市</option>
                </select>
         </div>
            <div class="clear"></div> 
         </div>
					<div class="form-group">
						<label class="game">输入车牌号</label>
						<input class="form-control game_sh brand" placeholder="输入车牌号">
					</div>
					<div class="form-group">
						<label class="game">输入发动机号</label>
						<input type="number" class="form-control game_sh engine" placeholder="输入发动机号">
					</div>
					<div class="form-group">
						<label class="game">违章单号</label>
						<input type="number" class="form-control game_sh violation " placeholder="请您输入违章单号">
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-xs-2 control-label i_olua game">罚金</label>
						<div class="col-sm-5 col-xs-9 shu_ru">
							<input type="number" class="form-control  ba_jd_0i fine" >
						</div>
						<div class="game_02">元</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-xs-2 control-label i_olua game">滞纳金</label>
						<div class="col-sm-5 col-xs-9 shu_ru">
							<input type="number" class="form-control  ba_jd_0i Late_fee" >
						</div>
						<div class="game_02">元</div>
					</div>
				</form>
			</div>
			<div class="phone_bill">
				<div class="phone_bill_i">手续费</div>
				<div class="fadan">
				</div>
				
				<div class="clear"></div>
			</div>
		</div>
		 <button type="button" class="btn">立即充值</button>
	</body>
	<script>
	var pageIndex = 0;
	var pageSize = 8;
	var rechargeAmount1;
	var recharge='bill_car';
	var rechargeAmount;
	var brand;
	var engine;
	var violation;
	var fine;
	var Late_fee;
	var city;
	var province;
	var values;
	$(function() {
		
		$.ajax({
			url:"/tjekuaitong/provinceController/province",
			dataType:"json",
			success:function(data){
				var ss="<option value='请选择省份'>请选择省份</option>";
				$.each(data,function(index,datas){
					ss +="<option  value='"+datas.id+"'>"+datas.province+"</option>";
				});
				$("#selete1").html(ss);
			}
		});
		$("#selete1").change(function(){
			var value = $("#selete1 option:selected").val();
			 values = $("#selete1 option:selected").text();
			if(value=='请选择省份'){
				$("#selete2").html("<option value='请选择城市'>请选择城市</option>");
				return;
			}
			console.info(value);
			$.ajax({
				url:"/tjekuaitong/provinceController/city",
				data:{"id":value},
				dataType:"json",
				success:function(data){
					var ss="<option value='请选择城市'>请选择城市</option>";
					$.each(data,function(index,datas){
						ss +="<option value='"+datas.id+"'>"+datas.city+"</option>";
					});
					$("#selete2").html(ss);
				}
			});
			
			$.ajax({
				url : "/tjekuaitong/PayController/userPages",
				data : {
					"type" : "交通缴费",
					"pageIndex" : pageIndex,
					"pageSize" : pageSize
				},
				success : function(data) {
					console.info(data);
					var datas = eval(data);
					if(values=='天津'){
						$(".fadan").html(datas[0].orderCost);
					}else{
						$(".fadan").html(datas[1].orderCost);
					}
				}
			});

});
			
			});
		
		
			
	/* function ss() {
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
			 if(recharge=="bill_car"){
				var arr=$(this).text().split("元");
				rechargeAmount=arr[0].replace(/(^\s*)|(\s*$)/g, ""); 
				rechargeAmount1=arr[1].replace(/(^\s*)|(\s*$)/g, ""); 
			} 
			
		 });
	} */
	
	
		var w = document.documentElement.clientWidth;
		if(w > 640) {
			w = 640;
		}
		document.documentElement.style.fontSize = 20 / 320 * w + 'px';
		window.onresize = function() {
			document.documentElement.style.fontSize = 20 / 320 * w + 'px';
		};
		//点击改变按钮颜色
		$(function() {
           
            $(".phone_input").on("blur", function() {
                var tel = $(this).val();
                if(tel == "") {
                    return false;
                } else if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(tel))) {
                    return false;
                }
            });
        });
		
		 //获取点击的ul是什么
        
		
		
		$(".btn").click(function(){
			brand =$(".brand").val();
			engine =$(".engine").val();
			violation =$(".violation").val();
			fine =$(".fine").val();
			Late_fee =$(".Late_fee").val();
			province= $("#selete1 option:selected").text();
			city =$("#selete2 option:selected").text();
			rechargeAmount=fine;
			rechargeAmount1=(fine*1 + Late_fee*1) + $(".fadan").html()*1;
			if(province=='请选择省份'||city=='请选择城市'){
				alert("请选择省份或城市");
			}else{
				if(engine!=null&&violation!=null&&brand!=null&&fine!=null&&Late_fee!=null&&brand!=""&&engine!=""&&violation!=""&&fine!=""&&Late_fee!=""){
					if(rechargeAmount1!=null&&recharge!=null&&rechargeAmount!=null&&rechargeAmount1!=""&&rechargeAmount!=""&&recharge!=""){
						window.location.href="payment_method.jsp?brand="+brand+"&rechargeAmount1="+rechargeAmount1+"&recharge="+recharge+"&rechargeAmount="+rechargeAmount+"&engine="+engine+"&violation="+violation+"&fine="+fine+"&Late_fee="+Late_fee+"&province="+province+"&city="+city+"&openId=<%=ss%>";
						}else{
						window.location.href="create-bill-fail.jsp";
						} 
				}else{
					alert("信息不能为空");
				}
			}
		});
        
		
		
	</script>

</html>