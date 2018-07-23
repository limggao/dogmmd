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
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/index.css">
    <title>加油卡充值</title>
</head>
<%	String ss =request.getParameter("openId"); %>
<body>
<div class="phone_recharge">
    <div class="phone">
        <form>
            <input type="number" placeholder="输入加油卡号" style="font-size:1rem;font-weight: 600;color:#4c4c4c;" value="" class="phone_input" />
        </form>
        <span class="iocn_r">
            <img src="../images/iocn/chonhzi_01.png" alt="">
        </span>
    </div>
    <div class="row">
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 col-xs-5 control-label i_olua">持卡人姓名</label>
            <div class="col-sm-5 col-xs-7 shu_ru">
                <input type="text" class="form-control  ba_jd_0i name"  placeholder="李先生">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 col-xs-5 control-label i_olua">持卡人手机号</label>
            <div class="col-sm-5 col-xs-7 shu_ru">
                <input type="number" class="form-control ba_jd_0i phones"  placeholder="请输入手机号">
            </div>
        </div>
    </form>
</div>
    <div class="phone_bill">
        <div class="phone_bill_i">选择金额</div>
        <div class="jiayouka">
        
        </div>
        
        <div class="clear"></div>
    </div>
</div>
<button type="button" class="btn"><a href="#/">立即充值</a></button>
</body>
<script type="application/javascript">

	var rechargeAmount1;
	var recharge;
	var rechargeAmount;
	var pageIndex = 0;
	var pageSize = 8;

	$(function() {
		$
				.ajax({
					url : "/tjekuaitong/PayController/userPages",
					data : {
						"type" : "加油卡充值",
						"pageIndex" : pageIndex,
						"pageSize" : pageSize
					},
					success : function(data) {
						console.info(data);
						var datas = eval(data);
						var strVar = "";
					    strVar += "<ul class=\"recharge_shu_04\" data-recharge=\"bill_i\">\n";
					    strVar += "            <li>"+datas[0].facePrice+"元<\/li>\n";
					    strVar += "            <li>"+datas[0].orderCost+"<\/li>\n";
					    strVar += "        <\/ul>\n";
					    strVar += "        <ul class=\"recharge_shu_03\" data-recharge=\"bill_i\">\n";
					    strVar += "            <li>"+datas[1].facePrice+"元<\/li>\n";
					    strVar += "            <li>"+datas[1].orderCost+"<\/li>\n";
					    strVar += "        <\/ul>\n";
					    strVar += "        <ul class=\"recharge_shu_04\" data-recharge=\"bill_i\">\n";
					    strVar += "            <li>"+datas[2].facePrice+"元<\/li>\n";
					    strVar += "            <li>"+datas[2].orderCost+"<\/li>\n";
					    strVar += "        <\/ul>\n";
					    strVar += "        <ul class=\"recharge_shu_04\" data-recharge=\"bill_i\">\n";
					    strVar += "            <li>"+datas[3].facePrice+"元<\/li>\n";
					    strVar += "            <li>"+datas[3].orderCost+"<\/li>\n";
					    strVar += "        <\/ul>\n";
					    strVar += "        <ul class=\"recharge_shu_03\" data-recharge=\"bill_i\">\n";
					    strVar += "            <li>"+datas[4].facePrice+"元<\/li>\n";
					    strVar += "            <li>"+datas[4].orderCost+"<\/li>\n";
					    strVar += "        <\/ul>\n";
					    strVar += "        <ul class=\"recharge_shu_04\" data-recharge=\"bill_i\">\n";
					    strVar += "            <li>"+datas[5].facePrice+"元<\/li>\n";
					    strVar += "            <li>"+datas[5].orderCost+"<\/li>\n";
					    strVar += "        <\/ul>\n";
						$(".jiayouka").html(strVar);
						ss();
					}
				});

	});
	function ss() {
		$("ul").addClass("color1");
		$("ul").click(
				function() {
					var that = $(this);
					if (that.hasClass("color")) {
						that.removeClass("color").addClass("color1");
						that.attr("data-checked", "0");
					} else {
						that.addClass("color").removeClass("color1").attr(
								"data-checked", "1").siblings("ul")
								.removeClass("color").addClass("color1").attr(
										"data-checked", "0");
					}
					data = that.attr("data-checked");
				});

		$("ul").on("click",function(){    
			recharge =$(this).attr("data-recharge");
			console.info(recharge);
			if(recharge=="bill_i"){
				var arr=$(this).text().split("元");
				console.info(arr[1]);
				rechargeAmount=arr[0];
				rechargeAmount1=arr[1];
			}
		 });
	}




    var w = document.documentElement.clientWidth;
    if(w > 640) {
        w = 640
    }
    document.documentElement.style.fontSize = 20 / 320 * w + 'px';
    window.onresize = function() {
        document.documentElement.style.fontSize = 20 / 320 * w + 'px';
    }
    $(function() {
        $(".phone_input").on("blur", function() {
            var tel = $(this).val()
            if(tel == "") {
                return false
            } else if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(tel))) {
                return false
            }
        })
    })
    

  //获取点击的ul是什么
	
	
    
	//支付按钮
	$(".btn").click(function() {
		var phone =$(".phones").val();
		console.info(phone);
		var gasCardNo = $(".phone_input").val();
	    var name =$(".name").val();
	    console.info(name);
		if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
			alert("请输入正确收手机号");
		}else{
			
			if(name!=null&&name!=""&&gasCardNo!=""&&gasCardNo!=null){
				if(rechargeAmount!=null&&rechargeAmount!=""){
					if(phone!=null&&rechargeAmount1!=null&&recharge!=null&&phone!=""&&rechargeAmount1!=""&&recharge!=""){
						window.location.href="payment_method.jsp?mobileNo="+phone+"&rechargeAmount1="+rechargeAmount1+"&recharge="+recharge+"&rechargeAmount="+rechargeAmount+"&gasCardNo="+gasCardNo+"&gasCardName="+name+"&openId=<%=ss%>";
						}else{
						window.location.href="create-bill-fail.jsp";
						}	
				}else{
					alert("请选择金额！");
				}
				
			}else{
				alert("请输入姓名或加油卡！");
			}
			
		}
	});
</script>

</html>