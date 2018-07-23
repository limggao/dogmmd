<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstraps.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/styles.css">
    <title>管理系统首页</title>
</head>
<%Object abc=session.getAttribute("user");
if(abc==null){
 response.sendRedirect("Login.jsp");
}
 %>
<body>
<div class="backstage row">
    <div class="top_text">
        <h4>后台登录系统</h4>
    </div>
    <div data-role="page">
        <div data-role="content-floud" class="col-lg-2 col-sm-2 left">
            <ul id="hear">
                <li class="action">
                     <a href="index.jsp">首页</a>
                </li>
                <li>
                   <a href="user_management.jsp">用户管理</a>
                </li>
                <li>
                    <a href="payment_management.jsp">缴费管理</a>
                </li>
                <li>
                    <a href="order_management.jsp">订单管理</a>
                </li>
                <li>
                    <a href="payment_modification.jsp">支付修改方式</a>
                </li>
                <li>
                    <a href="addUrl.jsp">添加推送信息</a>
                </li>
                <li>
                    <a href="Login.jsp">退出管理</a>
                </li>
            </ul>
        </div>
    </div>
  <div class="center col-sm-6 col-lg-6">
        <h4>网址基本信息</h4>
        <table class="table table-bordered sheet">
            <tbody>
            <tr>
                <td>单页面数：</td>
                <td>6</td>
                <td>文章总数：</td>
                <td>15</td>
            </tr>
            <tr>
                <td>商品总数：</td>
                <td>15</td>
                <td>系统语言：</td>
                <td>zh_cn</td>
            </tr>
            <tr>
                <td>URL:</td>
                <td class="off_ido">关闭<span>（点击开启）</span></td>
                <td>编码：</td>
                <td>UTL-8</td>
            </tr>
            <tr>
                <td>站点地图:</td>
                <td>开启</td>
                <td>站点模板：</td>
                <td>default</td>
            </tr>
            <tr>
                <td>DouPHP版本：</td>
                <td>V1.3 Release 20170329</td>
                <td>安装日期：</td>
                <td>2017-03-28</td>
            </tr>
            <tr>
                <td>单页面数：</td>
                <td>6</td>
                <td>文章总数：</td>
                <td>15</td>
            </tr>
            <tr>
                <td>商品总数：</td>
                <td>15</td>
                <td>系统语言：</td>
                <td>zh_cn</td>
            </tr>
            <tr>
                <td>URL:</td>
                <td class="off_ido">关闭<span>（点击开启）</span></td>
                <td>编码：</td>
                <td>UTL-8</td>
            </tr>
            <tr>
                <td>站点地图:</td>
                <td>开启</td>
                <td>站点模板：</td>
                <td>default</td>
            </tr>
            <tr>
                <td>DouPHP版本：</td>
                <td>V1.3 Release 20170329</td>
                <td>安装日期：</td>
                <td>2017-03-28</td>
            </tr>
            </tbody>
        </table>
  </div>
   <div class="right col-sm-3 col-lg-3 ">
       <h4>管理员 登记记录</h4>
       <table class="table table-bordered sheet">
           <thead>
           <tr>
               <th>IP地址</th>
               <th>操作时间</th>
           </tr>
           </thead>
           <tbody>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr> <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>
           <tr>
               <td>127.0.0.10</td>
               <td>2017-03-28 11:23:30</td>
           </tr>

           </tbody>
       </table>
   </div>
</div>
</body>
<script>
    $(function() {
        $("#hear li").click(function() {
            $(this).css({
                backgroundColor: "#b5bbbf",
                height: "100%"
            }).siblings().css({
                backgroundColor: "#fff",
                height: "55px"
            });
        });
    });
</script>
</html>