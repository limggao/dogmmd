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
<script type="text/javascript" src="../js/zepto.min.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper.min.js"></script>
<link rel="stylesheet" href="../css/swiper.min.css" />
<link rel="stylesheet" href="../css/tab_xia.css" />
<link rel="stylesheet" href="../css/index.css">
<title>话费充值</title>
<style type="text/css">
.swiper-wrapper{
    width: 454px;
    height: 627.563px;
}
</style>
</head>
<%	String ss =request.getParameter("openId"); %>
<body>
	<div class="wrap">
		<div class="tabs">
			<span class="part active"><a href="#" name="a"
				hidefocus="true">联通</a></span> <span class="part"><a href="#"
				name="a" hidefocus="true">电信</a></span>
		</div>
		<div class="swiper-container">
			<div class="swiper-wrapper" >
				<div class="swiper-slide swiper-slide-visible swiper-slide-active">
					<div class="content-slide">
						<div class="i_com_g">
							<div class="phone">
								<form>
									<input type="text" placeholder="022-&nbsp;6666&nbsp;8888"
										style="font-size: 1rem; font-weight: 600; color: #4c4c4c;"
										value="" class="phone_input num1" />
								</form>
								<span class="iocn_r"> <img
									src="../images/iocn/guhuachobngzhi.png" alt="">
								</span>
							</div>
							<div class="phone_bill">
								<div class="phone_bill_i">选择金额</div>
								<div class="guhua">
									 
									
								</div>

								<div class="clear"></div>
							</div>
						</div>
					</div>
					<button type="button" class="btn">立即充值</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	var rechargeAmount1;
	var recharge;
	var rechargeAmount;
	var pageIndex = 0;
	var pageSize = 8;
	$(function() {
		$
				.ajax({
					url : "/tjekuaitong/PayController/userPages",
					data : {
						"type" : "天津固话充值",
						"pageIndex" : pageIndex,
						"pageSize" : pageSize
					},
					success : function(data) {
						console.info(data);
						var datas = eval(data);
						var strVar = "";
					    strVar += "<ul class=\"recharge_shu\" data-recharge=\"bill_K\">\n";
					    strVar += "										<li>"+datas[0].facePrice+"元<\/li>\n";
					    strVar += "										<li>"+datas[0].orderCost+"<\/li>\n";
					    strVar += "									<\/ul>\n";
					    strVar += "									<ul class=\"recharge_shu_03\" data-recharge=\"bill_K\">\n";
					    strVar += "										<li>"+datas[1].facePrice+"元<\/li>\n";
					    strVar += "										<li>"+datas[1].orderCost+"<\/li>\n";
					    strVar += "									<\/ul>\n";
					    strVar += "									<ul class=\"recharge_shu\" data-recharge=\"bill_K\">\n";
					    strVar += "										<li>"+datas[2].facePrice+"元<\/li>\n";
					    strVar += "										<li>"+datas[2].orderCost+"<\/li>\n";
					    strVar += "									<\/ul>\n";
					    strVar += "									<ul class=\"recharge_shu\" data-recharge=\"bill_K\">\n";
					    strVar += "										<li>"+datas[3].facePrice+"元<\/li>\n";
					    strVar += "										<li>"+datas[3].orderCost+"<\/li>\n";
					    strVar += "									<\/ul>\n";
					    strVar += "									<ul class=\"recharge_shu_03\" data-recharge=\"bill_K\">\n";
					    strVar += "										<li>"+datas[4].facePrice+"元<\/li>\n";
					    strVar += "										<li>"+datas[4].orderCost+"<\/li>\n";
					    strVar += "									<\/ul>\n";
					    strVar += "									<ul class=\"recharge_shu\" data-recharge=\"bill_K\">\n";
					    strVar += "										<li>"+datas[5].facePrice+"元<\/li>\n";
					    strVar += "										<li>"+datas[5].orderCost+"<\/li>\n";
					    strVar += "									<\/ul>\n";
						$(".guhua").html(strVar);
						ss();
					}
				});

	});
	function ss() {
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

		$("ul").on("click", function() {
			recharge = $(this).attr("data-recharge");
			console.info(recharge);
			if (recharge == "bill_K") {
				var arr = $(this).text().split("元");
				rechargeAmount = arr[0];
				rechargeAmount1 = arr[1];
			}

		});
	}
	var w = document.documentElement.clientWidth;
	if (w > 640) {
		w = 640;
	}
	document.documentElement.style.fontSize = 20 / 320 * w + 'px';
	window.onresize = function() {
		document.documentElement.style.fontSize = 20 / 320 * w + 'px';
	};
</script>

<script type="text/javascript">
	var type = "联通";
	$(function() {

		$(".phone_input").on("blur", function() {
			var tel = $(this).val();
			if (tel == "") {
				return false;
			} else if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(tel))) {
				return false;
			}
		});

		var tabsSwiper;
		tabsSwiper = new Swiper('.swiper-container', {
			speed : 500,
			onSlideChangeStart : function() {
				$(".tabs .active").removeClass('active');
				$(".tabs span").eq(tabsSwiper.activeIndex).addClass('active');
			}
		});
		$(".tabs span").on('touchstart mousedown', function(e) {
			e.preventDefault()
			$(".tabs .active").removeClass('active');
			$(this).addClass('active');
			type = $(this).text();
			//alert($(this).text());
			tabsSwiper.swipeTo($(this).index());

		});
		$(".tabs span").click(function(e) {
			e.preventDefault();

		});
	});

	//获取点击的ul是什么

	var phone;
	$(".btn").click(
			function() {
				phone = $(".num1").val();
				console.info(phone);
				console.info(type);
				//if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))) {
					//alert("请输入正确收手机号");
				//} else {
					if (phone != null && rechargeAmount1 != null
							&& recharge != null && rechargeAmount != null
							&& phone != "" && rechargeAmount1 != ""
							&& rechargeAmount != "" && recharge != "") {
						window.location.href = "payment_method.jsp?mobileNo="
								+ phone + "&rechargeAmount1=" + rechargeAmount1
								+ "&recharge=" + recharge + "&rechargeAmount="
								+ rechargeAmount + "&type=" + type+"&openId=<%=ss%>";
					} else {
						window.location.href = "create-bill-fail.jsp";
					}
				//}
			});
</script>
</html>