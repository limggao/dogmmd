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
    <title>缴费管理</title>
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
                <li>
                    <a href="user_management.jsp">用户管理</a>
                </li>
                <li class="action">
                    <a href="payment_management.jsp">缴费管理</a>
                </li>
                <li>
                    <a href="order_management.jsp">订单管理</a>
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
    <div class="col-lg-10 col-sm-10 xinshi">
        <div class="type_box">
            <div class="type">缴费种类</div>
            <select id="demo01" name="customSelectForm" class="selection">
                <option value="1"><a href="#">手机充值</a></option>
                <option value="2">加油卡充值</option>
                <option value="3">Q币充值</option>
                <option value="4">天津固话充值</option>
                <option value="5">交通缴费</option>
                <option value="6">游戏充值</option>
                <option value="7">申请信用卡</option>
                <option value="8">转发赚积分</option>
                <option value="9">推广赚积分</option>
            </select>
        </div>
        <table class="table table-bordered">
            <thead>
            <tr class="i_g_box">
                <th>序号</th>
                <th>套餐选择</th>
                <th>实际缴费金额</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span class="edit"><a href="edit_data.jsp">编辑</a></span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            <tr class="cen_io_g">
                <td>1</td>
                <td>100</td>
                <td>
                    <form action="" class="lre_y">
                        <input type="text" name="" value="">
                    </form>
                </td>
                <td class="chr_zh"><span>编辑</span><span class="feng"></span><span>删除</span></td>
            </tr>
            </tbody>
        </table>
    </div>
    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>
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
</script>
</html>