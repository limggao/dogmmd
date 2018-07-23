<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="description" content="">
		<meta name="renderer"content="webkit">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="../js/jquery.min.js"></script>
		<link rel="stylesheet" href="../css/swiper.min.css">
		<link rel="stylesheet" href="../css/index.css">
		<title>易快通</title>
		
	</head>
	
	<body>
		<!--头部信息开始-->
		<header class="information">
			<div class="head_portrait">
				<img src="${headimgurl }" alt="">
			</div>
			<div class="ip_information">
				<h5 class="head_m">${name }</h5>
				<div class="vip_integral">
					<span class="huiyuan">会员ID:${data}</span>
					<span class="vip_j"></span>
					<span>会员积分：${vip_j }分</span>
				<span><a href="../pages/phone_recharge1.jsp?openId=${openId }">积分充值</a></span>
				</div>
			</div>
		</header>
		<!--头部信息结束-->
		<!--轮播开始-->
		<div class="ad-hot">
			<div id="ad-swiper" class="swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide banner_01">
						<a href="#/"><img src="../images/banner.jpg" alt=""></a>
					</div>
					<div class="swiper-slide banner_01">
						<a href="#/"><img src="../images/banner.jpg" alt=""></a>
					</div>
					<div class="swiper-slide banner_01">
						<a href="#/"><img src="../images/banner.jpg" alt=""></a>
					</div>
				</div>
				<!-- Add Pagination -->
				<div class="swiper-pagination"></div>
			</div>
		</div>
		<!--轮播结束-->
		<!--充值分类开始-->
		<div class="recharge">
			<div class="iocn_p">
				<a href="../pages/phone_recharge.jsp?openId=${openId }">
					<div class="phone_iocn">
						<img src="../images/iocn/phone.png" alt="">
					</div>
					<div class="iocn_text">手机充值</div>
				</a>
			</div>
			<div class="iocn_p">
				<a href="http://mall.slswd.com/">
					<div class="phone_iocn">
						<img src="../images/iocn/chonhzi_01.png" alt="">
					</div>
					<div class="iocn_text">手拉手</div>
				</a>
			</div>
			<div class="iocn_p_3">
				<a href="../pages/game_recharge.jsp?openId=${openId }">
					<div class="phone_iocn">
						<img src="../images/iocn/game.png" alt="">
					</div>
					<div class="iocn_text">游戏充值</div>
				</a>
			</div>
			<div class="iocn_p">
				<a href="../pages/recharge_Q_coins.jsp?openId=${openId }">
					<div class="phone_iocn">
						<img src="../images/iocn/QQ.png" alt="">
					</div>
					<div class="iocn_text">Q币充值</div>
				</a>
			</div>
			<div class="iocn_p">
				<a href="../pages/fixed_recharge.jsp?openId=${openId }">
					<div class="phone_iocn">
						<img src="../images/iocn/guhua.png" alt="">
					</div>
					<div class="iocn_text">天津固话充值</div>
				</a>
			</div>
			<div class="iocn_p_3">
				<a href="../pages/traffic_tickets.jsp?openId=${openId }">
					<div class="phone_iocn">
						<img src="../images/iocn/fakuan.png" alt="">
					</div>
					<div class="iocn_text">交通罚款</div>
				</a>
			</div>
			<div class="iocn_p">
				<a href="../pages/Application_card.jsp?openId=${openId }">
					<div class="phone_iocn">
						<img src="../images/iocn/VISA.png" alt="">
					</div>
					<div class="iocn_text">申请信用卡</div>
				</a>
			</div>
			<div class="iocn_p">
				<a href="#/">
					<div class="phone_iocn">
						<img src="../images/iocn/zhuanfa.png" alt="">
					</div>
					<div class="iocn_text">转发赚积分</div>
				</a>
			</div>
			<div class="iocn_p_3">
				<a href="../pages/tuiguang.jsp?openId=${openId }">
					<div class="phone_iocn">
						<img src="../images/iocn/tuiguang.png" alt="">
					</div>
					<div class="iocn_text">推广赚积分</div>
				</a>
			</div>
			<div class="clear"></div>
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
		};

	</script>
	<script src="../js/swiper.min.js"></script>
	<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
	<script>
		var swiper = new Swiper('#ad-swiper', {
			pagination: '.swiper-pagination',
			nextButton: '.swiper-button-next',
			prevButton: '.swiper-button-prev',
			autoplay: 2500,
			autoplayDisableOnInteraction: false,
			loop: true
		});
	</script>
</html>