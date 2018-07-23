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
    <title>用户管理</title>
</head>

<body>
<div class="backstage row">
    <div class="top_text">
        <h4>后台登录系统</h4>
    </div>
    <div data-role="page">
        <div data-role="content-floud" class="col-lg-2 col-sm-2 left">
            <ul id="hear">
                <li>
                    <a href="index.html">首页</a>
                </li>
                <li class="action">
                    <a href="">用户管理</a>
                </li>
                <li>
                    <a href="">缴费管理</a>
                </li>
                <li>
                    <a href="">订单管理</a>
                </li>
                <li>
                    <a href="#">退出管理</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="user col-lg-10 col-sm-10">
        <table class="table table-bordered">
            <thead>
            <tr class="i_g_box">
                <th>序号</th>
                <th>用户ID</th>
                <th>微信头像</th>
                <th>微信昵称</th>
                <th>微信号</th>
                <th>注册时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr class="cen_io_g">
                <td>1</td>
                <td>10010</td>
                <td>
                    <div class="head">
                        <img src="../images/user.jpg" alt="">
                    </div>
                </td>
                <td>富可敌国</td>
                <td>weizhici</td>
                <td>2017/03/28</td>
                <td class="chr_zh">删除</td>
            </tr>
            
            </tbody>
        </table>
    </div>
    
    <div class="pagination">
        <!--  <li><a href="#">&laquo;</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>  -->
    </div>
    </div>
</body>
<script>
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
    var pageSize = 5;
    
    $(function() {       
        InitTable(0);              

        $(".pagination").pagination(6, {
            callback: PageCallback,
            prev_text: '上一页',
            next_text: '下一页',
            items_per_page: pageSize,
            num_display_entries: 6,//连续分页主体部分分页条目数
            current_page: pageIndex,//当前页索引
            num_edge_entries: 2//两侧首尾分页条目数
        });

        //翻页调用
        function PageCallback(index, jq) {           
            InitTable(index);
        }
        //请求数据
        function InitTable(pageIndex) {                                
            $.ajax({ 
                type: "POST",
                dataType: "text",
                url: '/tjekuaitong/UserController/userPage',
                data: "pageIndex=" + (pageIndex + 1) + "&pageSize=" + pageSize,
                success: function(data) {                                 
                   console.info(data)
                }
            });            
        }
    });
</script>
</html>