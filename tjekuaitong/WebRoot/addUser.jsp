<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html >  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title>  
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/ajaxfileupload.js"></script> 
<script type="text/javascript">  
	function add(){
	     //ajax可以支持任何类型得JSON；ajaxfileupload只支持Fastjson
        $.ajax({ 
            url:"pictures/get",//需要链接到服务器地址  
            dataType:"json",
            type:"post",
            data:$('input[name]').serialize(),
            success: function(data,status){ 
            //上传成功之后的操作
             alert(status);
            },error: function (data,status){ 
            //上传失败之后的操作
              alert(status);
            }  
        });
	}
	
</script>  
</head>  
<body>  
    <h1>添加用户</h1>  
     M：<input type="text" name="user.id">  
  ID：<input type="text" name="page">   
        <input type="button" value="添加" onclick="add()">  
</body>  
</html>  