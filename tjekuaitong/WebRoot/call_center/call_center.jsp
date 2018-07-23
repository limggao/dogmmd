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
    <link rel="stylesheet" href="../css/call_center.css">
    <title>客服中心</title>
</head>
<body style="background-color: #fff">
<div class="call_center">
    <div class="contact_io">
        <h3>客服中心</h3>
    </div>
    <div class="img_call_center">
        <img src="../images/krzhx.png" alt="">
    </div>
    <hr/>
    <div class="telephone_numbers">
        <div class="call_center_03">客服微信：</div>
        <ul class="call_center_01">
            <li><a href="#">ekuaitong1</a></li>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="telephone_numbers">
        <div class="call_center_03">客服QQ：</div>
        <ul class="call_center_01">
            <li><a href="#">2173829376</a></li>
        </ul>
        <div class="clear"></div>
    </div>
    <div class="telephone_numbers">
        <div class="call_center_03">客服电话：</div>
        <ul class="call_center_01">
          <li><a href="tel:022-84931668">022-84931668</a></li>
          <li><a href="tel:15722243186">15722243186</a></li>
          <li><a href="tel:15722243156">15722243156</a></li>
        </ul>
        <div class="clear"></div>
    </div>
</div>
</body>
<script type="text/javascript">
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