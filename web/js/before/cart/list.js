function changeNum(cartItemId,cartItemNum,t){
	//alert(t.value);
	//this代表JavaScript中的this   改变为jquery对象
	var jqueryThis = $(t);
	//alert(jqueryThis.val());
	if(jqueryThis.val()==''){
		alert("商品数量不能为空!!!");
		jqueryThis.val(cartItemNum);
		return;
	}
	//alert("修改购物项的id="+cartItemId);
	var cart = new Object();
	cart.id=cartItemId;
	cart.num=jqueryThis.val();
	cart.m = "updateCartItemNum";
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
            	location.href=path+'/filter/before/cart?m=list';//跳转到查看地址列表页面
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

function remove(cartItemId){
	var cart = new Object();
	cart.id=cartItemId;
	cart.m = "remove";
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
            	location.href=path+'/filter/before/cart?m=list';//跳转到查看地址列表页面
            }else{
            	$("#resultInfo").text("删除失败");
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