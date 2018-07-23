<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>充值成功</title>
    <style>
        .success{
            width: 16rem;
            height: 8rem;
            border:1px solid #333;
            margin: 50% auto;
        }
        .success_box{
            width: 3rem;
            height: 3rem;
            margin: 5% auto;
        }
        .success_box img{
            width: 100%;
            height: 100%;
        }
        .serial_number{
            font-size: 1rem;
            line-height: 1.5rem;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="success">
    <div class="success_box">
        <img src="../images/ic_success.png" alt="">
    </div>
    <div class="serial_number">序列号:<sapn>${billid }</sapn></div>
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
</script>
</html>