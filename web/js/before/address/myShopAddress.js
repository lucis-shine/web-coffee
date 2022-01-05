function submitCart(){
	//验证余额是否充足
	//可以进行支付
	var addressId = $('input[name="def"]:checked').val();
	var cart = new Object();
	cart.addressId = addressId;
	cart.m = "submitCart";
	console.log(cart);
	$.ajax({
		//请求方式  同步 false  异步true
        async:true,
        //请求方式
        type : "POST",
        //请求地址
        url : path+"/filter/before/cart",
        //数据，json字符串,
        //返回值的类型
        dataType: "json",
        data : cart,
        //请求成功
        success : function(result) {
            console.log(result);
            if('true'==$.trim(result)){
            	location.href=path+'/filter/before/orders?m=list';//跳转到查看订单列表页面
            }else{
            	$("#resultInfo").text("修改失败");
            	$("#resultInfo").css("color","red");
            }
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }

	});
	
}
