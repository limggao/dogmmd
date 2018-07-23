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
    <link rel="stylesheet" href="../css/index.css">
    <title>会员中心</title>
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
            <span>会员ID:${data}</span>
            <span class="vip_j"></span>
            <span>会员积分：${vip_j }分</span>
            <span><a href="../pages/phone_recharge1.jsp?openId=${openId }&vip_j=${vip_j }">积分消费</a></span>
        </div>
    </div>
</header>
<!--头部信息结束-->
<!--全部订单开始-->
<nav class="orders">
    <a href="../recharge_record/pending_payment.jsp?openId=${openId }">
        <div class="all_orders">全部订单</div>
        <div class="all_orders_i">
            <img src="../images/iocn/jiantou-icon.png" alt="">
        </div>
    </a>
</nav>
<!--全部订单结束-->
<!--全部订单分类开始-->
<div class="recharge">
    <div class="iocn_p">
        <a href="../recharge_record/pending_payment.jsp?openId=${openId }">
            <div class="phone_iocn">
                <img src="../images/iocn/ffk.png" alt="">
            </div>
            <div class="iocn_text">已缴费</div>
        </a>
    </div>
    <div class="iocn_p">
        <a href="../recharge_record/recharge_in.jsp?openId=${openId }">
            <div class="phone_iocn">
                <img src="../images/iocn/czz.png" alt="">
            </div>
            <div class="iocn_text">待缴费</div>
        </a>
    </div>
    <div class="iocn_p">
        <a href="../recharge_record/Invalid.jsp?openId=${openId }">
            <div class="phone_iocn">
                <img src="../images/iocn/shx.png" alt="">
            </div>
            <div class="iocn_text">失败</div>
        </a>
    </div>
    <div class="clear"></div>
  </div>
  <div class="order_form">
    <nav class="orders">
        <a href="#">
            <div class="all_orders">积分记录</div>
            <div class="all_orders_i">
                <img src="../images/iocn/jiantou-icon.png" alt="">
            </div>
        </a>
    </nav>
    <!--全部订单结束-->
    <!--全部订单分类开始-->
    <div class="recharge">
        <div class="iocn_p">
            <a href="../earned_points/Earned_points.jsp?openId=${openId }">
                <div class="phone_iocn">
                    <img src="../images/iocn/integration.png" alt="">
                </div>
                <div class="iocn_text">积分赚取</div>
            </a>
        </div>
        <div class="iocn_p">
            <a href="../earned_points/integral_detail.jsp?openId=${openId }">
                <div class="phone_iocn">
                    <img src="../images/iocn/integration1.png" alt="">
                </div>
                <div class="iocn_text">花费明细</div>
            </a>
        </div>
        <div class="clear"></div>
    </div>
</div>

<!--全部订单分类结束-->
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
</script>
</html>