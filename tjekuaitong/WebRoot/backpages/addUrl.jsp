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
    <script src="../js/ajaxfileupload.js"></script>
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
                <li>
                
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
                <li class="action">
                    <a href="addUrl.jsp">添加推送信息</a>
                </li>
                <li>
                    <a href="Login.jsp">退出管理</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="user col-lg-10 col-sm-10">
    	<div style="margin-left:22%;margin-top: 8%;">
                       标题:<input type="text" style="width: 500px;" class="title">
        <br><br>
                      图片:<br>
         <div class="col-sm-9 big-photo">
                	<div id="preview">
                        <img id="imghead" border="0" src="../images/photo_icon.png" width="120" height="120" onclick="$('#previewImg').click();">
                     </div>         
                    <input type="file" onchange="previewImage(this)" style="display: none;" id="previewImg" name="file">
         </div>
         <br><br><br><br><br><br><br><br><br><br>
         <div>
                     网站路径:
         <input type="text" style="width: 500px;" class="url">
         </div> 
        </div>
         <br><br>
        <button class="btn" style="width: 20%; margin-left:30%;">保存</button>
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
    function previewImage(file)
    {
      var MAXWIDTH  = 120; 
      var MAXHEIGHT = 120;
      var div = document.getElementById('preview');
      if (file.files && file.files[0])
      {
          div.innerHTML ='<img id=imghead onclick=$("#previewImg").click()>';
          var img = document.getElementById('imghead');
          img.onload = function(){
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            img.width  =  rect.width;
            img.height =  rect.height;
//             img.style.marginLeft = rect.left+'px';
            img.style.marginTop = rect.top+'px';
          }
          var reader = new FileReader();
          reader.onload = function(evt){img.src = evt.target.result;}
          reader.readAsDataURL(file.files[0]);
      }
      else //兼容IE
      {
        var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
        file.select();
        var src = document.selection.createRange().text;
        div.innerHTML = '<img id=imghead>';
        var img = document.getElementById('imghead');
        img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
        status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
        div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
      }
    }
    function clacImgZoomParam( maxWidth, maxHeight, width, height ){
        var param = {top:0, left:0, width:width, height:height};
        if( width>maxWidth || height>maxHeight ){
            rateWidth = width / maxWidth;
            rateHeight = height / maxHeight;
            
            if( rateWidth > rateHeight ){
                param.width =  maxWidth;
                param.height = Math.round(height / rateWidth);
            }else{
                param.width = Math.round(width / rateHeight);
                param.height = maxHeight;
            }
        }
        param.left = Math.round((maxWidth - param.width) / 2);
        param.top = Math.round((maxHeight - param.height) / 2);
        return param;
    }
    
    
    
    $(".btn").click(function(){
    	var title=$(".title").val();
    	var url=$(".url").val();
    	var PicUrl=document.getElementById("imghead").src;
    	var name=$("#previewImg").val();
    	console.info(name);
    	console.info(PicUrl);
    	if(title==null||url==null||url==''||title==''||PicUrl=='http://wx.tjaxej.com/tjekuaitong/images/photo_icon.png'){
    		alert('请添加数据');
    	}else{
    		   $.ajaxFileUpload({ 
                //ajaxfileupload.js是用来上传文件的，自定义form已经被写定  method=“post”，所以没有“method”或者“type”
                url:"/tjekuaitong/fileUploadController/login",//需要链接到服务器地址  
                secureuri:true,
                isMore:false, //是否为多文件上传
                fileElementId:"previewImg",//文件选择框的id属性，多文件为id[]/单文件为'id' 
                dataType:"json",//接收JSON类型
               /*  contentType:"serial",//发送类型“serial”,为空默认为JSON */
                data:{"Title":title,"PicUrl":name,"Url":url},
                success: function(data,status){ 
                	if(data){
                		alert("上传成功");
                		location.replace(document.referrer);
                	}
                //上传成功之后的操作
                },error: function (data,status){ 
                //上传失败之后的操作
                		 alert("上传失败");
                }  
            });   
    	}
    	
    });
</script>
</html>