<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="description" content="">
		<meta name="renderer"content="webkit">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/swiper.min.css">
		<link rel="stylesheet" href="../css/index.css">
		<title>申请信用卡</title>
	</head>
	<body>
		<!--头部信息开始-->
		<header class="information">
			<a href="member_center.html">
				<div class="head_portrait">
				 <img src="${headimgurl }" alt="">
			    </div>
			</a>
			<div class="ip_information">
				<h5 class="head_m">${name }</h5>
				<div class="vip_integral">
					<span>会员ID：${data}</span>
					<span class="vip_j"></span>
					<span>会员积分：${vip_j }分</span>
				</div>
			</div>
		</header>
		<!--头部信息结束-->
		<!--中间部分开始-->
	    <div class="Credit">
	    	<div class="be_jing">
	    		<div>申请信用卡</div>
	    	</div>
	    	<div class="Credit_iocn">
	    		<div class="me_she">
	    			<img src="../images/minsheng.png"/>
	    		</div>
	    		<div class="min_text">民生银行<i>信用卡</i></div>
	    		<div class="_Apply">
	    			<div class="shen_qin"><a href="https://creditcard.cmbc.com.cn/wsonline/home/homeHZ.jhtml?recommendInfo=GAfBxNx/nkXk/5E9/lWxF2oe7bdJe6Yp94mllUsY4Sc4rwFb0HAP35pa5aILDpGFXwXI+dZnWnyuOL0jITIrdn1bBfvVQHHygHZe8/ZrAZNUxxxVtZV2APP04bBYiV87pg0Q6rZs0f8IB8w+elOD4KYK7t/qsulp743Goj4e+K2pWJdwI53+by2MFwPxCgGV7rUe1+LDB1zJNGLdQ93ulAhSxRssx1m1845GZ9fCXgd2/rs+wGTZ8OBnpNjypp4lga1S6STVg8Ff/kqWv78sRlbatE+fQT0CdwBysSDRRfKXRXdrO5EpWrOOp6k3PrQcMyJMKhi3NVonw8se131Vng==&time=1497944213481">申请</a></div>
	    			<div class="jian_douy">
	    				<img src="../images/iocn/jiantou-icon.png"/>
	    			</div>
	    		</div>
	    		<div class="clear"></div>
	    	</div>
	    	<div class="Credit_iocn">
	    		<div class="me_she">
	    			<img src="../images/pufa.png"/>
	    		</div>
	    		<div class="min_text">浦发银行<i>信用卡</i></div>
	    		<div class="_Apply">
	    			<div class="shen_qin"><a href="https://ecentre.spdbccc.com.cn/creditcard/indexActivity.htm?data=P1748661&itemcode=2017062001">申请</a></div>
	    			<div class="jian_douy">
	    				<img src="../images/iocn/jiantou-icon.png"/>
	    			</div>
	    		</div>
	    		<div class="clear"></div>
	    	</div>
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
</html>
