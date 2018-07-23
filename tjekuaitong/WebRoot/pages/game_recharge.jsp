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
<link rel="stylesheet" href="../css/style.css">
<title>游戏充值</title>
</head>
<%	String ss =request.getParameter("openId"); %>
<body>
	<div class="phone_recharge">
		<div class="row">
			<form class="xinxi_op">
				<div class="form-group">
					<label class="game">输入游戏名称</label> <input type="text"
						class="form-control game_sh name" placeholder="请您输入游戏名称">
				</div>
				<div class="form-group">
					<label class="game">输入游戏账户</label> <input type="text"
						class="form-control game_sh account" placeholder="请您输入游戏账户">
				</div>
			</form>
		</div>
		<div class="phone_bill">
			<div class="phone_bill_i">充值金额</div>
			<div class="youxi">
				<!-- <ul class="recharge_shu_04" data-recharge="bill_game">
					<li>100元</li>
					<li>98</li>
				</ul>
				<ul class="recharge_shu_03" data-recharge="bill_game">
					<li>300元</li>
					<li>298</li>
				</ul>
				<ul class="recharge_shu_04" data-recharge="bill_game">
					<li>500元</li>
					<li>450</li>
				</ul>
				<ul class="recharge_shu_04" data-recharge="bill_game">
					<li>800元</li>
					<li>730</li>
				</ul>
				<ul class="recharge_shu_03" data-recharge="bill_game">
					<li>1000元</li>
					<li>890</li>
				</ul>
				<ul class="recharge_shu_04" data-recharge="bill_game">
					<li>1200元</li>
					<li>1050</li>
				</ul> -->
			</div>

			<div class="clear"></div>
		</div>
	</div>
	<button type="button" class="btn">立即充值</button>
</body>
<script>
	var rechargeAmount1;
	var recharge;
	var rechargeAmount;
	var pageIndex = 0;
	var pageSize = 8;
	var account;
	var name;
	$(function() {
		$
				.ajax({
					url : "/tjekuaitong/PayController/userPages",
					data : {
						"type" : "游戏充值",
						"pageIndex" : pageIndex,
						"pageSize" : pageSize
					},
					success : function(data) {
						console.info(data);
						var datas = eval(data);
						var strVar = "";
						strVar += "<ul class=\"recharge_shu_04\" data-recharge=\"bill_game\">\n";
						strVar += "					<li>"+datas[0].facePrice+"元<\/li>\n";
						strVar += "					<li>"+datas[0].orderCost+"<\/li>\n";
						strVar += "				<\/ul>\n";
						strVar += "				<ul class=\"recharge_shu_03\" data-recharge=\"bill_game\">\n";
						strVar += "					<li>"+datas[1].facePrice+"元<\/li>\n";
						strVar += "					<li>"+datas[1].orderCost+"<\/li>\n";
						strVar += "				<\/ul>\n";
						strVar += "				<ul class=\"recharge_shu_04\" data-recharge=\"bill_game\">\n";
						strVar += "					<li>"+datas[2].facePrice+"元<\/li>\n";
						strVar += "					<li>"+datas[2].orderCost+"<\/li>\n";
						strVar += "				<\/ul>\n";
						strVar += "				<ul class=\"recharge_shu_04\" data-recharge=\"bill_game\">\n";
						strVar += "					<li>"+datas[3].facePrice+"元<\/li>\n";
						strVar += "					<li>"+datas[3].orderCost+"<\/li>\n";
						strVar += "				<\/ul>\n";
						strVar += "				<ul class=\"recharge_shu_03\" data-recharge=\"bill_game\">\n";
						strVar += "					<li>"+datas[4].facePrice+"元<\/li>\n";
						strVar += "					<li>"+datas[4].orderCost+"<\/li>\n";
						strVar += "				<\/ul>\n";
						strVar += "				<ul class=\"recharge_shu_04\" data-recharge=\"bill_game\">\n";
						strVar += "					<li>"+datas[5].facePrice+"元<\/li>\n";
						strVar += "					<li>"+datas[5].orderCost+"<\/li>\n";
						strVar += "				<\/ul>\n";
						$(".youxi").html(strVar);
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
			if (recharge == "bill_game") {
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
	

	//获取点击的ul是什么

	
	$(".btn").click(
			function() {
				name = $(".name").val();
				account = $(".account").val();
				console.info(account);
				if (account != null && name != null && account != ""
						&& name != "") {
					if (rechargeAmount1 != null && recharge != null
							&& rechargeAmount != null && rechargeAmount1 != ""
							&& rechargeAmount != "" && recharge != "") {
						window.location.href = "payment_method.jsp?name="
								+ name + "&rechargeAmount1=" + rechargeAmount1
								+ "&recharge=" + recharge + "&rechargeAmount="
								+ rechargeAmount + "&account=" + account+"&openId=<%=ss%>";
					} else {
						window.location.href = "create-bill-fail.jsp";
					}
				} else {
					alert("请输入用户信息！");
				}

			});
</script>
</html>