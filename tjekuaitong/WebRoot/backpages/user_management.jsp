<%@page import="com.tjekuaitong.service.impl.UserServiceImpl"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
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
    <script src="../js/jquery.pagination.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/styles.css">
    <title>用户管理</title>
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
                <li>
                    <a href="index.jsp">首页</a>
                </li>
                <li class="action">
                
                    <a href="user_management.jsp">用户管理</a>
                </li>
                <li>
                   <a href="payment_management.jsp">缴费管理</a>
                </li>
                <li >
                    <a href="earned_points.jsp">积分兑换</a>
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
    <div class="user col-lg-10 col-sm-10">
        <table class="table table-bordered">
            <thead>
            <tr class="i_g_box">
                
                <th>用户ID</th>
                <th>微信头像</th>
                <th>微信昵称</th>
                <th>微信号</th>
                <th>注册时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody class="ss">
            	
            	
            	
            </tbody>
        </table>
    </div>
    <ul class="pagination">
    </ul>
    </div>
</body>
<script>
	var index=0;
    $(function() {
        $("#hear li").click(function() {
            $(this).css({
                backgroundColor: "#9d9ea1",
                height: "100%"
            }).siblings().css({
                backgroundColor: "#fff",
                height: "55px"
            });
        });
        
    });
    
    var pageIndex = 0;
    var pageSize = 10;
    
    $(function() {       
        InitTable(0);              
        $.ajax({
			url:'/tjekuaitong/UserController/index',
			success:function(data){
				$(".pagination").pagination(data, {
		            callback: PageCallback,
		            prev_text: '上一页',
		            next_text: '下一页',
		            items_per_page: pageSize,
		            ellipse_text:'...',
		            num_display_entries: 6,//连续分页主体部分分页条目数
		            current_page: pageIndex,//当前页索引
		            num_edge_entries: 2//两侧首尾分页条目数
		        });
			}
		});
        //翻页调用
        function PageCallback(index, jq) {           
            InitTable(index);
        }
        //请求数据
        function InitTable(pageIndex) {                                
            $.ajax({ 
                type: "POST",
                dataType: "json",
                url: '/tjekuaitong/UserController/userPage',
                data: "pageIndex=" +  pageIndex   + "&pageSize=" + pageSize,
                success: function(data) { 
                  var zz="";
                  var datas= eval(data);   
                  for(var i=0;i<datas.length;i++){   
                	  console.info(datas[i]);
                	  zz +="<tr class='cen_io_g'><td>"+datas[i].userId+"</td><td><div class='head'><img src='"+datas[i].headimgurl+"' alt=''></div></td><td>"+datas[i].nickname+"</td><td></td><td>"+datas[i].subscribe_time+"</td><td class='chr_zh'>删除</td></tr>";
                	  
                  }
                  console.info(zz);
                  $(".ss").html(zz);
                  // 
                   //
                }
            });            
        }
    });
</script>
</html>